package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18427 {

	/*
	 * 1. H를 만들 수 있는 경우의 수
	 * 
	 * 2. N,M <=50, H <=1000
	 * 
	 * 3. 완탐 ( 시간초과 )
	 */
	static int N, M, H, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(ans%10007);
	}

	private static void dfs(int r, int c, int sum) {
		if(sum == H) {
			ans++;
			return;
		}else if(sum > H || r== N) {
			return;
		}else {
			for (int i = 0; i < M; i++) {
				if(map[r][i] != 0) {
					dfs(r+1,0,sum+map[r][i]);
				}else break;
			}
			dfs(r+1,0,sum);
		}
	}
}
