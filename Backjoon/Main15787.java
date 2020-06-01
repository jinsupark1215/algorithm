package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main15787 {

	/*
	 * [백준] 기차가 어둠을 헤치고 은하수를
	 * 
	 * 1. 은하수를 지나는 기차의 수?
	 * 
	 * 2. N<= 100000, M <= 100000
	 * 
	 * 3. 배열로 해당 명령 수행 M번 후
	 * 문자열로 만든 후 Set 삽입
	 */
	static int N, M;
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][20];
		
		int order, train, seat = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			order = Integer.parseInt(st.nextToken());
			train = Integer.parseInt(st.nextToken())-1;
			if(order == 1 || order ==2) {
			seat = Integer.parseInt(st.nextToken())-1;
			}
			
			go(order,train,seat);
		}
		
		Set<String> set = new HashSet<>();
		StringBuilder sb;
		for (int i = 0; i < N; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < 20; j++) {
				if(!map[i][j]) {
					sb.append(j);
				}
			}
			set.add(sb.toString());
		}
		
		System.out.println(set.size());
	}
	private static void go(int order, int train, int seat) {
		if(order ==1) {
			map[train][seat] = true;
		}else if(order == 2) {
			map[train][seat] = false;
		}else if(order == 3) {
			for (int i = 19; i > 0; i--) {
				map[train][i] = map[train][i-1];
			}
			map[train][0] = false;
		}else {
			for (int i = 0; i < 19; i++) {
				map[train][i] = map[train][i+1];
			}
			map[train][19] = false;
		}
	}
}
