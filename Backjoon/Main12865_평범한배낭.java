package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865_평범한배낭 {

	/*
	 * 1. 가치합의 최댓값
	 * 
	 * 2.
	 * 
	 * 3. knapsack문제 배낭
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] w=new int[n+1];
		int[] v=new int[n+1];
		int[] dp=new int[k+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			for(int j=k;j-w[i]>=0;j--) {
				dp[j]=Math.max(dp[j], dp[j-w[i]]+v[i]);
			}
		}
		System.out.println(dp[k]);
	}
}
