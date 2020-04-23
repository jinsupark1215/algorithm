package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1938 {

	/*
	 * [백준] 통나무 옮기기
	 * 
	 * 1. 최소 동작 횟수
	 * 
	 * 2. N <= 50
	 * 
	 * 3. bfs 
	 * 3-1. 중앙값만 저장하고 세로인지 가로인지 판단 
	 * 3-2. visit 배열 3차원으로 0이면 가로 1이면 세로
	 */
	static int N, ans;
	static int[][] map, B, E;
	static boolean[][][] visit;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		map = new int[N][N];
		B = new int[3][2];
		E = new int[3][2];
		visit = new boolean[N][N][2];
		int b = 0, e = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				if (input.charAt(j) == 'B') {
					B[b][0] = i;
					B[b][1] = j;
					b++;
					map[i][j] = input.charAt(j) - 'B';
				} else if (input.charAt(j) == 'E') {
					E[e][0] = i;
					E[e][1] = j;
					e++;
					map[i][j] = input.charAt(j) - 'E';
				} else
					map[i][j] = input.charAt(j) - '0';
			}
		}

		bfs();

		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		// 세로
		if (B[0][0] + 1 == B[1][0]) {
			visit[B[1][0]][B[1][1]][1] = true;
			q.add(new Point(B[1][0], B[1][1], 0, 1));
		} else {
			visit[B[1][0]][B[1][1]][0] = true;
			q.add(new Point(B[1][0], B[1][1], 0, 0));
		}

		int dir = 0;
		if (E[0][0] + 1 == E[1][0])dir = 1;
		else dir = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

//			System.out.println("r: " + p.r + " c: " + p.c + " 거리: " + p.dist + " 방향: " + p.state);
			if (dir == p.state && p.r == E[1][0] && p.c == E[1][1]) {
				ans = p.dist;
				break;
			}

			// 회전가능
			if (chk(p.r, p.c)) {
				if (p.state == 0 && !visit[p.r][p.c][1])
					q.add(new Point(p.r, p.c, p.dist + 1, 1));
				else if (p.state == 1 && !visit[p.r][p.c][0])
					q.add(new Point(p.r, p.c, p.dist + 1, 0));
			}

			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc][p.state] && map[nr][nc] == 0) {
					if (p.state == 0 && nc + 1 < N && nc - 1 >= 0 && map[nr][nc - 1] == 0 && map[nr][nc + 1] == 0) {
						q.add(new Point(nr, nc, p.dist + 1, p.state));
						visit[nr][nc][p.state] = true;
					} else if (p.state == 1 && nr + 1 < N && nr - 1 >= 0 && map[nr - 1][nc] == 0
							&& map[nr + 1][nc] == 0) {
						q.add(new Point(nr, nc, p.dist + 1, p.state));
						visit[nr][nc][p.state] = true;
					}

				}
			}
		}
	}

	private static boolean chk(int r, int c) {
		if (r - 1 >= 0 && r + 1 < N && c - 1 >= 0 && c + 1 < N) {
			for (int i = r - 1; i <= r + 1; i++) {
				for (int j = c - 1; j <= c + 1; j++) {
					if (map[i][j] == 1)
						return false;
				}
			}
		} else
			return false;

		return true;
	}

	static class Point {
		int r, c, dist, state;

		public Point(int r, int c, int dist, int state) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.state = state;
		}

	}
}
