package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1932 {

	/*
	 * [백준] 정수 삼각형
	 * 
	 * 1. 합이 최대가 되는 경로의 수의 합
	 * 
	 * 2. n <=500
	 * 
	 * 3. dp 이용
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][N];
		dp[0][0] = map[0][0];
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] +map[i+1][j]);
				dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j] + map[i+1][j+1]);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[N-1][i]);
		}
		System.out.println(ans);
	}
}
