package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18224 {

	/*
	 * [백준] 미로에 갇힌 건우
	 * 
	 * 1. 최소로 도착지에 도착하는 날 시간
	 * 
	 * 2. n <= 500 , m <=10
	 * 
	 * 3. bfs 및 조건 구현
	 */
	static int N,M,ans;
	static boolean flag;
	static String answer;
	static int[][] map;
	static boolean[][][][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N][M+1][2];
		flag = false;
		answer = "";
		ans = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		if(flag) {
			System.out.println(ans + " " + answer);
		}else {
			System.out.println(ans);
		}
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0,1,0));
		visit[0][0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == N-1 && p.c == N-1) {
				flag = true;
				ans = p.day;
				if(p.light == 0)answer = "sun";
				else answer = "moon";
				
				break;
			}
			
			if(p.light ==0) {
				//낮에 이동하는 경우
				for (int i = 0; i < 4; i++) {
					int nr = p.r + pos[i][0];
					int nc = p.c + pos[i][1];
					if(nr>=0 && nr< N && nc >=0 && nc< N && map[nr][nc] ==0 ) {
						if((p.dist+1) % M ==0) {
							if(!visit[nr][nc][(p.dist+1) % M][1]) {
							visit[nr][nc][(p.dist+1) % M][1] = true;
							q.add(new Point(nr,nc,p.dist+1,((p.dist+1)/(M*2))+1,1));
							}
						}else {
							if(!visit[nr][nc][(p.dist+1) % M][0]) {
								visit[nr][nc][(p.dist+1) % M][0] = true;
							q.add(new Point(nr,nc,p.dist+1,((p.dist+1)/(M*2))+1,0));
							}
						}
					}
				}
				//가만히 거리가 늘어나는 경우
//				if((p.dist+1) % M ==0) {
//					q.add(new Point(p.r,p.c,p.dist+1,((p.dist+1)/(M*2))+1,1));
//				}else {
//					q.add(new Point(p.r,p.c,p.dist+1,((p.dist+1)/(M*2))+1,0));
//				}
			}else {
				//밤의 경우
				for (int i = 0; i < 4; i++) {
					for (int j = 1; j < N; j++) {
						int nr = p.r + (pos[i][0]*j);
						int nc = p.c + (pos[i][1]*j);
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
							if (!visit[nr][nc][(p.dist+1) % M][0] || !visit[nr][nc][(p.dist+1) % M][1]) {
								if ((p.dist + 1) % M == 0) {
									if(!visit[nr][nc][(p.dist+1) % M][0]) {
										visit[nr][nc][(p.dist+1) % M][0] = true;
									q.add(new Point(nr,nc,p.dist+1,((p.dist+1)/(M*2))+1,0));
									}
								} else {
									if(!visit[nr][nc][(p.dist+1) % M][1]) {
										visit[nr][nc][(p.dist+1) % M][1] = true;
										q.add(new Point(nr,nc,p.dist+1,((p.dist+1)/(M*2))+1,1));
										}
								}
								break;
							} else
								break;
						}
					}
				}
			}
		}
	}
	static class Point{
		int r,c,dist,day,light;

		public Point(int r, int c, int dist, int day, int light) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.day = day;
			this.light = light;
		}
	}
}
