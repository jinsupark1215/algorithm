package Backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17135 {

	/*
	 * [백준] 캐슬디펜스
	 * 
	 */
	static int Answer, n, m, d;
	static int[][] map;
	static boolean[] shot;
	static boolean[] used;
	static int[][] pos = { { 0, -1 }, { -1, 0 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n + 1][m];
		used = new boolean[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 조합으로 궁수 조합
		combi(0, 0);
		
		System.out.println(Answer);
	}

	// 궁수 자리 선택
	private static void combi(int idx, int cnt) {
		if (cnt == 3) {
			// 그대로 쭈욱 쏴서 몇마리 죽일수 있는지 bfs
			int[][] nmap = new int[n + 1][m];
			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < m; j++) {
					nmap[i][j] = map[i][j];
				}
			}
			bfs(nmap);
			return;
		}

		for (int i = idx; i < m; i++) {
			if (!used[i]) {
				used[i] = true;
				combi(i, cnt + 1);
				used[i] = false;
			}
		}
	}

	private static void bfs(int[][] nmap) {
		int cnt = 0;
		for (int i = n; i > 0; i--) {
			int archerIdx = 0;
			Queue<Point> q = new LinkedList<>();
			for (int j = 0; j < m; j++) {
				if (used[j]) {
					nmap[i][j] = 2; // 궁수 위치가 2
					q.add(new Point(i - 1, j, 1, archerIdx++));
				} else {
					nmap[i][j] = 0; // 궁수 위치가 아니라면
				}
			}

			boolean[] isEnemyFind = new boolean[3]; // 각 궁수가 몬스터를 찾았는지
			boolean[][][] visited = new boolean[n][m][3]; // 각 궁수가 해당 좌표를 방문했는지
			boolean[][] isAlreadyFindLocation = new boolean[n][m]; // 이미 다른 궁수가 찾은 목표물인지
			ArrayList<Point> alist = new ArrayList<>();

			while (!q.isEmpty()) {
				Point p = q.poll();
				if (isEnemyFind[p.idx])
					continue;
				if (nmap[p.r][p.c] == 1) {
					isEnemyFind[p.idx] = true;
					if (!isAlreadyFindLocation[p.r][p.c]) {
						isAlreadyFindLocation[p.r][p.c] = true;
						alist.add(p);
						cnt++;
					}
					continue;
				}
				if (!isEnemyFind[p.idx]) {
					visited[p.r][p.c][p.idx] = true;
					for (int j = 0; j < 3; j++) {
						int nx = p.r + pos[j][0];
						int ny = p.c + pos[j][1];
						if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][p.idx] && p.depth < d) {
							q.add(new Point(nx, ny, p.depth + 1, p.idx));
						}
					}
				}
			}
			for (int j = 0; j < alist.size(); j++) {
				Point p = alist.get(j);
				nmap[p.r][p.c] = 0;
			}
		}
		Answer = Math.max(Answer, cnt);
	}

	static class Point {
		int r, c, depth, idx;

		public Point(int r, int c, int depth, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.idx = idx;
		}

	}
}
