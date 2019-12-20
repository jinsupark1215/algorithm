package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16948 {

	static int[][] pos = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
	static int[][] map;
	static int answer, n, startr, startc, endr, endc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		startr = Integer.parseInt(st.nextToken());
		startc = Integer.parseInt(st.nextToken());
		endr = Integer.parseInt(st.nextToken());
		endc = Integer.parseInt(st.nextToken());
		answer =-1;
		map = new int[n][n];
		
		
		/*
		 *  1. 문제 이해 : 데스나이트가 해당 좌표로 이동 시 최소 이동수 구하기
		 *  
		 *  2. 제약 조건 : 체스판 벗어날 수 없고 최소 도착수를 알아야하고 못도달하면 -1
		 *  
		 *  3. bfs를 이용해 map에 최소 이동횟수를 적어 중복 방지 겸 방문표시, 해당 좌표의 이동수를 출력.
		 */
		bfs();
		System.out.println(answer);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startr,startc,1));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int nr= p.r + pos[i][0];
				int nc= p.c + pos[i][1];
				if(nr>=0 && nc>=0 && nr< n && nc< n && map[nr][nc] == 0) {
					map[nr][nc] = p.d;
					q.add(new Point(nr,nc,p.d+1));
				}
			}
			
			if(p.r == endr && p.c == endc) {
				answer = map[endr][endc];
				break;
			}
		}
	}
	static class Point{
		int r,c,d;

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
