package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20002 {

	static int ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		ans= 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = map[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
				ans = (ans < map[i][j])?map[i][j] : ans;
			}
		}
		
		
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <=N; j++) {
				for (int k = i; k <= N; k++) {
					int tmp = dp[j][k] - dp[j-i][k] - dp[j][k-i] + dp[j-i][k-i];
					ans = (ans < tmp) ? tmp : ans;
				}
			}
		}
		
		System.out.println(ans);
	}
}
