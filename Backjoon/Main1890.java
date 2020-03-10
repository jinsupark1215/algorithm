package Backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1890 {

	/*
	 * 1. 오른쪽 끝에 도착하는 갯수
	 * 
	 * 2. N<=100
	 * 
	 * 3. bfs로 도착
	 */
	static int[][] pos = { { 1, 0 }, { 0, 1 } };
	static int N;
	static int[][] map;
	static long[][] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		ans = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		ans[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == N-1 && j == N-1)continue;
				if(i + map[i][j] < N) {
					ans[i+map[i][j]][j] += ans[i][j];
				}
				if(j + map[i][j] < N) {
					ans[i][j+map[i][j]]+= ans[i][j];
				}
			}
		}

//		dfs(0,0);

		System.out.println(ans[N-1][N-1]);
	}

	private static void dfs(int r, int c) {
		if(r == N-1 && c == N-1) {
			return;
		}
		
		for (int i = 0; i < pos.length; i++) {
			int nr = r + pos[i][0] * map[r][c];
			int nc = c + pos[i][1] * map[r][c];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				dfs(nr,nc);
			}
		}
	}
}

