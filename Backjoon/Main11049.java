package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11049 {

    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] rows = new int[n+1];

        String[] input = br.readLine().split(" ");

        rows[0] = Integer.parseInt(input[0]);
        rows[1] = Integer.parseInt(input[1]);

        for(int i=2 ; i<=n ; i++){
            input = br.readLine().split(" ");
            rows[i] = Integer.parseInt(input[1]);
        }

        int[][] dp = new int[n+1][n+1];

        for(int i=1 ; i<=n ; i++){
            for(int j=i-1 ; j>0 ; j--){
                if(i==j) continue;
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k=j ; k<i ; k++){
                        min = Math.min(min, dp[k][j]+dp[i][k+1]+rows[i]*rows[k]*rows[j-1]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        System.out.print(dp[n][1]);
    }
}
