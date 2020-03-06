package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5656_벽돌깨기 {

	/*
	 * 1. 최소로 남은 벽돌의 갯수
	 * 
	 * 2. N <=4 , W <=12, H <=15
	 * 
	 * 3. 완전탐색
	 */
	static int N, W, H,ans;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			
			int[][] map = new int[H][W];
			int cnt =0;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0)cnt++;
				}
			}
			
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					if(map[j][i] != 0) {
						dfs(j,i,0,cnt,map);
						break;
					}
				}
			}
			
			System.out.println("#"+ tc + " " + ans);
		}
	}
	private static void dfs(int r, int c, int idx,int cnt, int[][] map) {
		if(idx == N) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		//맵 복사
		int[][] tmp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		//터트리기
		boolean[][] visit = new boolean[H][W];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c,tmp[r][c]));
		visit[r][c] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < p.cnt; j++) {
					int nr = p.r + (pos[i][0] * j);
					int nc = p.c + (pos[i][1] * j);
					if(nr>=0 && nr< H && nc>=0 && nc < W && tmp[nr][nc] !=0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new Point(nr,nc,tmp[nr][nc]));
					}
				}
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(visit[i][j]) {
					tmp[i][j] = 0;
					cnt--;
				}
			}
		}
		if(cnt == 0) {
			ans = 0;
			return;
		}
		
		//내리기
		down(tmp);

		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if(tmp[j][i] != 0) {
					dfs(j,i,idx+1,cnt, tmp);
					break;
				}
			}
		}
	}
	private static void down(int[][] map) {
		for (int i = 0; i < W; i++) {
			Queue<Integer> q = new LinkedList<>();
			for (int j = H-1; j >=0; j--) {
				if(map[j][i] !=0) {
					q.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			int size = q.size();
			int idx = H-1;
			for (int j = 0; j < size; j++) {
				map[idx][i] = q.poll();
				idx--;
			}
		}
		
	}
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
