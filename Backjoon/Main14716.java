package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main14716 {

	/*
	 * [백준] 현수막
	 * 1. 글자 몇개인지
	 * 
	 * 2. M,N <=250
	 * 
	 * 3. bfs
	 * 
	 */
	static int N, M, answer;
    static int[][] map;
    static int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    static Queue<int[]> q;
    static boolean[][] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input= br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[M][N];
        visit = new boolean[M][N];
        q = new LinkedList<int[]>();
        
        for (int row = 0; row < M; row++) {
            input = br.readLine().split(" ");
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(input[col]);
            }
        }
        // 0, 0부터 탐색 시작
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (!visit[row][col] && map[row][col] == 1) {
                    q.add(new int[]{row, col});
                    bfs();
                }
            }
        }
        
        System.out.println(answer);
        
    }
 
    private static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nr = cur[0] + pos[i][0];
                int nc = cur[1] + pos[i][1];
                
                if (0 <= nr && nr < M && 0 <= nc && nc < N) {
                    if (!visit[nr][nc] && map[nr][nc] == 1) {
                        visit[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            
        } 
        
        answer++;
    }
}
