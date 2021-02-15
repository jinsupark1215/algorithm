package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2302 {
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = 1;
        int[] dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i < N+1 ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        int temp = 0 ;
        for(int i = 0 ; i < M ; i++){
            int m = Integer.parseInt(br.readLine());
            result *= dp[m-temp-1];
            temp = m;
        }

        result *= dp[N-temp];

        System.out.println(result);
    }

}
