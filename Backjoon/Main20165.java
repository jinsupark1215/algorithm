package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main20165 {

	/*
	 * [백준] 인내의 도미노 장인 호석
	 * 
	 * 1. 공격수의 점수와 최종상태출력
	 * 
	 * 2. R<=10000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int ans = 0;
		int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int test = 0; test < R; test++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			char chk = st.nextToken().charAt(0);
			int dir = 0;
			if(chk == 'E')dir = 2;
			else if(chk =='W')dir = 3;
			else if(chk == 'S')dir = 0;
			else dir = 1;
			
			//공격
			ans++;
			q.add(new int[] {X-1,Y-1});
			visit[X-1][Y-1] = true;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for (int i = 0; i < 4; i++) {
					for (int j = 1; j < map[cur[0]][cur[1]]; j++) {
						int nr = cur[0] + (pos[dir][0]*j);
						int nc = cur[1] + (pos[dir][1]*j);
						if(nr>=0 && nr < N && nc>=0 && nc<M && !visit[nr][nc]) {
							visit[nr][nc] = true;
							ans++;
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
			
			//수비
			st = new StringTokenizer(br.readLine());
			int tmpX = Integer.parseInt(st.nextToken())-1;
			int tmpY = Integer.parseInt(st.nextToken())-1;
			visit[tmpX][tmpY] = false;
		}
		
		System.out.println(ans);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j])System.out.print("F" + " ");
				else System.out.print("S" + " ");
			}
			System.out.println();
		}
	}
}
