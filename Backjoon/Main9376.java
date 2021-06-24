package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main9376 {
    static int N, M;
    static char[][] S;

    static final int[] dy = { -1, 1, 0, 0 };
    static final int[] dx = { 0, 0, -1, 1 };

    static final int INF = 10000;

    static boolean inRange(int y, int x) { return 0 <= y && y < N && 0 <= x && x < M; }

    static int[][] bfs(int[] s) {
        Deque<int[]> q = new LinkedList<>();
        q.offer(s);
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);
        dist[s[0]][s[1]] = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int y = p[0]; int x = p[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d]; int nx = x + dx[d];
                if (!inRange(ny, nx) || S[ny][nx] == '*' || dist[ny][nx] != INF) continue;
                if (S[ny][nx] == '#') q.offer(new int[] { ny, nx });
                else q.offerFirst(new int[] { ny, nx });
                dist[ny][nx] = dist[y][x] + (S[ny][nx] == '#' ? 1 : 0);
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()) + 2;
            M = Integer.parseInt(st.nextToken()) + 2;
            S = new char[N][M];
            Arrays.fill(S[0], '.');
            for (int i = 1; i <= N - 2; i++) S[i][0] = S[i][M - 1] = '.';
            Arrays.fill(S[N - 1], '.');
            int[] A = null; int[] B = null;
            for (int i = 1; i <= N - 2; i++) {
                String row = br.readLine();
                for (int j = 1; j <= M - 2; j++) {
                    S[i][j] = row.charAt(j - 1);
                    if (S[i][j] == '$') {
                        if (A == null) A = new int[] { i, j };
                        else B = new int[] { i, j };
                    }
                }
            }
            int[][][] dist = new int[3][N][M];
            dist[0] = bfs(A);
            dist[1] = bfs(B);
            dist[2] = bfs(new int[] { 0, 0 });
            int min = 30000;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    min = Math.min(min, dist[0][i][j] + dist[1][i][j] + dist[2][i][j] - (S[i][j] == '#' ? 2 : 0));
            bw.append(min).append("\n");
        }
        System.out.print(bw);
    }

}
