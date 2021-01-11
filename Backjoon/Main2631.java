package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main2631 {

	/*
	 * [백준] 줄세우기
	 * 
	 * 1. 줄을 세우는 옮겨지는 최소수
	 * 
	 * 2.
	 * 
	 * 3. dp
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n+1];
        int [] dp = new int[n+1];
        
        for(int i=1; i<=n; i++)
            a[i] = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++) {
            dp[i] = 1;
            for(int j=1; j<i; j++) {
                if(a[i] > a[j] && dp[i]<=dp[j]) {
                    dp[i] = dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(n-dp[n]);


	}
}
