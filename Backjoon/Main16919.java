package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16919 {

	/*
	 * [백준] 봄버맨2 1. 출력
	 * 
	 * 2. N <= 10^9
	 * 
	 * 3. 규칙을 찾아야함 1, 2, (3, 4, 5, 6) ->반복
	 */
	static int R, C, N;
	static char[][] map;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 0, 0 } };
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		Queue<bomb> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		String[] arr = new String[6];

		for (int i = 0; i < R; i++) {
			String a = br.readLine();
			sb.append(a);
			for (int j = 0; j < C; j++) {
				map[i][j] = a.charAt(j);
				if (map[i][j] == 'O') {
					q.add(new bomb(i, j, 0));
				}
			}
		}
		arr[0] = sb.toString();
		// 1

		sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		arr[1] = arr[3] = arr[5] = sb.toString();
		// 2

		sb = new StringBuilder();
		while (!q.isEmpty()) {
			bomb b = q.poll();
			for (int i = 0; i < 5; i++) {
				int nr = b.r + pos[i][0];
				int nc = b.c + pos[i][1];
				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					map[nr][nc] = '.';
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		arr[2] = sb.toString();
		// 3

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					q.add(new bomb(i, j, 0));
				}
			}
		}

		sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
				}
			}
		}
		sb = new StringBuilder();
		while (!q.isEmpty()) {
			bomb b = q.poll();
			for (int i = 0; i < 5; i++) {
				int nr = b.r + pos[i][0];
				int nc = b.c + pos[i][1];
				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					map[nr][nc] = '.';
				}
			}
		}

		// 비교
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		arr[4] = sb.toString();
		// 5

		if (N == 1) {
			for (int i = 0; i < R * C; i++) {
				if (i != 0 && i % C == 0)	System.out.println();
				System.out.print(arr[0].charAt(i));
			}
		} else if (N == 2) {
			for (int i = 0; i < R * C; i++) {
				if (i != 0 && i % C == 0)	System.out.println();
				System.out.print(arr[1].charAt(i));
			}
		} else {

			for (int i = 0; i < R * C; i++) {
				if (i != 0 && i % C == 0)	System.out.println();
				System.out.print(arr[((N - 2) % 4) + 1].charAt(i));
			}
		}
		// 출력
	}

	static class bomb {
		int r, c, time;

		public bomb(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}
}