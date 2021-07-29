package Backjoon;

import java.io.*;
import java.util.*;

public class Main3987 {
    static int N, M;
    static char[][] map;

    static final int INF_LOOP = -1;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken()) - 1;
        int col = Integer.parseInt(st.nextToken()) - 1;
        int max = Integer.MIN_VALUE;
        int dir = 0;
        for(int i=0; i<4; i++) {
            int ret = simulate(row, col, i);
            if(ret == INF_LOOP) {
                System.out.println(printer(i));
                System.out.println("Voyager");
                return;
            } else if(ret > max){
                max = ret;
                dir = i;
            }
        }
        System.out.println(printer(dir));
        System.out.println(max);
    }

    public static int simulate(int row, int col, int dir) {
        boolean[][][] visit = new boolean[4][N][M];
        int count = 1;
        while(inside(row+dr[dir], col+dc[dir]) && map[row+dr[dir]][col+dc[dir]] != 'C') {
            row += dr[dir];
            col += dc[dir];
            if(visit[dir][row][col]) {
                return -1;
            }
            count++;
            visit[dir][row][col] = true;
            if(map[row][col] == '/') {
                if(dir == 0 || dir == 2) dir++;
                else dir--;
            } else if(map[row][col] == '\\') {
                if (dir == 0 || dir == 2) dir = (dir + 3) % 4;
                else  dir = (dir + 1) % 4;
            }
        }
        return count;
    }

    public static boolean inside(int row, int col) {
        return (row >= 0 && col >= 0 && row < N && col < M);
    }

    public static String printer(int dir) {
        if	   (dir == 0) return "U";
        else if(dir == 1) return "R";
        else if(dir == 2) return "D";
        else if(dir == 3) return "L";
        return "ERR";
    }
}
