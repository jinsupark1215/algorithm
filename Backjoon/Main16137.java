package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16137 {

	/*
	 * [백준] 견우와 직녀
	 * 
	 * 1. 최소시간
	 * 
	 * 2. N<=10, M <=20
	 * 
	 * 3. BFS
	 */
	static Queue<Point> q;
	static boolean[][] visited;
	static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map;
	static int N, M, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = Integer.MAX_VALUE;
		q = new LinkedList<>();
		map = new int[N][N];

		for(int r = 0 ; r < N ; ++r) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; ++c) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0 ; r < N ; ++r) {
			for(int c = 0 ; c < N ; ++c) {
				// 절벽이며 
				if(map[r][c] == 0) {
					
					boolean[] isCliff = new boolean[4];
					
					for(int d = 0 ; d < 4 ; ++d) {
						int nr = r + pos[d][0];
						int nc = c + pos[d][1];
						
						if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;

						// 해당 방향에 절벽이 있는지 
						if(map[nr][nc] == 0) {
							isCliff[d] = true;
						}
					}
					if((isCliff[0] && isCliff[3]) || (isCliff[1] && isCliff[2]) ||
					   (isCliff[0] && isCliff[2]) || (isCliff[1] && isCliff[3])) continue;
					
					map[r][c] = M;
					visited = new boolean[N][N];
					bfs();
					map[r][c] = 0;
					
				}
			}
		}
		System.out.println(ans);
	}
	
	private static void bfs() {
		visited[0][0] = true;
		q.add(new Point(0, 0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == N - 1 && p.c == N - 1) {
				ans = ans > p.t ? p.t : ans;
				return;
			}
			
			for(int i = 0 ; i < 4 ; ++i) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				
				if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;
				if(map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				// 땅
				if(map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc, p.t + 1));
				}
				
				// 다리
				if(map[nr][nc] >= 2 && map[p.r][p.c] == 1) {
					if((p.t + 1) % map[nr][nc] == 0) {
						visited[nr][nc] = true;
						q.add(new Point(nr, nc, p.t + 1));
					} else {
						q.add(new Point(p.r, p.c, p.t + 1));
					}
				}
			}
		}
	}

	static class Point {
		int r, c, t;
		
		Point(int r, int c, int t){
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
}
