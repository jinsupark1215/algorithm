package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18405 {

	/*
	 * 1. x,y에 존재하는 바이러스의 종류는?
	 * 
	 * 2. N<=200,K<=1000
	 * 
	 * 3. 숫자로 정렬해서 queue에 넣어준 후 bfs
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] !=0) {
					pq.add(new Point(i,j,map[i][j]));
					visit[i][j] = true;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < S; i++) {
			int size = pq.size();
			for (int j = 0; j < size; j++) {
				Point p = pq.poll();
				
				for (int l = 0; l < 4; l++) {
					int nr = p.r + pos[l][0];
					int nc = p.c + pos[l][1];
					if(nr>=0 && nr< N && nc >=0 && nc < N && !visit[nr][nc] && map[nr][nc] ==0) {
						visit[nr][nc] = true;
						map[nr][nc] = p.num;
						q.add(new Point(nr,nc,p.num));
					}
				}
			}
			while(!q.isEmpty())pq.add(q.poll());
		}
		
		System.out.println(map[x][y]);
	}
	static class Point implements Comparable<Point>{
		int r, c, num;

		public Point(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			return this.num - o.num;
		}
		
	}
}
