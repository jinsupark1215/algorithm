package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17086 {

	/*
	 * [백준] 아기상어2
	 * 
	 * 1. 안전거리 최대치 구하기
	 * 
	 * 2. N,M <= 50
	 * 
	 * 3. bfs
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<>();
		boolean[][] map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
					q.add(new int[] {i,j});
				}
			}
		}
		
		int ans = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				
				for (int j = 0; j < 8; j++) {
					int nr = cur[0] + pos[j][0];
					int nc = cur[1] + pos[j][1];
					if(nr>=0 && nr< N && nc>=0 && nc < M && !map[nr][nc]) {
						map[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
			ans++;
		}
		
		System.out.println(ans-1);
		}
}
