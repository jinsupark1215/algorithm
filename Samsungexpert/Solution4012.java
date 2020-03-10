package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4012 {

	/*
	 * 1. 요리를 했을 때 발생하는 시너지 차이가 젤 작은것
	 * 
	 * 2. N <= 16
	 * 
	 * 3. 조합으로 N/2개를 선택 후 방문한 것들끼리 계산 후 최소 찾기
	 */
	static int N, ans;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visit = new boolean[N];
			sol(0,0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void sol(int idx, int cnt) {
		if (cnt > N / 2 || idx >= N)
			return;

		if (cnt == N / 2) {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					for (int j = 0; j < N; j++) {
						if (visit[j])
							sum1 += map[i][j];
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (!visit[j])
							sum2 += map[i][j];
					}
				}
			}
			ans = Math.min(ans, Math.abs(sum1-sum2));
			return;
		}
		
		for (int i = idx; i < N; i++) {			
		visit[i] = true;
		sol(i+1,cnt+1);
		visit[i] = false;
		}

	}
}

