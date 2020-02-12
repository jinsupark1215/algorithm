package 최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1922_네트워크연결 {

	/*
	 * 1. 모든 컴퓨터들이 연결되는 최소 비용?
	 * 
	 * 2. N <= 1000, M <= 100000
	 * 
	 * 3. MST(Kruskal) 사용
	 */
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(list);
		int cnt = 0;
		for (Node n : list) {
			if(find(n.start) != find(n.end)) {
				union(n.start, n.end);
				cnt += n.dis;
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
			return this.dis - o.dis;
		}
	}
}
