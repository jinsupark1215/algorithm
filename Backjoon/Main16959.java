package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main16959 {

	/*
	 * 1. 방문하는데 필요한 최소시간
	 * 
	 * 2. N <=10
	 * 
	 * 3. dfs
	 */
	static int N, sr, sc, ans;
	static int[][] map;
	static int[][][][] dist;
	static int[][] knite = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };
	static int[][] rook = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] bishop = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					r = i;
					c = j;
				}
			}
		}
		int[][][] nd = { { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } },
				{ { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } }, { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } } };
		LinkedList<int[]> q = new LinkedList<>();
		boolean[][][][] visit = new boolean[N][N][3][N * N];
		q.offer(new int[] { r, c, 0, 0, 1 });
		q.offer(new int[] { r, c, 1, 0, 1 });
		q.offer(new int[] { r, c, 2, 0, 1 });
		visit[r][c][0][1] = true;
		visit[r][c][1][1] = true;
		visit[r][c][2][1] = true;
		
		int[] cur;
		int nr, nc, nh;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (map[cur[0]][cur[1]] == cur[4] + 1) {
				if (map[cur[0]][cur[1]] == N * N) {
					System.out.println(cur[3]);
					break;
				}
				cur[4]++;
			}
			for (int i = 0; i < nd[cur[2]].length; i++) {
				int j = 1;
				while (true) {
					nr = cur[0] + nd[cur[2]][i][0] * j;
					nc = cur[1] + nd[cur[2]][i][1] * j;
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (!visit[nr][nc][cur[2]][cur[4]]) {
							q.offer(new int[] { nr, nc, cur[2], cur[3] + 1, cur[4] });
							visit[nr][nc][cur[2]][cur[4]] = true;
						}
					} else {
						break;
					}
					if (cur[2] == 0) {
						break;
					}
					j++;
				}
			}
			nh = (cur[2] + 1) % 3;
			if (!visit[cur[0]][cur[1]][nh][cur[4]]) {
				q.offer(new int[] { cur[0], cur[1], nh, cur[3] + 1, cur[4] });
				visit[cur[0]][cur[1]][nh][cur[4]] = true;
			}
			nh = (cur[2] + 2) % 3;
			if (!visit[cur[0]][cur[1]][nh][cur[4]]) {
				q.offer(new int[] { cur[0], cur[1], nh, cur[3] + 1, cur[4] });
				visit[cur[0]][cur[1]][nh][cur[4]] = true;
			}
		}
		br.close();
	}
}

