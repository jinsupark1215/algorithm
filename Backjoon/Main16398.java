package Backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16398 {

	static int n;
	static int count;
	static long answer;
	
	static ArrayList<Node> list = new ArrayList<Node>();
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static int[] parent;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j<=n; j++) {
				
				int a = Integer.parseInt(st.nextToken());
				if(i < j) {
					pq.add(new Node(i, j, a));
				}
				
			}
		}
		

		parent = new int[n+1];
		for(int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		count = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(union(curr) == true) {
				answer = answer + curr.cost;
				count++;
			}
			
			if(count == n-1) {
				break;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean union(Node node) {
		int r1 = find(node.v1);
		int r2 = find(node.v2);
		
		if(r1 != r2) {
			parent[r1] = r2;
			return true;
		}
		
		return false;
	}
	
	private static int find(int v) {
		if(parent[v] == v) {
			return v;
		}
		
		return parent[v] = find(parent[v]);
	}

	static class Node implements Comparable<Node>{
		int v1, v2, cost;
		
		Node(int v11, int v22, int cc){
			this.v1 = v11;
			this.v2 = v22;
			this.cost = cc;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.cost < o.cost) {
				return -1;
			}else {
				return 1;
			}
		}
	}
}

