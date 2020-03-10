package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14889 {

	/*
	 * 1. 팀의 능력치 차이가  가장 최솟값 출력
	 * 
	 * 2. 
	 * 
	 * 3. 조합을 짜서 구현
	 */
	static int n, ans;
	static int[][] map;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		map = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nCr(0,0);
		
		System.out.println(ans);
	}
	private static void nCr(int idx, int cnt) {
		if(cnt == n/2) {
			ans = Math.min(ans, cal());
			return;
		}
		
		for (int i = idx; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				nCr(i+1, cnt+1);
				visit[i] = false;
			}
		}
	}
	private static int cal() {
		int sumStart = 0;
		int sumLink = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// true 면 스타트팀
				if (visit[i] && visit[j])
					sumStart += map[i][j];

				// false 면 링크팀
				if (visit[i] != true && visit[j] != true)
					sumLink += map[i][j];
			}
		}

		return Math.abs(sumStart - sumLink);
	}
}

