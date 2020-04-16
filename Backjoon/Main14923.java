package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14923 {

	/*
	 * [백준] 미로 탈출
	 * 
	 * 1. 최소로 도착하는 시간
	 * 
	 * 2. N,M <=1000 탈출 못하면 -1
	 * 
	 * 3. 1없애고 가보기
	 */
	static int N,M,sr,sc,er,ec, ans;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		er = Integer.parseInt(st.nextToken())-1;
		ec = Integer.parseInt(st.nextToken())-1;
		ans = -1;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					map[i][j] = 0;
					
				}
			}
		}
		System.out.println(ans);
	}
	private static void bfs() {
		visit = new boolean[N][M][2];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr,sc,0,0));
		visit[sr][sc][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == er && p.c == ec) {
				ans = p.dis;
				break;
			}
			
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = p.r + pos[i][0];
				nc = p.c + pos[i][1];
				if(nr>=0 && nr< N && nc>=0 && nc < M  && !visit[nr][nc][p.b]) {
					if(map[nr][nc] == 0) {
						q.add(new Point(nr,nc,p.b, p.dis+1));
						visit[nr][nc][p.b] = true;
					}else if(map[nr][nc] == 1 && p.b ==0) {
						q.add(new Point(nr,nc,p.b+1,p.dis+1));
						visit[nr][nc][p.b+1] = true;
					}
				}
			}
		}
	}
	static class Point{
		int r, c,b, dis;

		public Point(int r, int c, int b, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.b = b;
			this.dis = dis;
		}

	}
}
