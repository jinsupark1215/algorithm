package 최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main9372 {

	/*
	 * 1. 최소의 비행기 종류로 모든 도시를 여행하는 법
	 * 
	 * 2. N <= 1000, M <= 10000
	 * 
	 * 3. MST 문제, Kruskal MST 알고리즘.
	 */
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Point> list = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			// 거리가 없으므로(최소를 구하는 것이 아니므로) 따로 정렬 X
			int cnt = 0;
			for (Point p : list) {
				if (find(p.start) != find(p.end)) {
					union(p.start, p.end);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	private static void union(int start, int end) {
		int rootA = find(start);
		int rootB = find(end);

		parent[rootB] = rootA;
	}

	private static int find(int num) {
		if (parent[num] == num) {
			return num;
		}
		return parent[num] = find(parent[num]);
	}

	static class Point {
		int start, end;

		public Point(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
}
