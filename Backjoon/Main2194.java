package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2194 {

	/*
	 * [백준] 유닛 이동시키기
	 * 
	 * 1. 최소로 이동하기
	 * 
	 * 2. N,M <=500, A,B<=10, K <=100,000
	 * 
	 * 3. BFS
	 */
	static int[][] map;
	static boolean[][] visit;
	static int N,M,A,B,K,ans;
	static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		ans = -1;
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		Queue<Point> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		q.add(new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,0));
		st = new StringTokenizer(br.readLine());
		map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			visit[p.r][p.c]= true;
			
			if(map[p.r][p.c]== 2) {
				ans = p.dist;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr >=0 && nr < N && nc >=0 && nc < M && !visit[nr][nc]) {
					boolean flag = true;
					if(i == 0) {
						for (int j = 0; j < B; j++) {
							if(nc+B-1 >= M || nr+A-1 >= N || (nr+A-1 < N &&map[nr+A-1][nc+j] == 1)) {
								flag = false;
								break;
							}
						}
					}else if(i == 1) {
						for (int j = 0; j < A; j++) {
							if(nr + A-1 >= N || nc+B-1 >= M || (nc+B-1 < M &&map[nr+j][nc+B-1] == 1)) {
								flag = false;
								break;
							}
						}
					}else if(i == 2) {
						for (int j = 0; j < B; j++) {
							if(nc+B-1 >= M ||map[nr][nc+j] == 1) {
								flag = false;
								break;
							}
						}
					}else if(i == 3) {
						for (int j = 0; j < A; j++) {
							if(nr + A-1 >= N || map[nr+j][nc] == 1) {
								flag = false;
								break;
							}
						}
					}
					if(flag) {
						q.add(new Point(nr,nc, p.dist+1));
						visit[nr][nc] = true;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	static class Point{
		int r, c, dist;

		public Point(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

	}
}
