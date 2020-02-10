package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2117_홈방범서비스 {

	/*
	 * 1. 손해보지 않고 홈서비스를 가장많이 제공받는 집들의 수
	 * 
	 * 2.  N <= 20, M <= 10
	 * 
	 * 3. bfs를 통해서 최대이익 찾기
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map;
	static boolean[][] visit;
	static int N,M, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i,j);					
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void bfs(int r, int c) {
			Queue<Point> q = new LinkedList<>();
			visit = new boolean[N][N];
			
			q.add(new Point(r,c));
			visit[r][c] = true;
			
			int idx = 1;
			int home = 0;
			if(map[r][c] == 1)home = 1;
			
			//k가 1인 경우도 생각
			if (0 <= (M * home) - ((idx * idx) + (idx-1)*(idx-1))) {
				ans = Math.max(ans, home);
			}
			
			while (!q.isEmpty()) {
				int size = q.size();
				idx++;
				for (int k = 0; k < size; k++) {
					Point p = q.poll();

					for (int j = 0; j < 4; j++) {
						int nr = p.r + pos[j][0];
						int nc = p.c + pos[j][1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
							visit[nr][nc] = true;
							q.add(new Point(nr, nc));
							if (map[nr][nc] == 1)
								home++;
						}
					}
				}
				if (0 <= (M * home) - ((idx * idx) + (idx-1)*(idx-1))) {
					ans = Math.max(ans, home);
				}
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
