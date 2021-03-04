package Backjoon;

import java.io.*;

public class Main1256 {
    /*
    [백준] 사전

    1. 사전에 수록된 문자열

    2.

    3.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        long k = (long)Integer.parseInt(temp[2]);

        int N = n+m;

        long ncr[][] = new long[N+1][m+1];

        for(int i=0;i<=N;i++) {
            ncr[i][0]=1;
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=m;j++) {
                ncr[i][j]=ncr[i-1][j-1] + ncr[i-1][j];
            }
        }

        StringBuffer sb= new StringBuffer();
        if( ncr[N][m] <0  || ncr[N][m] >= k ) {
            int s = N-1;

            for(int i=1;i<=N;i++) {
                if( k <= ncr[s][m] || ncr[s][m]<0 ) {
                    sb.append("a");
                }else {
                    sb.append("z");
                    k=k-ncr[s][m];
                    m--;
                }
                s--;
            }
        }else{
            sb.append("-1");
        }
        bw.write(sb.toString()+"\n");
        bw.flush();
    }
}
