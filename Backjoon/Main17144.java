package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17144 {

	/*
	 * [백준] 미세먼지 안녕! 1. T초가 지난 후 남아있는 미세먼지 양
	 * 
	 * 2. R,C <=50, T<=1000
	 * 
	 * 3. 확산 구현, 공기청정기 구현
	 */
	static int R, C, T, ans;
	static int[][] map;
	static Queue<int[]> q;
	static ArrayList<int[]> air;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		air = new ArrayList<>();
		map = new int[R][C];
		ans = 0;
		q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == -1) {
					air.add(new int[] { i, j });
					map[i][j] = -1;
				} else if (tmp != 0)
					q.add(new int[] { i, j, tmp });
			}
		}

		while (T != 0) {
			go();
			airCondition();
			chk();
			T--;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}

		System.out.println(ans);
	}

	private static void go() {

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cnt = 0;

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + pos[i][0];
				int nc = cur[1] + pos[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
					cnt++;
					map[nr][nc] += cur[2] / 5;
				}
			}
			map[cur[0]][cur[1]] += cur[2] - ((cur[2] / 5) * cnt);
		}
	}

	private static void airCondition() {
		int[] first = air.get(0);
		int[] second = air.get(1);

		// 위
		for (int i = first[0] - 1; i > 0; i--) {
			map[i][first[1]] = map[i - 1][first[1]];
		}
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < first[0]; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			map[first[0]][i] = map[first[0]][i - 1];
		}

		// 아래
		for (int i = second[0] + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		for (int i = R - 1; i > second[0]; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			map[second[0]][i] = map[second[0]][i - 1];
		}
		map[first[0]][first[1] + 1] = 0;
		map[second[0]][second[1] + 1] = 0;
	}

	private static void chk() {
		if (T != 1) {

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						q.add(new int[] { i, j, map[i][j] });
						map[i][j] = 0;
					}
				}
			}
		}

	}

}
