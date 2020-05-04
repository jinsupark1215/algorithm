package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11909 {

	/*
	 * [백준] 배열탈출
	 * 
	 * 1. 최소비용을 들어 출구에 도착해라
	 * 
	 * 2. n <=2222
	 * 
	 * 3. BFS - > 메모리초과
	 * 
	 * dp 이용
	 */
	static int[][] pos = { { 1, 0 }, { 0, 1 } };
	static int N;
	static int[][] map, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		dp[0][0] = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != N - 1) {
					if (map[i + 1][j] >= map[i][j]) {
						dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + map[i + 1][j] - map[i][j] + 1);
					} else {
						dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
					}
				}
				if (j != N - 1) {
					if (map[i][j + 1] >= map[i][j]) {
						dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + map[i][j + 1] - map[i][j] + 1);
					} else {
						dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j]);
					}
				}
			}
		}

		System.out.println(dp[N-1][N-1]);
	}
}
