package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17136 {

	/*
	 * [백준] 색종이 붙이기
	 */
	static int [][] a = new int[10][10];
    static int [] coloredPaper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j=0; j<10; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
    }
    public static void dfs(int idx, int cnt) {
        if(idx == 100) { 
            ans = Math.min(ans, cnt);
            return;
        }
        if(ans <= cnt) return;
        int r = idx/10;
        int c = idx%10;
        if(a[r][c] == 1) {
            for(int i=5; i>0; i--) {
                if(coloredPaper[i] > 0) {
                    if(check(r, c, i)) {
                        fill(r, c, i, 0);
                        coloredPaper[i]--;
                        dfs(idx+1, cnt+1);
                        fill(r, c, i, 1);
                        coloredPaper[i]++;
                    }
                }
            }
        } else {
            dfs(idx+1, cnt);
        }
    }
    public static boolean check(int r, int c, int size) {
        if(r+size>10 || c+size>10) return false;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(a[r+i][c+j] != 1) return false;
            }
        }
        return true;
    }
    public static void fill(int r, int c, int size, int state) {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                a[r+i][c+j] = state;
            }
        }
    }
}
