package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20056 {
    static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static Ball map[][], tmp[][];
    static int ans, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new Ball[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c] = new Ball(m, s, d);
        }
        for (int i = 0; i < K; i++)
            move();
        sol();
        System.out.println(ans);
    }

    static void sol() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Ball b = map[i][j];
                if (b == null)
                    continue;
                if (b.cnt == 1)
                    ans += b.m;
                else
                    ans += b.m / 5 * 4;
            }
        }
    }

    static void move() {
        tmp = new Ball[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null)
                    continue;
                Ball b = map[i][j];
                int z = 1;
                if (b.cnt > 1) {
                    if (!b.even || !b.odd)
                        b.d = 0;
                    else
                        b.d = 1;
                    b.m /= 5;
                    b.s /= b.cnt;
                    z = 4;
                    if (b.m == 0)
                        continue;
                }
                for (int k = 0; k < z; k++, b.d += 2) {
                    int nr = (i + dr[b.d] * b.s + (N * b.s)) % N;
                    int nc = (j + dc[b.d] * b.s + (N * b.s)) % N;
                    if (tmp[nr][nc] == null) {
                        tmp[nr][nc] = new Ball(b.m, b.s, b.d);
                    } else {
                        Ball b2 = tmp[nr][nc];
                        b2.m += b.m;
                        b2.s += b.s;
                        b2.cnt++;
                        if (b.d % 2 == 0)
                            b2.even = true;
                        else
                            b2.odd = true;
                        tmp[nr][nc] = b2;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++)
            map[i] = tmp[i].clone();
    }

    static class Ball {
        int m, s, d, cnt;
        boolean odd, even;

        public Ball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
            this.cnt = 1;
            if(this.d%2==0)
                even=true;
            else
                odd=true;
        }
    }
}
