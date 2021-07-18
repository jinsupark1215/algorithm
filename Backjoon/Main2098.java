package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2098 {
    static int N, a[][], m[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        a = new int[N][N];
        m = new int[N][1<<N];
        StringTokenizer st;
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++) {
                a[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }
    static int tsp(int cur, int visited) {

        if(m[cur][visited] != 0) return m[cur][visited];

        if(visited == (1<<N) - 1) {
            if(a[cur][0] != 0) return a[cur][0];
            else return Integer.MAX_VALUE/2;
        }

        int min = Integer.MAX_VALUE/2;
        for(int i = 0 ; i < N; i++) {
            if(a[cur][i] == 0) continue;
            if((visited & (1 << i)) != 0) continue;

            min = Math.min(min, tsp(i, visited | (1 << i)) + a[cur][i]);
        }
        return m[cur][visited] = min;
    }
}
