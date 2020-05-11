package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17070 {

	/*
	 * [백준] 파이프 옮기기 1
	 * 
	 * 1. 오른쪽 끝에 도달할 수 있는 방법의 갯수
	 * 
	 * 2. N <=16
	 * 
	 * 3. dfs 구현 
	 */
	static int N, ans;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//0은 가로, 1은 세로,2는 대각선
		dfs(0,1,0);
		
		System.out.println(ans);
	}
	private static void dfs(int r, int c, int dir) {
		if(r == N-1 && c == N-1) {
			ans++;
			return;
		}
		
		if(dir ==0) {
			//가로
			if(c+1 < N && map[r][c+1] ==0) {
				dfs(r,c+1,0);
			}
			//대각선
			if(r+1 < N &&c+1 < N && map[r+1][c+1] ==0 && map[r+1][c]==0 && map[r][c+1]==0) {
				dfs(r+1,c+1,2);
			}
		}else if(dir == 1) {
			//세로
			if(r+1 < N && map[r+1][c] ==0) {
				dfs(r+1,c,1);
			}
			//대각선
			if(r+1 < N &&c+1 < N && map[r+1][c+1] ==0 && map[r+1][c]==0 && map[r][c+1]==0 ) {
				dfs(r+1,c+1,2);
			}
		}else if(dir == 2) {
			//가로
			if(c+1 < N && map[r][c+1] ==0) {
				dfs(r,c+1,0);
			}
			//세로
			if(r+1 < N && map[r+1][c] ==0) {
				dfs(r+1,c,1);
			}
			//대각선
			if(r+1 < N &&c+1 < N && map[r+1][c+1] ==0 && map[r+1][c]==0 && map[r][c+1]==0) {
				dfs(r+1,c+1,2);
			}
		}
	}
}
