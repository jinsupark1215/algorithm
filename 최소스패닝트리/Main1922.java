package 최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1922 {

	/*
	 * 1. 두개의 집으로 나눴을 때 그 유지비의 최솟값
	 * 
	 * 2. N <= 100000, M <= 1000000, C <= 1000
	 * 
	 * 3. MST(Kruskal)로 해서 N개의 집에서 N-2개만 연결하면 됨
	 */
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<House> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new House(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int size = 0;
		int cnt = 0;
		while (size < N - 2) {
			House h = pq.poll();

			if (find(h.start) != find(h.end)) {
				union(h.start, h.end);
				cnt += h.dis;
				size++;
			}
		}
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		parent[rootB] = rootA;
	}

	private static int find(int num) {
		if (parent[num] == num)
			return num;
		return parent[num] = find(parent[num]);
	}

	static class House implements Comparable<House> {
		int start, end, dis;

		public House(int start, int end, int dis) {
			super();
			this.start = start;
			this.end = end;
			this.dis = dis;
		}

		@Override
		public int compareTo(House o) {
			return this.dis - o.dis;
		}
	}
}
