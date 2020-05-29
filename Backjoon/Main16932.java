package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16932 {

	/*
	 * [백준] 모양만들기
	 * 
	 * 1. 가장 큰 모양을 만드는 법
	 * 
	 * 2. N,M <=1000
	 * 
	 * 3. 0을 1로 바꿔보고 가보고
	 */
	static int N, M, ans, idx;
	static int[][] map;
	static int[][] visit;
	static boolean[] chk;
	static int[] size;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		idx = 1;
		map = new int[N][M];
		visit = new int[N][M];
		size = new int[100000];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] == 0 && map[i][j] == 1) {
					bfs(i,j);
					idx++;
				}
			}
		}
		
		
		chk = new boolean[idx];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					go(i,j);
				}
			}
		}

		System.out.println(ans);
	}

	private static void go(int r, int c) {
		int sum = 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nr< N && nc >=0 && nc < M && !chk[visit[nr][nc]]) {
				sum+= size[visit[nr][nc]];
				chk[visit[nr][nc]] = true;
			}
		}
		if(ans<sum)ans = sum;
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nr< N && nc >=0 && nc < M) {
				chk[visit[nr][nc]] = false;
			}
		}
	}

	private static void bfs(int r, int c) {

		visit[r][c] = idx;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		int cnt = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && visit[nr][nc] == 0 && map[nr][nc] == 1) {
					visit[nr][nc] = idx;
					q.add(new Point(nr, nc));
					cnt++;
				}
			}
		}
		size[idx] = cnt; 
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
