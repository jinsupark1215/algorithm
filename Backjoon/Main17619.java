package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17619 {

	/*
	 * 1. 두 통나무로 이동이 가능한지?
	 * 
	 * 2. N <= 100,000, Q <= 100,000
	 * 
	 * 3. dfs, bfs (시간초과)
	 */
	static int N, T, start, end;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			visit = new boolean[N];

			bfs(start);

			if (visit[end])
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visit[idx] = true;

		while (!q.isEmpty()) {
			int index = q.poll();
			for (int i = 0; i < N; i++) {
				if (!visit[i] && map[i][0] <= map[index][1] && map[i][1] >= map[index][0]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
