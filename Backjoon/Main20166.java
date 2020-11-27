package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main20166 {

	/*
	 * [백준] 문자열 지옥에 빠진 호석
	 * 
	 * 1. 만들수 있는 문자열 몇개인가
	 * 
	 * 2. N,M <=10, 문자열 길이 5
	 * 
	 * 3. 
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> chk = new HashMap<>();
		Queue<Point> q = new LinkedList<>();
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				q.add(new Point(i,j,""+map[i][j]));
				if(!chk.containsKey(String.valueOf(map[i][j])))chk.put(String.valueOf(map[i][j]), 1);
				else chk.replace(String.valueOf(map[i][j]), chk.get(String.valueOf(map[i][j]))+1);
			}
		}
		
		for (int test = 0; test < 4; test++) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int j = 0; j < 8; j++) {
					int nr = p.r + pos[j][0];
					int nc = p.c + pos[j][1];
					if(nr == -1)nr = N-1;
					if(nr == N)nr = 0;
					if(nc == -1)nc = M-1;
					if(nc == M)nc = 0;
					
					if(!chk.containsKey(p.sb+map[nr][nc]))chk.put(p.sb+map[nr][nc], 1);
					else chk.replace(p.sb+map[nr][nc], chk.get(p.sb+map[nr][nc])+1);
					
					q.add(new Point(nr,nc,p.sb+map[nr][nc]));
				}
			}
		}
		
		for (int i = 0; i < K; i++) {
			String tmp = br.readLine();
			System.out.println(chk.get(tmp) ==null? 0 : chk.get(tmp));
		}
		
	}
	static class Point{
		int r,c;
		String sb;
		public Point(int r, int c, String sb) {
			super();
			this.r = r;
			this.c = c;
			this.sb = sb;
		}
	}
}
