package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1986 {

	/*
	 * 1. 안전한 곳이 몇개인지 세기
	 * 
	 * 2. 가장 왼쪽이 (1,1)로 시작 n,m <=1000
	 * 
	 * 3. Bfs로 갈수 있는 경로 다 visit
	 * visit 순서 : 나이트 -> 퀸   
	 * 나이트는 넘어갈 수 있기때문에 먼저 갈수 있는곳 다체크 후 
	 * 퀸은 갈수 있는 곳 다 비짓하고 장애물있으면 처리 X 
	 */
	static int[][] pos1 = {{2,1},{2,-1},{-2,-1},{-2,1},{1,2},{1,-2},{-1,2},{-1,-2}};
	static int[][] pos2 = {{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] visit= new boolean[n][m];
		Queue<Point> queen = new LinkedList<>();
		Queue<Point> knight = new LinkedList<>();
		
		//퀸 입력
		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] =1;
			visit[r-1][c-1] = true;
			queen.add(new Point(r-1,c-1));
		}
		//나이트 입력
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] =2;
			visit[r-1][c-1] = true;
			knight.add(new Point(r-1,c-1));
		}
		//폰 입력
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] =3;
			visit[r-1][c-1] = true;
		}
		
		//나이트 이동
		while(!knight.isEmpty()) {
			Point p = knight.poll();
			
			for (int i = 0; i < 8; i++) {
				int nr = p.r + pos1[i][0];
				int nc = p.c + pos1[i][1];
				if(nr>=0 && nr<n && nc>=0 && nc < m && map[nr][nc] == 0 ) {
					visit[nr][nc]= true; 
				}
			}
		}
		
		//퀸 이동
		while(!queen.isEmpty()) {
			Point p = queen.poll();
			
			for (int i = 0; i < 8; i++) {
				for (int j = 1; j < 1000; j++) {
					int nr = p.r + pos2[i][0]*j;
					int nc = p.c + pos2[i][1]*j;
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0) {
						visit[nr][nc] = true;
					}else break;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visit[i][j])ans++;
			}
		}
		System.out.println(ans);
	}
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}

