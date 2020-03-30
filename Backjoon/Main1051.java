package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1051 {

	/*
	 * [백준] 숫자 정사각형
	 * 
	 * 1. 가장 큰 정사각형의 크기를 구하여라
	 * 
	 * 2. N,M <=50
	 * 
	 * 3. 완탐
	 */
	static int N, M, ans;
	static int[][] map;
	static int[][] pos = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 1;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 1);
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int length) {
		if (length >= N || length >= M)
			return;

		boolean flag = false;

		for (int i = 0; i < 3; i++) {
			int nr = r + (pos[i][0] * length);
			int nc = c + (pos[i][1] * length);
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (map[r][c] == map[nr][nc])
					flag = true;
				else
					flag = false;
			} else {
				flag = false;
			}
			if (!flag)
				break;
		}

		if (flag) {
			ans = Math.max(ans, (length + 1) * (length + 1));
		}
		dfs(r, c, length + 1);
	}
}
