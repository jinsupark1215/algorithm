package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1939 {

	/*
	 * [백준] 중량제한
	 * 
	 * 1. 한번의 이동에서 옮길 수 있는 물품중량 최댓값
	 * 
	 * 2. C<1000000000
	 * 
	 * 3.
	 */
	static List<Weight>[] list;
	static int n,m,ans;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();

		int max = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			list[v1].add(new Weight(v2, g));
			list[v2].add(new Weight(v1, g));
			max = Math.max(g, max);
		}
		st = new StringTokenizer(br.readLine());
		int tx = Integer.parseInt(st.nextToken());
		int ty = Integer.parseInt(st.nextToken());

		int start = 1;
		int end = max;
		ans = 0;
		while (start <= end) {
			visit = new boolean[n + 1];
			int mid = (start + end) / 2;
			if (chk(mid, tx, ty)) {
				start = mid + 1;
				ans = Math.max(ans, mid);
			} else
				end = mid - 1;
		}
		System.out.println(ans);
	}

	static boolean chk( int limit, int start, int end) {
		if (visit[start])
			return false;
		
		visit[start] = true;
		if (start == end)
			return true;
		for (Weight v : list[start]) {
			if (v.g >= limit) { // 입력받은 중량으로 이동할 수 있는지 체크
				if (chk(limit, v.v, end)) {
					return true;
				}
			}
		}

		return false;
	}
}

class Weight {
	int v;
	int g;

	public Weight(int v, int g) {
		this.v = v;
		this.g = g;
	}
}
/*//크루스칼 방법
 * class Edge2 implements Comparable<Edge2>{
	int fr, to;
	long cost;
	public Edge2(int x, int y, long z) {
		fr = x;
		to = y;
		cost = z;
	}
	public int compareTo(Edge2 next) {
		return this.cost < next.cost ? 1 : -1;
	}
}
public class Main {

	static StringTokenizer st;
	static int N, M;
	static int A, B, S, D;
	static long C;
	static Edge2[] edges;
	static int parent[];
	public static void main(String[] args) throws Exception {
		// 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		Arrays.fill(parent, -1);

		PriorityQueue<Edge2> edges = new PriorityQueue();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Long.parseLong(st.nextToken());
			edges.add(new Edge2(A, B, C));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		while(!edges.isEmpty()) {
		  Edge2 e = edges.poll();
		  union(e.fr, e.to);
		  if(find(S)==find(D)){
				System.out.println(e.cost);
				break;					
			}
		}	
		br.close();
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		int tmp = 0;
		
		if(px==py) return;

		parent[px] = py;
		
	}
	static int find(int x) {
		if(parent[x]<0) return x;
		
		return parent[x] = find(parent[x]);
	}
}

 */