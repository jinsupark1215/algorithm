package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2573_빙산 {

	/*
	 * 1. 두덩어리 이상으로 분리되는 년수
	 * 
	 * 2. N, M <= 300
	 * 
	 * 3. 
	 * 3-1. bfs로 총 방문갯수가 2개이상이면 끝
	 * 3-2. 방문하면서 주변에 0이 몇개인지 세고 뺴주기
	 */
	static int N,M,ans;
	static int[][] map;
	static int[][] tmp;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		while(true) {
			int cnt = 0;
			visit = new boolean[N][M];
			tmp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!visit[i][j] && map[i][j] > 0) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			if(cnt > 1)break;
			else if(cnt ==0) {
				ans = 0;
				break;
			}else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						map[i][j] -= tmp[i][j];
					}
				}
			}
			
			
			ans++;
		}
		System.out.println(ans);
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr>=0 &&nr < N &&	nc >=0 && nc< M && !visit[nr][nc]) {
					if(map[nr][nc] <= 0) {
						tmp[p.r][p.c]++; 
					}else if(map[nr][nc] >0){
						visit[nr][nc] = true;
						q.add(new Point(nr,nc));
					}
				}
			}
		}
		
		
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
