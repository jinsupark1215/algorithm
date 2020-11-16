package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1743 {

	/*
	 * [백준] 음식물 피하기
	 * 
	 * 1. 가장 큰 음식물 크기
	 * 
	 * 2. N,M <100, K <10000
	 * 
	 * 3. BFS
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		Queue<int[]> q = new LinkedList<>();
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					q.add(new int[] {i,j});
					int cnt = 1;
					visit[i][j] = true;
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						
						for (int l = 0; l < 4; l++) {
							int nr = cur[0] + pos[l][0];
							int nc = cur[1] + pos[l][1];
							if(nr>=0 && nr< N && nc>=0 && nc< M && !visit[nr][nc] && map[nr][nc] ==1) {
								visit[nr][nc] = true;
								cnt++;
								q.add(new int[] {nr,nc});
							}
						}
					}
					ans = Math.max(ans, cnt);
				}
			}
		}
	
		System.out.println(ans);
	}
}
