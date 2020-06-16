package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main19237 {

	/*
	 * [백준] 어른 상어
	 * 
	 * 1. 1번 상어만 격자에 남게 되는 경우 걸리는 시간?, 1000넘어가면 -1
	 * 
	 * 2. N<=20, M <=N^2, k <= 1000
	 * 
	 * 3. 빡구현
	 */
	static int N, M, k,ans;
	static PriorityQueue<Shark> pq;
	static Queue<Shark> q;
	static int[][] map, small, priority;
	static int[][] pos = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ans= 0;
		map = new int[N][N];
		small = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] !=0) {
					small[i][j] = k;
				}
			}
		}
		
		//M개의 각자 방향 받기
		pq = new PriorityQueue<>();
		q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int[] tmp = new int[M];
		for (int i = 0; i < M; i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] !=0) {
					pq.add(new Shark(i,j,map[i][j], tmp[map[i][j]-1]));
				}
			}
		}
		
		//우선순위 방향
		priority = new int[M*4][4];
		for (int i = 0; i < M*4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				priority[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(pq.size() !=1) {
			while(!pq.isEmpty()) {
				q.add(pq.poll());
			}
			
			if(ans>=1000) {
				ans = -1;
				break;
			}
			boolean[][] visit = new boolean[N][N];
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Shark s = q.poll();
				
				boolean flag = false;
				for (int j = 0; j < 4; j++) {
					int nr = s.r + pos[priority[(4 * (s.num - 1)) + (s.dir - 1)][j]][0];
					int nc = s.c + pos[priority[(4 * (s.num - 1)) + (s.dir - 1)][j]][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if(small[nr][nc] == 0) {
						small[nr][nc] = k+1;
						map[nr][nc] = s.num;
						flag = true;
						pq.add(new Shark(nr, nc, s.num, priority[(4 * (s.num - 1)) + (s.dir - 1)][j]));
						break;
						}else if(small[nr][nc] == k+1 && !visit[nr][nc]) {
							flag = true;
							break;
						}
					}
				}
				if (!flag) {
					for (int j = 0; j < 4; j++) {
						int nr = s.r + pos[priority[(4 * (s.num - 1)) + (s.dir - 1)][j]][0];
						int nc = s.c + pos[priority[(4 * (s.num - 1)) + (s.dir - 1)][j]][1];
						if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == s.num) {
							visit[nr][nc] = true;
							small[nr][nc] = k+1;
							map[nr][nc] = s.num;
							pq.add(new Shark(nr, nc, s.num, priority[(4 * (s.num - 1)) + (s.dir - 1)][j]));
							break;
						}
					}

				}
			}
			
			chk();
			ans++;
		}
		System.out.println(ans);
	}
	private static void chk() {
		//냄새시간먼저 줄어주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(small[i][j] !=0)small[i][j]--;
			}
		}
		
		//냄새시간 0인거 샤크흔적 없애주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(small[i][j] ==0)map[i][j] = 0;
			}
		}
		
	}
	static class Shark implements Comparable<Shark>{
		int r,c,num,dir;

		public Shark(int r, int c, int num, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Shark o) {
			return this.num - o.num;
		}
	}
}
