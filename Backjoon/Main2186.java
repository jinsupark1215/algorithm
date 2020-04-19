package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2186 {

	/*
	 * [백준] 문자판
	 * 
	 * 1. 문자를 만들 수 있는 갯수
	 * 
	 * 2, N<=100, M<= 100
	 * 
	 * 3. dp 이용해야함 (난제)
	 */
	static int N,M,K;
	static char[][] map;
	static char[] str;
	static int[][][] dp;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new char[N][M];
		for(int i=0; i<N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		str=br.readLine().toCharArray();
		dp=new int[N][M][str.length];

		 for(int i = 0; i < N; i++) {
	            for(int j = 0; j < M; j++) {
	                Arrays.fill(dp[i][j], -1);
	            }
	        }
		
		int ans=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==str[0]) {
					ans+=dfs(i,j,0);
				}
			}
		}
		System.out.println(ans);
	}

	private static int dfs(int r, int c, int idx) {
		if (idx == str.length - 1)return dp[r][c][idx] = 1;
		if (dp[r][c][idx] != -1)	return dp[r][c][idx];

		dp[r][c][idx] = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= K; j++) {
				int nr = r + pos[i][0] * j;
				int nc = c + pos[i][1] * j;
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == str[idx + 1]) {
					dp[r][c][idx] += dfs(nr, nc, idx + 1);
				}
			}
		}

		return dp[r][c][idx];
	}
}
