package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1949 {

	/*
	 * 1. 최대 공사 가능 깊이 K만큼 팠을 때 최대 등산로 길이
	 * 
	 * 2. N<=8, K<=5, 가장 높은 봉우리 최대 5개, 1<=높이<=20, 높이는 1보다 작게 가능
	 * 
	 * 3. 최대 높이 산을 찾아 dfs 
	 */
	static int N, K, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			ans = 0;
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(map[i][j], max);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						visit = new boolean[N][N];
						dfs(i,j,map[i][j],1,false);
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int r ,int c, int height, int idx, boolean use) {
		visit[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr >=0 && nr < N && nc>=0 && nc < N && !visit[nr][nc]) {
				if(map[nr][nc]< height) {
					dfs(nr,nc,map[nr][nc],idx+1,use);	
				} else {

					if (!use) {
						for (int j = 1; j <= K; j++) {
							if (map[nr][nc] - j < height) {
								dfs(nr, nc, map[nr][nc] - j, idx + 1, true);
							}
						}
					}
				}
			}else {
//				visit = new boolean[N][N];
				ans = Math.max(ans , idx);
			}
		}
		visit[r][c] = false;
		
	}
}

