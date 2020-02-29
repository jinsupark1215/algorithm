package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2293_동점1 {

	/*
	 * 1. 경우의 수
	 * 
	 * 2. n <=100, k <=10000
	 * 
	 * 3. dp
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;//시작
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if(j-coin[i] >=0)dp[j] += dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
