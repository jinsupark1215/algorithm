package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14585 {
    /*
    [백준] 사수 빈탕
    1. 사탕의 최대 갯수

    2.

    3. dp
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] bucket = new int[301][301];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int remain = M - (x + y);

            bucket[x][y] = remain <= 0 ? 0: remain;
        }

        System.out.println(getCandies(N, bucket));
    }

    private static int getCandies(int n, int[][] candy) {
        int[][] dp = new int[301][301];

        for(int i = 1; i < 301; i++) {
            dp[0][i] = dp[0][i - 1] + candy[0][i];
        }

        for(int i = 1; i < 301; i++) {
            dp[i][0] = dp[i - 1][0] + candy[i][0];
        }

        for(int i = 1; i < 301; i++) {
            for(int j = 1; j < 301; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + candy[i][j];
            }
        }

        return dp[300][300];
    }
}
