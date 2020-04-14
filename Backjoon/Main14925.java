package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14925 {

	/*
	 * [백준] 목장 건설하기
	 * 
	 * 1. 최대 정사각형
	 * 
	 * 2. N,M <=1000
	 * 
	 * 3. 0마다 dfs ->시간초과
	 * dp 개념
	 */
	static int M,N,ans;
	static int[][] map, tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[M+1][N+1];
		tmp = new int[M+1][N+1];
		
		for (int i = 1; i  <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] == 0) {
					tmp[i][j]=Math.min(tmp[i-1][j], tmp[i-1][j-1]);
					tmp[i][j]=Math.min(tmp[i][j], tmp[i][j-1]) + 1;
					ans = Math.max(ans, tmp[i][j]);
				}
			}
		}
		System.out.println(ans);
	}
}
