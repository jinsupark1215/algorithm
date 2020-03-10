package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {

	/*
	 * 1. 보물이 묻혀있는 두곳 최단거리
	 * 
	 * 2. 세로 가로 <= 50
	 * 
	 * 3. 각 육지마다 BFS돌아서 최단거리 가장 긴 것 답
	 */
	static int N, M, ans;
	static char[][] map;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		ans = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0));
		boolean[][] visit = new boolean[N][M];
		visit[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			ans = Math.max(ans, p.dis);
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 'L' && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new Point(nr, nc, p.dis + 1));
				}
			}
		}
	}

	static class Point {
		int r, c, dis;

		public Point(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
}
