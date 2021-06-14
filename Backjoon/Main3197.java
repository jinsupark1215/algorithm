package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3197 {
    static final int N_MAX = 2250000;
    static int R, C;
    static int tNum;
    static int []lnum = new int [2];
    static int [][]q_comm = new int [1500][1500];
    static int [][]vst = new int [1500][1500];
    static char [][]arr = new char [1500][1500];
    static int [] p = new int [N_MAX];
    static int [] r = new int [N_MAX];
    static int [] dy = { 1, -1, 0, 0 };
    static int [] dx = { 0, 0, 1, -1 };
    static Queue<int[]> q = new ArrayDeque<>();
    static Queue<int[]> tq = new ArrayDeque<>();
    static int tRound;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int l = 0;
        for(int i = 0; i < R; i++) {
            String str = br.readLine();

            for(int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);

                if(arr[i][j] == 'L' || arr[i][j] == '.') {
                    vst[i][j] = ++tNum;
                    p[tNum] = tNum;

                    q.add(new int[] {i, j});

                    if(arr[i][j] == 'L') {
                        lnum[l] = tNum;
                        l++;
                        arr[i][j] = '.';
                    }
                }
            }
        }
        while(!q.isEmpty()) {
            while(!q.isEmpty()) {
                int c[] = q.element();
                int y = c[0], x = c[1];
                q.poll();
                int ny, nx;
                for(int i = 0; i < 4; i++) {
                    ny = y + dy[i];
                    nx = x + dx[i];
                    if(is_valid_xy(ny, nx)) {
                        if(arr[ny][nx] == '.' && find(vst[ny][nx]) != find(vst[y][x])) {
                            union(vst[ny][nx], vst[y][x]);
                        }
                        else if(arr[ny][nx] == 'X') {
                            if(q_comm[y][x] == 0) {
                                tq.offer(new int[] {y, x});
                                q_comm[y][x] = 1;
                            }
                        }
                    }
                }
            }
            if(find(lnum[0]) == find(lnum[1])) {
                System.out.println(tRound);
                break;
            }
            while(!tq.isEmpty()) {
                int c[] = tq.element();
                int y = c[0], x = c[1];
                tq.poll();
                int ny, nx;
                for(int i = 0; i < 4; i++) {
                    ny = y + dy[i];
                    nx = x + dx[i];
                    if(is_valid_xy(ny, nx)) {
                        if(arr[ny][nx] == 'X') {
                            vst[ny][nx] = vst[y][x];
                            arr[ny][nx] = '.';
                            q.offer(new int [] {ny, nx});
                        }
                    }
                }
            }
            tRound++;
        }
    }
    static boolean is_valid_xy(int y, int x) {
        if(y >= 0 && y < R && x >= 0 && x < C) {
            return true;
        }
        else
            return false;
    }
    static int find(int u) {
        if(u == p[u]) {
            return u;
        }
        return p[u] = find(p[u]);
    }
    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(r[u] > r[v]) {
            u = u ^ v;
            v = u ^ v;
            u = u ^ v;
        }
        if(r[u] == r[v])
            r[v]++;

        if(u != v) {
            p[u] = v;
        }
    }
}

