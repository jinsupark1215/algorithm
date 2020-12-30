package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2615 {

	/*
	 * [백준] 오목
	 * 
	 * 1. 누가 이겼는지 판단
	 * 
	 * 2. 
	 * 
	 * 3. 3차원 메모이제이션
	 */
	static int[][] map = new int[21][21];
	static int[][][] memo = new int[21][21][4];
	static int[][] pos = {{1,0},{1,1},{0,1},{-1,1}};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(findFive());
	}

	private static String findFive() {
		for (int j = 1; j <= 19; j++) {
			for (int i = 1; i <= 19; i++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						if (memo[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {
							return map[i][j] + "\n" + i + " " + j + "\n";
						}
					}
				}
			}
		}
		return "0";
	}

	private static int calc(int x, int y, int dir, int color) {
		int nx = x + pos[dir][0];
		int ny = y + pos[dir][1];

		if (map[nx][ny] == color) {
			return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
		}
		return 1;
	}
}
