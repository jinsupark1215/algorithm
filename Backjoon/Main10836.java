package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10836 {

	/*
	 * [백준] 여왕벌
	 * 
	 * 1. 마지막 날의 크기를 출려갷라
	 * 
	 * 2. M <= 700, N <=100000
	 * 
	 * 3. 구현
	 */
	static int N,M;
	static int[][] map;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 1;
			}
		}
		
		int[] plus = new int[(M*2)-1];
		for (int i = 0; i < N; i++) {
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			while(tmp !=0) {
				plus[idx++] += 0;
				tmp--;
			}
			tmp = Integer.parseInt(st.nextToken());
			while(tmp !=0) {
				plus[idx++] += 1;
				tmp--;
			}
			tmp = Integer.parseInt(st.nextToken());
			while(tmp !=0) {
				plus[idx++] += 2;
				tmp--;
			}
		}
		
		int idx = 0;
			for (int row = M-1; row >=0; row--) {
				map[row][0] +=plus[idx++];
			}
			
			for (int col = 1; col < M; col++) {
				map[0][col] += plus[idx++];
			}
			
		go(1,1);
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void go(int r, int c) {
		for (int i = r; i < M; i++) {
			int max = 0;
			for (int j = 0; j < 4; j++) {
				int nr = i + pos[j][0];
				int nc = c + pos[j][1];
				if(nr >=0 && nr < M && nc>=0 && nc < M && map[nr][nc]-map[i][c] > max) {
					 max = map[nr][nc]-map[i][c];
				}
			}
			map[i][c] += max;
		}
		
		for (int i = c+1; i < M; i++) {
			int max = 0;
			for (int j = 0; j < 4; j++) {
				int nr = r + pos[j][0];
				int nc = i + pos[j][1];
				if(nr >=0 && nr < M && nc>=0 && nc < M && map[nr][nc]-map[r][i] > max) {
					 max = map[nr][nc]-map[r][i];
				}
			}
			map[r][i] += max;
		}
		if(r != M-1 && c != M-1) {
			go(r+1,c+1);
		}
	}
}
