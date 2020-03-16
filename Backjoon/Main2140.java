package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2140 {

	/*
	 * 1. 지뢰의 최대 갯수
	 * 
	 * 2. N <=100
	 * 
	 * 3. 지뢰기준 8방향에 0이 있으면 지뢰 X
	 */
	static int N, ans;
	static int[][] map;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				if (input.charAt(j) - '0' >= 0 && input.charAt(j) - '0' < 9) {
					map[i][j] = input.charAt(j) - '0';
				} else {
					map[i][j] = 9;
				}
			}
		}
		if (N <= 2) {
			ans = 0;
		} else {
			ans = (N - 2) * (N - 2);

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (i == 1 || j == 1 || i == N - 2 || j == N - 2) {
						if (chk(i, j)) {
							solve(i, j);
						} else {
							ans--;
						}

					}
				}
			}
		}
		System.out.println(ans);
	}

	private static void solve(int i, int j) {
		for (int k = 0; k < 8; k++) {
			int nr = i + pos[k][0];
			int nc = j + pos[k][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] < 9 && map[nr][nc] >= 0) {
				map[nr][nc]--;
			}
		}
	}

	private static boolean chk(int i, int j) {
		for (int k = 0; k < 8; k++) {
			int nr = i + pos[k][0];
			int nc = j + pos[k][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
				return false;
			}
		}
		return true;
	}
}
