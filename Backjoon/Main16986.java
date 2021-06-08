package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main16986 {

    public static int N;
    public static int K;
    public static int[][] map;
    public static int[] kyung;
    public static int[] min;
    public static boolean[] visit;

    public static void dfs(int n,int j,int jw,int k,int kw,int m,int mw,int p1, int p2) {
        if(jw == K) {
            System.out.println(1);
            System.exit(0);
        }
        if(n == 61 || kw == K || mw == K) {
            return;
        }
        if(p1 == 1 && p2 == 2) {
            for(int i = 0; i < N; i ++) {
                if(!visit[i]) {
                    visit[i] = true;
                    if(map[kyung[k]][i] == 2)
                        dfs(n+1,j+1,jw,k+1,kw+1,m,mw,2,3);
                    else if(map[kyung[k]][i] == 0)
                        dfs(n+1,j+1,jw+1,k+1,kw,m,mw,1,3);
                    else
                        dfs(n+1,j+1,jw,k+1,kw+1,m,mw,2,3);
                    visit[i] = false;
                }
            }
        } else if(p1 ==2 && p2 == 3){
            if(map[kyung[k]][min[m]] == 2)
                dfs(n+1,j,jw,k+1,kw+1,m+1,mw,1,2);
            else if(map[kyung[k]][min[m]] == 0)
                dfs(n+1,j,jw,k+1,kw,m+1,mw+1,1,3);
            else
                dfs(n+1,j,jw,k+1,kw,m+1,mw+1,1,3);
        } else {
            for(int i = 0; i < N; i ++) {
                if(!visit[i]) {
                    visit[i] = true;
                    if(map[min[m]][i] == 2)
                        dfs(n+1,j+1,jw,k,kw,m+1,mw+1,2,3);
                    else if(map[min[m]][i] == 0)
                        dfs(n+1,j+1,jw+1,k,kw,m+1,mw,1,2);
                    else
                        dfs(n+1,j+1,jw,k,kw,m+1,mw+1,2,3);
                    visit[i] = false;
                }
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0 ;i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        kyung = new int[20];
        min = new int[20];
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < N;j++) {
            kyung[j] = Integer.parseInt(st.nextToken())-1;
        }
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < N;j++) {
            min[j] = Integer.parseInt(st.nextToken())-1;
        }
        if(N < K) {
            System.out.println(0);
        } else {
            visit = new boolean[N];
            dfs(1,0,0,0,0,0,0,1,2);
            System.out.println(0);
        }
    }
}
