package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14497 {

	/*
	 * [백준] 주난의 난
	 * 
	 * 1. 주난이가 범인을 잡기위해 최소 몇번의 점프를 해야하는지 출력
	 * 
	 * 2. N,M <=300
	 * 
	 * 3. BFS
	 */
	static int N, M, er, ec, sr, sc, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		ans = 1;

		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		er = Integer.parseInt(st.nextToken()) - 1;
		ec = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		
		while(true) {
			q = new LinkedList<>();
			visit = new boolean[N][M];
			q.add(new Point(sr, sc));
			visit[sr][sc] = true;
			if(bfs())break;
			ans++;
		
		}

		System.out.println(ans);
	}

	private static boolean bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < 300; j++) {
					int nr = p.r + (pos[i][0] * j);
					int nc = p.c + (pos[i][1] * j);
					if(nr>=0 && nr < N && nc>=0 && nc < M && !visit[nr][nc]) {
						if(map[nr][nc] == 0) {
							visit[nr][nc] = true;
							q.add(new Point(nr,nc));
						}else if(map[nr][nc] == 1) {
							visit[nr][nc] = true;
							map[nr][nc] =0;
							break;
						}else if(map[nr][nc] == -13)return true;
					}else break;
				}
			}
		}
		return false;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
