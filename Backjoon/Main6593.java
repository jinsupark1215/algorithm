package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {

	/*
	 * [백준] 상범 빌딩
	 * 
	 * 1. 탈출 할 수 있는지 없는지
	 * 
	 * 2. L,R,C <= 30
	 * 
	 * 3. 3차원 bfs
	 */
	static int L,R,C,x;
	static char[][][] map;
	static boolean[][][] visit;
	static Queue<Point> q;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			x = 0;
			
			if(L==0 && R ==0 && C==0)break;
			
			map = new char[L][R][C];
			visit = new boolean[L][R][C];
			q = new LinkedList<>();
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String input = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = input.charAt(k);
						if(map[i][j][k] =='S') {
							q.add(new Point(i,j,k,0));
							visit[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}
			
			bfs();
			
			if(x ==0)System.out.println("Trapped!");
			else System.out.println("Escaped in " + x +" minute(s).");
		}
	}

	private static void bfs() {
		int nr=0,nc=0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(map[p.z][p.r][p.c]== 'E' ) {
				x = p.dist;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				nr = p.r + pos[i][0];
				nc = p.c + pos[i][1];
				if(nr>=0 && nr < R && nc>=0 && nc< C && map[p.z][nr][nc] != '#' && !visit[p.z][nr][nc]) {
					visit[p.z][nr][nc] = true;
					q.add(new Point(p.z,nr,nc,p.dist+1));
				}
			}
			if(p.z < L-1 && map[p.z+1][p.r][p.c] != '#' && !visit[p.z+1][p.r][p.c]) {
				visit[p.z+1][p.r][p.c] = true;
				q.add(new Point(p.z+1,p.r,p.c,p.dist+1));
			}
			if(p.z-1 >=0 && map[p.z-1][p.r][p.c] != '#' && !visit[p.z-1][p.r][p.c]) {
				visit[p.z-1][p.r][p.c] = true;
				q.add(new Point(p.z-1,p.r,p.c,p.dist+1));
			}
		}
	}
	
	static class Point{
		int z,r,c,dist;

		public Point(int z, int r, int c, int dist) {
			super();
			this.z = z;
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

	}
}
