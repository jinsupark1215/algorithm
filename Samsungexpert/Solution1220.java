package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1220 {

	/*
	 * 1. 교착상태인 자성체의 수를 구하라
	 * 
	 * 2. map 100 X 100 , 셋 이상의 충돌해도 하나의 교착상태로 판단
	 * 
	 * 3. 1을 찾아서 내려가면서 2를 만나면 체크
	 */
	
	static int N, ans;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase <=10; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						dfs(i,j,map[i][j]);
					}
				}
			}
			System.out.println("#" + testcase+ " " + ans);
		}
	}
	private static void dfs(int r, int c, int num) {
		visit[r][c] = true;
		
		if(r+1 < N) {
		if(num == 1) {
			if(map[r+1][c] == 0 ||map[r+1][c] == 1) {
				dfs(r+1,c,1);
			}else if(map[r+1][c] == 2) {
				ans++;
				dfs(r+1,c,map[r+1][c]);
			}
		}else if(num ==2 && map[r+1][c] == 2) {
			dfs(r+1,c,map[r+1][c]);
		}
		}
	}
	
}

