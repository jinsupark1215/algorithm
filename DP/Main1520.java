package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1520 {

	/*
	 * 1. 이동 가능한 경로의 수
	 * 
	 * 2. M,N <=500
	 * 
	 * 3. DFS + DP
	 */
	static int M,N;
	static int[][] map, dp;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp= new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		 System.out.println(dfs(0, 0));
	}
	 
	public static int dfs(int r, int c) {
	    if (r == M-1 && c == N-1) {
	        return 1;
	    }
	 
	    if(dp[r][c] !=-1) {
	    	return dp[r][c];
	    }
	    
	        dp[r][c] = 0;
	        for (int i = 0; i < 4; i++) {
	            int nr = r + pos[i][0];
	            int nc = c + pos[i][1];
	 
	            if (nr >=0 && nr < M && nc >=0 && nc < N) {
	                if (map[r][c] > map[nr][nc]) {
	                    dp[r][c] += dfs(nr, nc);
	                }
	            }
	        }
	    return dp[r][c];
	}
}
