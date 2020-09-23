package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2665 {
	/*
	 * [백준] 미로만들기
	 * 1. 검은방 몇개를 뚫고 도달할 수 있는지
	 * 
	 * 2. 
	 * 
	 * 3. bfs 돌면서 검은방 최소 체크
	 */
	static Queue<Point> q;
	static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map, visit;
	static int N; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		q = new LinkedList<>();
		visit = new int[N][N];
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; ++i) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0 ; j < N ; ++j) {
				map[i][j] = input[j] - '0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}

		
		q.add(new Point(0, 0));
		visit[0][0] = 0;
		
		bfs();
		
		System.out.println(visit[N - 1][N - 1]);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();

			for(int i = 0 ; i < 4 ; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;
				
				// 검은 방
				if(map[nr][nc] == 0) {
					if(visit[nr][nc] > visit[p.r][p.c] + 1) {
						visit[nr][nc] = visit[p.r][p.c] + 1;
						q.offer(new Point(nr, nc));
					}
				} else {
					if(visit[nr][nc] > visit[p.r][p.c]) {
						visit[nr][nc] = visit[p.r][p.c];
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
	}
	static class Point{
		int r, c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
