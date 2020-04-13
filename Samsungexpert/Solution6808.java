package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution6808 {

	/*
	 * [삼성] 규영이와 인영이의 카드게임
	 * 
	 * 1. 이기는 경우와 지는 경우의 수
	 * 
	 * 2. 9!
	 * 
	 * 3. 순열로 순서 짜고 구하기
	 */
	static ArrayList<Integer> list1, list2;
	static int win,lose;
	static int[] order;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
			win = 0; lose = 0;
			order = new int[9];
			visit = new boolean[9];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				list1.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 1; i <= 18; i++) {
				if(!list1.contains(i))list2.add(i);
			}
			
			go(0,0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	private static void go(int idx, int cnt) {
		if(idx == 9) {
			solve();
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[idx] = i;
				go(idx + 1, cnt + 1);
				order[idx] = 0;
				visit[i] = false;
			}
		}
	}

	private static void solve() {
		int sum1=0, sum2=0;
		
		for (int i = 0; i < 9; i++) {
			if(list1.get(i) > list2.get(order[i])) {
				sum1 +=list1.get(i) + list2.get(order[i]);
			}else {
				sum2 +=list1.get(i) + list2.get(order[i]);
			}
		}
		
		if(sum1 > sum2)win++;
		else lose++;
	}
}
