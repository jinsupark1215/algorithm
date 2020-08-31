package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16985 {

	/*
	 * [백준] Maaaaaaaaaaze
	 * 
	 * 1. 미로를 탈출하는 가장 적은 이동횟수는?
	 * 
	 * 2. 5개의 판
	 * 
	 * 3. 3-1. 층수 정하는 조합 
	 * 3.2. 층수대로 넣고 진행하고 위부터 순서대로 돌려가면서 진행
	 */
	static int[][][] map = new int[5][5][5];
	static int[][] pos = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };
	static Queue<int[]> q;
	static int ans;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 5; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		ans = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void dfs(int idx) {
		if (idx == 5) {
			perm(0);
			return;
		}
		for (int i = 0; i < 4; i++) {
			rotate(idx);
			dfs(idx + 1);
		}

	}

	static void perm(int idx) {
		if (idx == 5) {
			if (map[0][0][0] == 1 && map[4][4][4] == 1)
				find();
			return;
		}
		for (int i = idx; i < 5; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}

	static void swap(int a, int b) {
		int[][] tmp = map[a];
		map[a] = map[b];
		map[b] = tmp;
	}

	static void find() {
		q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, 0, 0 });
		visit = new boolean[5][5][5];
		visit[0][0][0] = true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			if (cur[0] == 4 && cur[1] == 4 && cur[2] == 4) {
				ans = Math.min(cur[3], ans);
				if (ans == 12) {
					System.out.println("12");
					System.exit(0);
				}
				return;
			}
			for (int k = 0; k < 6; k++) {
				int nh = cur[0] + pos[k][0];
				int nr = cur[1] + pos[k][1];
				int nc = cur[2] + pos[k][2];
				if (isRange(nh, nr, nc) && !visit[nh][nr][nc] && map[nh][nr][nc] == 1) {
					visit[nh][nr][nc] = true;
					q.add(new int[] { nh, nr, nc, cur[3] + 1 });
				}
			}
		}

	}

	static void rotate(int height) {
		int[][] tmp = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tmp[j][5 - i - 1] = map[height][i][j];
			}
		}
		map[height] = tmp;

	}

	static boolean isRange(int h, int x, int y) {
		return h >= 0 && x >= 0 && y >= 0 && h < 5 && x < 5 && y < 5;
	}

}
