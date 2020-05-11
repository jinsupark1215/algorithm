package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_까까오4 {

	/*
	 * 1. 도로를 만들 때 최소로 만드는 비용
	 * 
	 * 2. N<=25, 1은 벽
	 * 
	 * 3. bfs로 해당 방향이 몇번 꺽였는지 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};

		System.out.println(solution(board));
	}

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int ans;
	static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int solution(int[][] board) {
		ans = Integer.MAX_VALUE;

		N = board.length;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		visit = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0,0,0));
		q.add(new Point(0,0,1,0,0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nr = 0,nc=0;
			for (int i = p.dir; i < p.dir+4; i++) {
				nr = p.r+pos[i%4][0];
				nc = p.c+pos[i%4][1];
				if(nr>=0&& nc>=0 && nr< N && nc < N && board[nr][nc] ==0 &&
						((p.dist*100)+(p.curve * 500)<map[nr][nc] || map[nr][nc] ==0)) {
					if(p.dir == i) {
						q.add(new Point(nr,nc,p.dir,p.dist+1,p.curve));
						map[nr][nc] = Math.min(map[nr][nc],((p.dist+1)*100)+(p.curve * 500));
					}else {
						q.add(new Point(nr,nc,i,p.dist+1,p.curve+1));
						map[nr][nc] = Math.min(map[nr][nc],((p.dist+1)*100)+((p.curve+1) * 500));
					}
				}
			}
			if(p.r == N-1 && p.c == N-1)break;
		}
		return map[N-1][N-1];
	}
//	private static void dfs(int r, int c, int dir, int dist, int curve) {
//		if(r == N-1 && c ==N-1) {
//			ans = Math.min(ans, (dist*100)+(curve * 500));
//			return;
//		}
//		
//		visit[r][c] = true;
//		int nr=0,nc=0;
//		for (int i = dir; i < dir+4; i++) {
//			nr = r+pos[i%4][0];
//			nc = c+pos[i%4][1];
//			if(nr>=0&& nc>=0 && nr< N && nc < N && map[nr][nc] ==0 && !visit[nr][nc]) {
//				if(dir == i) {
//					dfs(nr,nc,dir,dist+1,curve);
//				}else {
//					dfs(nr,nc,i,dist+1,curve+1);
//				}
//			}
//		}
//		visit[r][c] = false;
//	}
	static class Point{
		int r,c,dir,dist,curve;

		public Point(int r, int c, int dir, int dist, int curve) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.dist = dist;
			this.curve = curve;
		}
	}
}
