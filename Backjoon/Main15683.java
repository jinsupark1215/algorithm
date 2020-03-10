package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15683{

	/*
	 * 1. 사각지대의 최소크기
	 * 
	 * 2. 0 빈칸, 6 벽, 1~5 CCTV
	 * 
	 * 3. 
	 * 3-1. 갈 수 있는 방향 조합
	 * 3-2. dfs로 갈 수 있는 곳 7표시
	 * 3-3. 0갯수
	 */
	static int N,M, cnt, ans;
    static Point[] cctv = new Point[8];
    static int[][] dir = {
        {},
        {1},
        {1,3},
        {0,1},
        {0,1,3},
        {0,1,2,3}
    };
    static int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        
        int[][] map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv[cnt++] = new Point(map[i][j], i, j);
                }
            }
        }
        
        solve(0, map);
        System.out.println(ans);
    }
    
    static void solve(int idx, int[][] arr) {
        if(idx == cnt) {
            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 0)
                        res++;
                }
            }
            ans = Math.min(ans, res);
            return ;
        }
        Point p = cctv[idx];
        
        // 왼쪽으로 4번 돌린다.
        for (int d = 0; d < 4; d++) {
            int[][] map = copy(arr);
            
            // 해당 CCTV가 감시하는 모든 방향에 대해 체크 한다.
            // 1,2,3,4  방향이 될 수 있다.
            for (int i = 0; i < dir[p.num].length; i++) {
                int nd = (dir[p.num][i]-d + 3) % 4;
                int nr = p.r;
                int nc = p.c;
                
                while(true) {
                    nr += pos[nd][0];
                    nc += pos[nd][1];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 6) break;
                    map[nr][nc] = 7;
                }
            }
            solve(idx+1, map);
        }
    }
    
    
    static int[][] copy(int[][] arr) {
        int[][] map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = arr[i][j];
            }
        }
        return map;
    }
}
 
class Point {
    int num, r, c;

	public Point(int num, int r, int c) {
		super();
		this.num = num;
		this.r = r;
		this.c = c;
	}
    
}

