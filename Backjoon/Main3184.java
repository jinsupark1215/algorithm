package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3184 {

	static int R, C, sheep, wolf;
	static char[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		sheep = 0;
		wolf = 0;
		
		/*
		 * 1. 문제 이해 : 살아남은 양의 수와 늑대의 수 출력
		 * 
		 * 2. 제약 조건 : # 울타리 못넘음
		 * 				o 양 
		 * 				v 늑대
		 * 				양 > 늑대  양이이김
		 * 				else 늑대가 이김
		 * 
		 * 3. map을 돌면서 울타리가 아니고 방문한 적이 없을 때 bfs.
		 * 	큐로 들어가서 양의 수와 늑대의 수를 체크하고 방문.
		 * 	다 돌고나와서 울타리 안의 총 양의 수와 늑대의 수를 비교해 최종 살아남은 늑대와 양의 수를 비교.
		 * 
		 */
		for (int i = 0; i < R; i++) {
			String a = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = a.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visit[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		
		
		System.out.println(sheep + " " + wolf);
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		int tmpsheep = 0;
		int tmpwolf = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			visit[p.r][p.c] = true;
			if(map[p.r][p.c] == 'o' )tmpsheep++;
			if(map[p.r][p.c] == 'v' )tmpwolf++;
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr>=0 && nc>=0 && nr< R && nc < C && !visit[nr][nc] && map[nr][nc] !='#') {
					visit[nr][nc] = true;
					q.add(new Point(nr,nc));
				}
			}
		}
		
		if(tmpsheep > tmpwolf) {
			sheep += tmpsheep;
		}else {
			wolf += tmpwolf;
		}
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
