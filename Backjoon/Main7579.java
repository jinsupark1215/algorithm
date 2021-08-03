package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7579 {

    static int N;
    static int M;
    static int[] Mi;
    static int[] Ci;
    static int[] dp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        Mi = new int[N+1];
        Ci = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            Mi[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            Ci[i] = Integer.valueOf(st.nextToken());
        }

        System.out.println(dynamic());
    }

    static int dynamic(){
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += Ci[i];
        }

        dp = new int[sum+1];
        for(int i = 1; i <= N; i++){
            for(int j = sum; j >= Ci[i]; j--){
                if(dp[j] < dp[j - Ci[i]] + Mi[i])
                    dp[j] = dp[j - Ci[i]] + Mi[i];
            }
        }

        int min = 0;
        for(int i = 0; i <= sum; i++){
            if(dp[i] >= M){
                min = i;
                break;
            }
        }

        return min;
    }
}
