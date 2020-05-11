package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17069 {

	/*
	 * [백준] 파이프 옮기기 2
	 * 
	 * 1. 오른쪽 끝에 도달할 수 있는 방법의 갯수
	 * 
	 * 2. N <=16
	 * 
	 * 3. dfs 구현 + dp이용해서 모든 방법 수
	 */
	static int N, ans;
	static int[][] map;
	static long[][][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		dp = new long[N][N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		//0은 가로, 1은 세로,2는 대각선
		
		System.out.println(dfs(0,1,0));
	}
	private static long dfs(int r, int c, int dir) {
		if(dp[r][c][dir] != -1)return dp[r][c][dir];
		if(r == N-1 && c == N-1) {
			return 1;
		}
		dp[r][c][dir] = 0;
		
		if(dir ==0) {
			//가로
			if(c+1 < N && map[r][c+1] ==0) {
				dp[r][c][dir] += dfs(r,c+1,0);
			}
			//대각선
			if(r+1 < N &&c+1 < N && map[r+1][c+1] ==0 && map[r+1][c]==0 && map[r][c+1]==0) {
				dp[r][c][dir] +=dfs(r+1,c+1,2);
			}
		}else if(dir == 1) {
			//세로
			if(r+1 < N && map[r+1][c] ==0) {
				dp[r][c][dir] +=dfs(r+1,c,1);
			}
			//대각선
			if(r+1 < N &&c+1 < N && map[r+1][c+1] ==0 && map[r+1][c]==0 && map[r][c+1]==0 ) {
				dp[r][c][dir] +=dfs(r+1,c+1,2);
			}
		}else if(dir == 2) {
			//가로
			if(c+1 < N && map[r][c+1] ==0) {
				dp[r][c][dir] +=dfs(r,c+1,0);
			}
			//세로
			if(r+1 < N && map[r+1][c] ==0) {
				dp[r][c][dir] +=dfs(r+1,c,1);
			}
			//대각선
			if(r+1 < N &&c+1 < N && map[r+1][c+1] ==0 && map[r+1][c]==0 && map[r][c+1]==0) {
				dp[r][c][dir] +=dfs(r+1,c+1,2);
			}
		}
		
		return dp[r][c][dir];
	}
}
