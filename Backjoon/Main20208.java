package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main20208 {

	/*
	 * [백준] 진우의 민트초코우유
	 * 1. 민트초코 최대 섭취수
	 * 
	 * 2. 
	 * 
	 * 3. 조합짜서 먹기
	 */
	
	static int N,M,H,ans;
	static int[] home, pick;
	static boolean[] visit;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					home = new int[]{i,j};
				}else if(input == 2) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		pick = new int[list.size()];
		visit = new boolean[list.size()];
		per(0);
		
		System.out.println(ans);
	}

	private static void per(int idx) {
		if(idx > ans)go(idx);
		
		if(idx != list.size()) {
			for (int i = 0; i < list.size(); i++) {
				if(!visit[i]) {
					visit[i] = true;
					pick[idx] = i;
					per(idx+1);
					visit[i] = false;
				}
			}
		}
	}

	private static void go(int size) {
		int cnt = 0, hp=M,r=home[0],c= home[1], cost;
		
		for (int i = 0; i < size; i++) {
			cost = Math.abs(r - list.get(pick[i])[0]) + Math.abs(c - list.get(pick[i])[1]);
			if(cost <= hp) {
				hp += H - cost;
				r = list.get(pick[i])[0];
				c = list.get(pick[i])[1];
				cnt++;
			}else {
				return;
			}
		}
		if(Math.abs(r-home[0]) + Math.abs(c - home[1]) <= hp) {
			ans = Math.max(ans, cnt);
		}
	}
}
