package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18128 {

	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
	static int n,w,min;
	static int[][] map;
	static boolean[][] v;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		boolean[][] visit = new boolean[n][n];
		Queue<Water> q = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			q.add(new Water(x,y, 0));
			visit[x][y] = true;
		}
		
		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = a.charAt(j)-'0';
			}
		}
		// ют╥б
		map[n-1][n-1] = 2;
		min = -1;
		flag = false;
		
		while(!q.isEmpty()){
			v= new boolean[n][n];
			go(0,0);
			if(flag) {
				min = q.poll().day;
				break;
			}
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Water water = q.poll();
				if(map[water.r][water.c] == 1)map[water.r][water.c] = 2;
				visit[water.r][water.c] = true;
				
				for (int j = 0; j < 4; j++) {
					int nr = water.r + pos[j][0];
					int nc = water.c + pos[j][1];
					if(nr >=0 && nr<n && nc >=0 &&nc<n && !visit[nr][nc]) {
						if(map[nr][nc] == 1) {
							map[nr][nc] = 2;
							q.add(new Water(nr,nc,water.day+1));
						}else if(map[nr][nc] == 0) {
							q.add(new Water(nr,nc,water.day+1));
						}
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
	private static void go(int r, int c) {
		if(r == n-1 && c == n-1) {
			flag = true;
			return;
		}
		v[r][c] = true;
			for (int j = 0; j < 8; j++) {
				int nr = r + pos[j][0];
				int nc = c + pos[j][1];
				if(nr >=0 && nr<n && nc >=0 &&nc<n && map[nr][nc] == 2 && !v[nr][nc]) {
					go(nr,nc);
				}
			}
		
	}

	static class Water{
		int r, c, day;

		public Water(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}

		
	}
}
