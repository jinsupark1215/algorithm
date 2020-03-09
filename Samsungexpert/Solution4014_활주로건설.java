package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014_활주로건설 {

	/*
	 * 1. 활주로를 설치할 수 있는 개수
	 * 
	 * 2. N<=20, X<=4
	 * 
	 * 3. 구현
	 */
	static int N, X, ans;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				if(go(i,0,true))ans++;
				if(go(0,i,false))ans++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static boolean go(int r, int c, boolean garo) {
		int[] height = new int[N];
		boolean[] visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			if(garo)height[i] = map[r][i];
			else height[i] = map[i][c];
		}
		
		for (int i = 0; i < N-1; i++) {
			if(height[i] == height[i+1])continue;
			
			if(Math.abs(height[i+1] - height[i]) >1)return false;
			
			//Up
			if(height[i]+1 == height[i+1]) {
				for (int j = i; j > i-X; j--) {
					if(j ==-1 ||height[j] != height[i] || visit[j])return false;
					visit[j] = true;
				}
			}
			
			//down
			if(height[i]-1 == height[i+1]) {
				for (int j = i+1; j <= i+X; j++) {
					if(j ==N || height[j] != height[i+1] || visit[j])return false;
					visit[j] = true;
				}
			}
		}
		return true;
	}
}
