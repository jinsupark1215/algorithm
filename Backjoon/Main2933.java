package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2933 {

	/*
	 * 1. 다 부신 뒤 맵 표시
	 * 
	 * 2. R,C <= 100
	 * 
	 * 3.
	 * 3-1. 먼저 창을 던지고 부시기(왼쪽 오른쪽 부시기)
	 * 3-2. bfs로 1번에 다 체크 되는지 체크
	 * 3-3. 1번에 체크 안되면 맵 내리기
	 */
	static int R, C;
	static ArrayList<Point> list;
	static char[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean flag = false;
		
		for (int i = 0; i < N; i++) {
			int n = R - Integer.parseInt(st.nextToken());
			
			crack(n,flag);	// 부시기
			
			list = new ArrayList<>();
			chk();	//체크
			if(list.size() !=0)down();	//내리기
			
			
			if(flag)flag = false;
			else flag = true;
		}
		
		//출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void down() {// 미완
		int cnt = 0;
		for (Point p : list) {
			map[p.r][p.c] = '.';
		}

		// 현재 떨어질 클러스터가 몇칸이나 내려올 수 있는지 체크한다.
		fin: 
		for (int i = 1; i < R; ++i) {
			for (Point p : list) {
				if (p.r + i >= R || map[p.r + i][p.c] == 'x') {
					break fin;
				}
			}
			cnt = i;
		}

		// 계산된 칸 만큼 이동시킨 클러스터를 새로 그린다.
		for (Point p : list) {
			map[p.r + cnt][p.c] = 'x';
		}
	}
	private static void chk() {
		visit = new boolean[R][C];
		Queue<Point> q = new LinkedList<>();
			for (int j = 0; j < C; j++) {
				if(map[R-1][j] == 'x' && !visit[R-1][j]) {
					visit[R-1][j] = true;
					q.add(new Point(R-1,j));
					while(!q.isEmpty()) {
						Point p = q.poll();
						
						for (int k = 0; k < 4; k++) {
							int nr = p.r + pos[k][0];
							int nc = p.c + pos[k][1];
							if(nr>=0 && nr < R && nc >=0 && nc < C && !visit[nr][nc] && map[nr][nc] == 'x') {
								visit[nr][nc] = true;
								q.add(new Point(nr,nc));
							}
						}
					}
			}
		}
			
			// 방문체크되지 않은 공중에 떠 있는 클러스터를 리스트에 담는다.
			for(int i = 0 ; i < R ; ++i) {
				for(int j = 0 ; j < C ; ++j) {
					if(map[i][j] == 'x' && !visit[i][j]) {
						list.add(new Point(i,j));
					}
				}
			}
		
	}
	private static void crack(int idx, boolean flag) {
		if(!flag) {
			for (int i = 0; i < C; i++) {
				if(map[idx][i] == 'x') {
					map[idx][i] = '.';
					break;
				}
			}
		}else {
			for (int i = C-1; i >=0; i--) {
				if(map[idx][i] == 'x') {
					map[idx][i] = '.';
					break;
				}
			}
		}
		
	}
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}

