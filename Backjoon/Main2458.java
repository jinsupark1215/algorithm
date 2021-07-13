package Backjoon;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2458 {
    static int N, M;
    static int[][] adj;
    static boolean[] visit;

    public static void main(final String[] args) throws NumberFormatException, IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            final int v1 = Integer.parseInt(st.nextToken());
            final int v2 = Integer.parseInt(st.nextToken());

            adj[v1][v2] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i])
                continue;

            dfs(i);
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int curSum = 0;
            for (int j = 1; j <= N; j++) {
                curSum += adj[i][j] + adj[j][i];
            }
            if (curSum == N - 1)
                answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(final int s) {
        if (visit[s])
            return;

        for (int i = 1; i <= N; i++) {
            if (adj[s][i]==1) {
                dfs(i);
                for (int j = 1; j <= N; j++) {
                    adj[s][j] = adj[s][j] | adj[i][j];
                }
            }
        }

        visit[s] = true;
    }

}