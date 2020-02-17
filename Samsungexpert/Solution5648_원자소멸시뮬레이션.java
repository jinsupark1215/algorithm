package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5648_원자소멸시뮬레이션 {

	/*
	 * 1. 원자가 방출하는 에너지 총합을 구하여라
	 * 
	 * 2. N <=1000, -1000<= x,y <= 1000, 상하좌우순서
	 * 
	 * 3. 맵을 그리고 bfs로 진행
	 */
	static int ans;
	static int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] map = new int[4002][4002];
			Queue<Point> q = new LinkedList<>();
			ans = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int y = (Integer.parseInt(st.nextToken()) + 1000) << 1;
				int x = 4000 - ((Integer.parseInt(st.nextToken())+ 1000) << 1);
				int dir = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				map[x][y] = cnt;
				q.add(new Point(x, y, dir, cnt));
			}

			while (!q.isEmpty()) {
				Point p = q.poll();
				if (map[p.r][p.c] != p.cnt) {
					ans += map[p.r][p.c];
					map[p.r][p.c] = 0;
					continue;
				}

				int nr = p.r + pos[p.dir][0];
				int nc = p.c + pos[p.dir][1];

				if (nr >= 0 && nr < 4001 && nc >= 0 && nc < 4001) {
					if (map[nr][nc] == 0) {
						map[nr][nc] = p.cnt;
						q.add(new Point(nr, nc, p.dir, p.cnt));
					} else {
						map[nr][nc] += p.cnt;
					}

				}
				map[p.r][p.c] = 0;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static class Point {
		int r, c, dir, cnt;

		public Point(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
}
