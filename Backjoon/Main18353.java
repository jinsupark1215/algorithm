package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18353 {

	/*
	 * [백준] 병사 배치하기
	 * 
	 * 1. 남은 인원을 최대가 될 떄 열외해야하는 병사 수
	 * 
	 * 2. N<=2000
	 * 
	 * 3. 뺴보는 조합 짜서 되는 순간 답 - > 시간초과
	 * 
	 * dp 이용 : 커지는 숫자가 몇개인지 세보는
	 */
	static int N;
	static int[] num, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		dp[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			int n = 1;
			for (int j = i + 1; j < N; j++) {
				if (num[i] > num[j])
					n = Math.max(n, dp[j] + 1);
			}
			dp[i] = n;
		}
		int n = 0;
		for (int i = 0; i < N; i++) {
			n = Math.max(n, dp[i]);
		}
		System.out.println(N - n);
	}
}
