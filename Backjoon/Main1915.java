package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1915 {
    static int N,M;
    static char [][] map;
    static int [][] dp;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        map = new char [N][M];
        dp = new int [N+1][M+1];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(map[i-1][j-1] == '1') {
                    int t = Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(t, dp[i-1][j-1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        System.out.println(max*max);
    }

}
