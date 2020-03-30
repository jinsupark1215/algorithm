package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18404 {

	/*
	 * [백준] 현명한 나이트
	 * 
	 * 1. 말을 잡기 위한 최소 이동수
	 * 
	 * 2. N <= 500, M <=1000, X,Y<=N
	 * 
	 * 3. bfs로 갈 수 있는 곳 다 체크후 맵 반환
	 */
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];

		Queue<Point> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		q.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));

		ArrayList<Point> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
		}

		while (!q.isEmpty()) {
			Point p = q.poll();
			visit[p.r][p.c] = true;

			for (int i = 0; i < 8; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
					visit[nr][nc] = true;
					map[nr][nc] = p.cnt + 1;
					q.add(new Point(nr, nc, p.cnt + 1));
				}
			}
		}

		for (int i = 0; i < M; i++) {
			System.out.print(map[list.get(i).r][list.get(i).c] + " ");
		}
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}
}
