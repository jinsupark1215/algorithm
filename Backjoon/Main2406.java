package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2406 {

	/*
	 * [백준] 안정적인 네트워크 
	 * 1. i, j 컴퓨터를 연결할 때 드는 비용
	 * 
	 * 2. n <=1000
	 * 
	 * 3. 최소스패닝 트리(크루스칼)
	 */
	static int parents[];
	static int N, M;
	static PriorityQueue<Computer> pq;
	static Queue<ansline> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			parents[i] = -1;
		}
		
		//연결
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			
			int x = find(tmp1);
			int y = find(tmp2);
			if(x != y) {
				union(tmp1, tmp2);
			}
			
		}
		
		pq = new PriorityQueue<Computer>();
		q = new LinkedList<ansline>();
		
		//거리최소인 것 찾기
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			if(i==1) continue;
			for(int j=1;j<=N;j++) {
				int dis = Integer.parseInt(st.nextToken());
				if(i>j) continue;
				pq.add(new Computer(i, j, dis));
				
			}
		}
		
		//연결
		long ans = 0;
		int linecnt = 0;
		while(!pq.isEmpty()) {
			int cnt = 0;
			for(int i=2;i<=N;i++) {
				if(parents[i]<0) cnt++;
				if(cnt>1) break;
			}
			if(cnt == 1) break;
			int start = pq.peek().start;
			int end = pq.peek().end;
			int dis = pq.poll().dis;
			
			if(find(start) != find(end)) {
				union(start, end);
				ans += dis;
				linecnt++;
				q.add(new ansline(start, end));
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append(" ").append(linecnt).append("\n");
		while(!q.isEmpty()) {
			sb.append(q.peek().x).append(" ").append(q.poll().y).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static int find(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		parents[px] += parents[py];
		parents[py] = px;
	}
	
	static class ansline{
		int x;
		int y;
		public ansline(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Computer implements Comparable<Computer>{
		int start,end,dis;
		
		public Computer(int start, int end, int dis) {
			super();
			this.start = start;
			this.end = end;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Computer o) {
			// TODO Auto-generated method stub
			return this.dis-o.dis;
		}
		
		
	}
}
