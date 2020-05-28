package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main11559 {
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] map;
	static boolean[][] visit;
	static int ans;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		ans = 0;
		for (int i = 0; i < 12; i++) {
			String a = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = a.charAt(j);
			}
		}

		while (true) {

			flag = false;
			visit = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.' && !visit[i][j]) {
						bfs(i, j);
					}
				}
			}
			move();

			if (!flag)
				break;
			ans++;

		}

		System.out.println(ans);

	}

	private static void move() {
		for (int j = 0; j < 6; j++) {
			int idx = 11;
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] != '.') {
					char c = map[i][j];
					map[i][j] = '.';
					map[idx][j] = c;
					idx--;
				}
			}
		}

	}

	private static void bfs(int r, int c) {
		ArrayList<Pair> list = new ArrayList<Pair>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(r, c));
		list.add(new Pair(r, c));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			visit[p.r][p.c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if (nr >= 0 && nc >= 0 && nr < 12 && nc < 6 && map[nr][nc] == map[p.r][p.c] && !visit[nr][nc]) {
					q.add(new Pair(nr, nc));
					list.add(new Pair(nr, nc));
				}
			}
		}

		if (list.size() >= 4) {
			for (int i = 0; i < list.size(); i++) {
				map[list.get(i).r][list.get(i).c] = '.';
			}
			flag = true;
		}
	}

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
