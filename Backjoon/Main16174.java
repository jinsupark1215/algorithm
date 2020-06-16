package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16174 {

	/*
	 * [백준] 점프왕 젤리(Large)
	 * 
	 * 1. 끝점에 도달할 수 있는지 판단
	 * 
	 * 2.  N <=64
	 * 
	 * 3. bfs
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		visit[0][0] = true;
		boolean flag = false;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == N-1 && p.c == N-1) {
				flag = true;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + (pos[i][0] * map[p.r][p.c]);
				int nc = p.c + (pos[i][1]* map[p.r][p.c]);
				if(nr>=0 && nr< N && nc>=0 && nc < N && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new Point(nr,nc));
				}
			}
		}
		
		if(flag)System.out.println("HaruHaru");
		else System.out.println("Hing");
	}
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
