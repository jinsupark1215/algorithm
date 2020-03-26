package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {

	/*
	 * [백준] 계단오르기
	 * 1. 얻을 수 있는 최댓값
	 * 
	 * 2. N <= 300
	 * 
	 * 3. dfs 탐색 - > 시간초과
	 * 
	 * dp 이용
	 * 점화식 
	 * 1번 연속인 경우 ans[n] = ans[n-2] + A[n];
	 * 2번 연속인 경우 ans[n] = A[n] + A[n-1] + ans[n-3];
	 */
	static int N;
	static int[] A, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A= new int[N+1];
		ans = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		ans[1] = A[1];
		if(N>=2) ans[2] = ans[1]+A[2];
		
		for (int i = 3; i <= N; i++) {
			ans[i] = Math.max(ans[i-2]+A[i], A[i] + A[i-1] + ans[i-3]);
		}
		
		System.out.println(ans[N]);
	}
}
