package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2352 {

	/*
	 * [백준] 반도체 설계
	 * 1. 최대 연결 갯수
	 * 
	 * 2.
	 * 
	 * 3. dp 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n + 1];
		dp[1] = arr[1];
		int len = 1;
		for (int i = 2; i <= n; i++) {
			if (arr[i] > dp[len]) dp[++len] = arr[i];
			else {
				int j;
				for (j = 1; j <= len; j++) {
					if (arr[i] <= dp[j]) break;
				}
				dp[j] = arr[i];
			}
		}
		System.out.println(len);
	}
}
