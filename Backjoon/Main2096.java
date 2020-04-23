package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2096 {

	/*
	 * [백준] 내려가기
	 * 
	 * 1. 최대점수와 최소 점수
	 * 
	 * 2. N <=100,000
	 * 
	 * 3. dp이용
	 */
	static int n;
    static int dp[][] = new int[100001][3];
    static int map[][] = new int [100001][3];
    
    public static void main(String args[]) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        
        dp[1][0]=map[1][0];
        dp[1][1]=map[1][1];
        dp[1][2]=map[1][2];
        
        for(int i = 2 ; i <= n ; i++){
            dp[i][0]=map[i][0]+Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1]=map[i][1]+Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][2]=map[i][2]+Math.max(dp[i-1][1], dp[i-1][2]);
        }
        int max = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        
        for(int i = 2 ; i <= n ; i++){
            dp[i][0]=map[i][0]+Math.min(dp[i-1][0], dp[i-1][1]);
            dp[i][1]=map[i][1]+Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]));
            dp[i][2]=map[i][2]+Math.min(dp[i-1][1], dp[i-1][2]);
        }
        int min = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        
        System.out.println(max + " " + min);
    }
}
