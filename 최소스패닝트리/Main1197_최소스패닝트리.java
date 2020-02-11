package 최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1197_최소스패닝트리 {

	/*
	 * 1. 최소스패닝 트리의 가중치
	 * 
	 * 2. 가중치가 음수인 경우도 존재
	 * 
	 * 3. 최소스패닝트리(MST), Kruscal
	 */
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		parent = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		int dis = 0;
		for (Node n : list) {
			if(find(n.start) != find(n.end)) {
				union(n.start, n.end);
				dis += n.dis;
			}
		}
		System.out.println(dis);
	}
	private static void union(int start, int end) {
		int rootA = start;
		int rootB = end;
		
		parent[rootA] = rootB;
		
	}
	private static int find(int num) {
		if(parent[num] == num)return num;
		return parent[num] = find(parent[num]);
	}
	static class Node implements Comparable<Node>{
		int start, end, dis;

		public Node(int start, int end, int dis) {
			super();
			this.start = start;
			this.end = end;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return Math.abs(this.dis) - Math.abs(o.dis);
		}
	}
}
