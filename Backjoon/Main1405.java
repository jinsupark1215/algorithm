package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1405 {

	/*
	 * [백준] 미친 로봇
	 * 1. 이동경로가 단순할 확률
	 * 
	 * 2. N <=14
	 * 
	 * 3. dfs
	 */
	static int N;
    static int arr[] ;
    static boolean visit[][]=new boolean[30][30];
    static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
    static double ans;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ans = 0;
        arr = new int[4];
        visit = new boolean[30][30];
        for(int i=0; i<4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit[15][15]=true;
        dfs(15,15,0,1.0);
        System.out.println(String.format("%.10f", ans));
    }
    
    public static void dfs(int r, int c, int cnt, double val) {
        
        if(cnt == N) {
            ans += val;
            return;
        }
        
        
        
        for(int i=0; i<4; i++) {
            int nr = r + pos[i][0];
            int nc = c + pos[i][1];
            if(!visit[nr][nc]) {
                visit[nr][nc]=true;
                dfs(nr, nc, cnt+1, val*0.01*arr[i]);
                visit[nr][nc] = false;
            }
        }
    }
}
