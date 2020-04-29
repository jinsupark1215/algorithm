package Backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16918 {

	/*
	 * [백준] 봄버맨
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1},{0,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		char[][] map = new char[R][C];
		Queue<bomb> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String a = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = a.charAt(j);
				if(map[i][j] =='O') {
					q.add(new bomb(i,j,0));
				}
			}
		}//입력
		if(N == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else {
			for (int second = 2; second <= N; second++) {
				if(second % 2 ==0) {
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							if(map[i][j] == '.') {
								map[i][j] = 'O';
							}
						}
					}
					
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							System.out.print(map[i][j]);
						}
						System.out.println();
					}
				}else {
					while(!q.isEmpty()) {
						bomb b = q.poll();
						for (int i = 0; i < 5; i++) {
							int nr = b.r + pos[i][0];
							int nc = b.c + pos[i][1];
							if(nr>=0 && nc >=0 && nr < R&& nc < C) {
								map[nr][nc] = '.';
							}
						}
					}
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) {
							if(map[i][j]=='O') {
								q.add(new bomb(i,j,0));
							}
						}
					}
				}
			}
			
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
	}
	static class bomb{
		int r, c, time;

		public bomb(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
	}
}