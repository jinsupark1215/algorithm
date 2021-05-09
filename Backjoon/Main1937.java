package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1937 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int[][] dp;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = stoi(br.readLine());

        ans = 0;
        map = new int[N][N];
        dp = new int[N][N];

        for(int r = 0 ; r < N ; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; ++c) {
                map[r][c] = stoi(st.nextToken());
            }
        }

        for(int r = 0 ; r < N ; ++r) {
            for(int c = 0 ; c < N ; ++c) {
                int way = dfs(r, c);
                ans = way > ans ? way : ans;
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int r, int c) {
        if(dp[r][c] != 0) return dp[r][c];

        dp[r][c] = 1;

        for(int d = 0 ; d < 4 ; ++d) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;

            if(map[nr][nc] > map[r][c]) {
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }
        }

        return dp[r][c];
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}