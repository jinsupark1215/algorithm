package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2383 {

	/*
	 * 1. 최소 소요시간 구하기
	 * 
	 * 2. N <= 10, 사람수 <=10, 계단 입구 만드시 두개
	 * 
	 * 3. 조합 + 시뮬
	 */
	static int N, ans;
	static ArrayList<Point> people;
	static int[][] map, down;
	static int[] chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			map = new int[N][N];
			down = new int[2][3];
			people = new ArrayList<>();
			
			int idx = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)people.add(new Point(i,j));
					else if(map[i][j] > 1) {
						if(idx ==0) {
							down[0][0] = i;
							down[0][1] = j;
							down[0][2] = map[i][j];
							idx++;
						}else {
							down[1][0] = i;
							down[1][1] = j;
							down[1][2] = map[i][j];
						}
					}
				}
			}
			chk = new int[people.size()];
			
			Combi(0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void Combi(int idx) {
		if(idx == people.size()) {
			chk();
//			System.out.println(Arrays.toString(chk));
			return;
		}
		
		for (int i = idx; i < people.size(); i++) {
			chk[i] = 1;
			Combi(i+1);
			chk[i] = 0;
			Combi(i+1);
		}
	}
	private static void chk() {
		// 구멍 2개에 큐를 두어 순서대로 들어오는 
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		for (int i = 0; i < chk.length; i++) {
			if(chk[i] == 0) {
				list1.add(Math.abs(people.get(i).r - down[0][0]) + Math.abs(people.get(i).c - down[0][1])+1);
			}else {
				list2.add(Math.abs(people.get(i).r - down[1][0]) + Math.abs(people.get(i).c - down[1][1])+1);
			}
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		int max = 0;
		if(list1.size() <= 3 && list2.size() <= 3) {
			for (int i = 0; i < list1.size(); i++) {
				max = Math.max(max, list1.get(i)+down[0][2]);
			}
			for (int i = 0; i < list2.size(); i++) {
				max = Math.max(max, list2.get(i)+down[1][2]);
			}
		}else if(list1.size() > 3 && list2.size() <= 3) {
			for (int i = 0; i < list2.size(); i++) {
				max = Math.max(max, list2.get(i)+down[1][2]);
			}
			for (int i = 0; i < 3; i++) {
				max = Math.max(max, list1.get(i)+down[0][2]);
			}
			for (int i = 3; i < list1.size(); i++) {
				if(list1.get(i-3)+down[0][2] - list1.get(i) <= 0) {
					max = Math.max(max, list1.get(i)+down[0][2]);
				}else {
					max = Math.max(max, list1.get(i)+down[0][2]+(list1.get(i-3)+down[0][2] - list1.get(i)));
				}
			}
		}else if(list1.size() <= 3 && list2.size() > 3) {
			for (int i = 0; i < list1.size(); i++) {
				max = Math.max(max, list1.get(i)+down[0][2]);
			}
			for (int i = 0; i < 3; i++) {
				max = Math.max(max, list2.get(i)+down[1][2]);
			}
			for (int i = 3; i < list2.size(); i++) {
				if(list2.get(i-3)+down[1][2] - list2.get(i) <= 0) {
					max = Math.max(max, list2.get(i)+down[1][2]);
				}else {
					max = Math.max(max, list2.get(i)+down[1][2]+(list2.get(i-3)+down[1][2] - list2.get(i)));
				}
			}
		}else {
			for (int i = 0; i < 3; i++) {
				max = Math.max(max, list1.get(i)+down[0][2]);
			}
			for (int i = 3; i < list1.size(); i++) {
				if(list1.get(i-3)+down[0][2] - list1.get(i) <= 0) {
					max = Math.max(max, list1.get(i)+down[0][2]);
				}else {
					max = Math.max(max, list1.get(i)+down[0][2]+(list1.get(i-3)+down[0][2] - list1.get(i)));
				}
			}
			for (int i = 0; i < 3; i++) {
				max = Math.max(max, list2.get(i)+down[1][2]);
			}
			for (int i = 3; i < list2.size(); i++) {
				if(list2.get(i-3)+down[1][2] - list2.get(i) <= 0) {
					max = Math.max(max, list2.get(i)+down[1][2]);
				}else {
					max = Math.max(max, list2.get(i)+down[1][2]+(list2.get(i-3)+down[1][2] - list2.get(i)));
				}
			}
		}
		ans = Math.min(ans, max);
		
	}
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}

