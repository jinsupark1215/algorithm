package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16197_두동전 {

	/*
	 * 1. 하나의 동전만 떨어뜨리는 최소의 경우 10번이상 -1
	 * 
	 * 2. N,M <=20
	 * 
	 * 3. BFS로 1개만 떨어질 때 답
	 */
	static int N,M,ans;
	static char[][] map;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<Point> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		ans = -1;
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'o') {
					q.add(new Point(i,j,0));
				}
			}
		}
		
		bfs();
		
		System.out.println(ans);
	}
	private static void bfs() {
		
		fin:
		while(!q.isEmpty()) {
			
			Point p1 = q.poll();
			Point p2 = q.poll();
			
			if(p1.cnt>=10)break;
			
			for (int i = 0; i < 4; i++) {
				boolean drop1 = false;
				boolean drop2 = false;
				
				int nr1 = p1.r + pos[i][0];
				int nc1 = p1.c + pos[i][1];
				int nr2 = p2.r + pos[i][0];
				int nc2 = p2.c + pos[i][1];
				
				// 두 동전의 떨어짐을 체크 
				if(nr1 >= N || nr1 < 0 || nc1 >= M || nc1 < 0) {
					drop1 = true;
				}
				if(nr2 >= N || nr2 < 0 || nc2 >= M || nc2 < 0) {
					drop2 = true;
				}
				
				// 두 동전 모두 떨어진 경우
				if(drop1 && drop2) continue;
				// 한 동전만 떨어진 경우
				if(drop1 || drop2) {
					ans = p1.cnt + 1;
					break fin;
				}
	
				// 두 동전 모두 안떨어진 경우 
				// 동전이 벽을 만난 경우
				if(map[nr1][nc1] == '#' && map[nr2][nc2] == '#') continue;
				
				if(map[nr1][nc1] == '#') {
					nr1 = p1.r;
					nc1 = p1.c;
				}
				if(map[nr2][nc2] == '#') {
					nr2 = p2.r;
					nc2 = p2.c;
				}
				q.add(new Point(nr1,nc1,p1.cnt+1));
				q.add(new Point(nr2,nc2,p2.cnt+1));
			}
		}
	}
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
