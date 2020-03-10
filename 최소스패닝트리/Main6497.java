package 최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main6497 {

	/*
	 * 1. 최대로 절약할 수 있는 비용은?
	 * 
	 * 2. m <= 200000, n <=200000
	 * 
	 * 3. MST(Kruskal) 이용해 최소비용을 구하고 전체-최소
	 */
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;

			PriorityQueue<Node> pq = new PriorityQueue<>();
			int cost = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				cost += d;
				pq.add(new Node(s, e, d));
			}
			parent = new int[n];
			for (int i = 1; i < n; i++) {
				parent[i] = i;
			}
			int cnt = 0;
			while (!pq.isEmpty()) {
				Node node = pq.poll();

				if (find(node.start) != find(node.end)) {
					union(node.start, node.end);
					cnt += node.dis;
				}
			}
			System.out.println(cost - cnt);
		}
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

	static class Node implements Comparable<Node> {
		int start, end, dis;

		public Node(int start, int end, int dis) {
			super();
			this.start = start;
			this.end = end;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
}
