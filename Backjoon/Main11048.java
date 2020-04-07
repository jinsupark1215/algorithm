package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11048 {

	/*
	 * 1. 사탕 최대값
	 * 
	 * 2. N,M <= 1000
	 * 
	 * 3. dfs 완탐 - >시간초과
	 * dp 이용
	 */
	static int n,m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j] += Math.max(map[i][j-1], Math.max(map[i-1][j], map[i-1][j-1]));
			}
		}
		System.out.println(map[n][m]);
	}
}
