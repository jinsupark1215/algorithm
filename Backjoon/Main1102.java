package Backjoon;

import java.io.*;
import java.util.*;

class Main1102{

    static int P, N;
    static int[] dp;
    static int[][] cost;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        // System.setIn(new FileInputStream("test2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parse(br.readLine());

        cost = new int[N+1][N+1];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char[] ch = br.readLine().toCharArray();
        int visited = 0;
        for(int i=0; i<N; i++) {
            if(ch[i] == 'Y') {
                visited |= (1<<i);
            }
        }
        P = parse(br.readLine());

        dp = new int[1<<16]; Arrays.fill(dp, INF);
        int kkk = fixed(visited);
        System.out.print( kkk == INF ? "-1" : kkk);
    }


    static int fixed(int visited) {
        if(dp[visited] != INF ) return dp[visited];
        if(Integer.bitCount(visited) >= P) return 0;

        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0) {
                for (int j = 0; j < N; j++) {
                    if ((visited & (1 << j)) == 0) {
                        dp[visited] = Math.min(dp[visited], fixed(visited | (1 << j)) + cost[i][j]);
                    }
                }

            }
        }
        return dp[visited];
    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }

}