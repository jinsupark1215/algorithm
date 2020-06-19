package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17130 {

	/*
	 * [백준] 토끼가 정보섬에 올라온 이유
	 * 
	 * 1. 최대 갯수로 당근을먹는 수
	 * 
	 * 2. N,M <=1000
	 * 
	 * 3. BFS
	 */
	static int[][] pos = {{1,1},{0,1},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[][] dp = new int[N][M];
		int tmpr = 0,tmpc = 0;
		int ans = -1;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				dp[i][j]=-1;
				if(map[i][j] == 'R') {
					tmpr = i;tmpc=j;
					dp[i][j] = 0;
				}
			}
		}
		
		for (int c = tmpc + 1, sr = tmpr, er = tmpr; c < M; c++)
	    {
	        if (sr - 1 >= 0) --sr;
	        if (er + 1 < N) ++er;
	 
	        for (int r = sr; r <= er; r++)
	        {
	            if (map[r][c] == '#') continue;
	            if (dp[r][c - 1] != -1) dp[r][c] = Math.max(dp[r][c], dp[r][c - 1]);
	            if (r - 1 >= 0 && dp[r - 1][c - 1] != -1) dp[r][c] = Math.max(dp[r][c], dp[r - 1][c - 1]);
	            if (r + 1 < N && dp[r + 1][c - 1] != -1) dp[r][c] = Math.max(dp[r][c], dp[r + 1][c - 1]);
	            if (map[r][c] == 'C' && dp[r][c] != -1) ++dp[r][c];        
	            if (map[r][c] == 'O' && dp[r][c] != -1) ans = Math.max(ans, dp[r][c]);
	        }
	    }
		
		System.out.println(ans);
	}
}
