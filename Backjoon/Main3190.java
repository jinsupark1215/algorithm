package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3190 {
	/*
	 * [백준] 뱀
	 */
	static int[][] map;
	static int n, k, l, ans;
	static int[] t;
	static char[] d;
	static int[][] pos = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static ArrayList<point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		map[0][0] = 1;
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}
		l = Integer.parseInt(br.readLine());
		t = new int[l];
		d = new char[l];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			d[i] = st.nextToken().charAt(0);
		}
		list = new ArrayList<>();
		list.add(new point(0, 0));

		dfs(0, 0, 0, 0);
		System.out.println(ans + 1);
	}

	private static void dfs(int r, int c, int dir, int time) {

		for (int i = 0; i < l; i++) {
			if (t[i] == time) {
				if (d[i] == 'D') {
					dir = dir + 1;
					if (dir == 4)
						dir = 0;
				}
				if (d[i] == 'L') {
					dir = dir - 1;
					if (dir < 0)
						dir = 3;
				}

			}
		}

		int nr = r + pos[dir][0];
		int nc = c + pos[dir][1];

		if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {

			map[list.get(0).r][list.get(0).c] = 0;
			map[nr][nc] = 1;
			list.add(new point(nr, nc));
			list.remove(0);
			dfs(nr, nc, dir, time + 1);
		} else if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 2) {
			list.add(new point(nr, nc));
			map[nr][nc] = 1;
			dfs(nr, nc, dir, time + 1);
		} else {
			ans = time;
		}

	}

	static class point {
		int r, c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
