package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11062 {
    static int[] cards;
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int N = 0, sum;

        for(int t = 1; t<= T; t++) {
            N = Integer.parseInt(br.readLine());
            cards = new int[N];
            dp = new int[N][N];
            st = new StringTokenizer(br.readLine());
            sum = 0;
            for(int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                sum+= cards[i];
            }
            int res = go(0, N-1, sum);

            System.out.println(res);
        }
    }
    public static int go(int s, int e, int sum) {
        int temp;
        if(dp[s][e] != 0){
            return dp[s][e];
        }
        if(s >= e) {
            return cards[s];
        }else {
            temp = Math.max(sum - go(s + 1, e, sum - cards[s]), sum - go(s, e-1, sum - cards[e]));
            dp[s][e] = temp;
            return temp;
        }
    }
}
