package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1953 {

	/*
	 * 1. 팀을 나누는 방법
	 * 
	 * 2. n<= 100
	 * 
	 * 3. bfs
	 */
	static int n;
	static int[][] map;
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();
	static int b, w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		visited = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int man = Integer.parseInt(st.nextToken());
				map[i][man] = map[man][i] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i] != 0)
				continue;

			visited[i] = 1;
			q.add(i);

			while (!q.isEmpty()) {

				int cur = q.poll();

				for (int j = 1; j <= n; j++) {

					if (visited[j] != 0)
						continue;

					if (map[cur][j] == 1) {
						visited[j] = visited[cur] * -1;
						q.add(j);
					}
				}
			}

		}

		for (int i = 1; i <= n; i++) {
			if (visited[i] == 1) {
				b++;
				sb1.append(i + " ");
			} else {
				w++;
				sb2.append(i + " ");
			}
		}

		System.out.println(b);
		System.out.println(sb1.toString());
		System.out.println(w);
		System.out.println(sb2.toString());
	}
}
