package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1249 {

	/*
	 * [삼성] 보급로
	 * 
	 * 1. 최소의 시간으로 목적지에 도달하는 복구경로
	 * 
	 * 2. N <= 100
	 * 
	 * 3. 메모이제이션 활용
	 */
	
	static int N;
	static int[][] map, dis;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) -'0';
				}
			}
			dis = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			dis[0][0] = map[0][0];
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {0,0});
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();

				int nr = 0, nc =0;
				for (int i = 0; i < 4; i++) {
					nr = cur[0] + pos[i][0];
					nc = cur[1] + pos[i][1];
					if(nr>=0 && nc >=0 && nc < N && nr < N	&& dis[nr][nc] > dis[cur[0]][cur[1]]+map[nr][nc]) {
						dis[nr][nc] = dis[cur[0]][cur[1]]+map[nr][nc];
						q.add(new int[] {nr,nc});
					}
				}
			}
			System.out.println("#" + tc + " "+ dis[N-1][N-1]);
		}
	}
}
