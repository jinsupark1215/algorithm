package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17351 {

	/*
	 * [백준] 3루수는 몰라
	 * 
	 * 1. MOLA를 가장 많이 포함한 애
	 * 
	 * 2. N <=500
	 * 
	 * 3. dp 이용
	 */
	static final char[] MOLA = "MOLA".toCharArray();
	static int[][] pos = {{1,0},{0,1}};
	static int N;
	static char[][] map;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N+1][N+1];
		dp = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = input.charAt(j-1);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (map[i][j] == 'A') {
					dp[i][j] = Math.max(dp[i][j], solve(i, j, 2));
				}
			}
		}

		System.out.println(dp[N][N]);
	}
	public static int solve(int r, int c, int idx) {
		if (idx == -1) {
			return dp[r][c] + 1;
		}
		int ret = 0;
		for (int i = 0; i < 2; i++) {
			int nr = r - pos[i][0];
			int nc = c - pos[i][1];
			if (nr > 0 && nc > 0 && map[nr][nc] == MOLA[idx]) {
				ret = Math.max(ret, solve(nr, nc, idx - 1));
			}
		}
		return ret;
	}
}
