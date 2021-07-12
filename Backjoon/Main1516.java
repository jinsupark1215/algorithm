package Backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main1516 {
    static int n;

    static int[] time;
    static boolean[][] adj;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        time = new int[n+1];
        adj = new boolean[n+1][n+1];
        memo = new int[n+1];
        for(int i = 1; i <= n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1)
                    break;
                adj[tmp][i] = true;
            }
        }

        for(int i = 1; i <= n; ++i)
            bw.write(dfs(i)+"\n");
        bw.flush();
    }

    static int dfs(int cur){
        if(memo[cur] == 0){
            memo[cur] = time[cur];
            for(int i = 1; i <= n; ++i){
                if(adj[i][cur])
                    memo[cur] = Math.max(memo[cur], time[cur]+dfs(i));
            }
        }
        return memo[cur];
    }
}