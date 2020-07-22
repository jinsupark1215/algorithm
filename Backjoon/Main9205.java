package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9205 {

	/*
	 * [백준] 맥주 마시면서 걸어가기
	 * 1. 상근이와 친구들이 페스티벌에 도착할 수 있는지
	 * 
	 * 2. n <=100
	 * 
	 * 3. 구현
	 */
	static int T, n;
	static Point[] dist;
	static boolean flag;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			flag = false;
			visit = new boolean[n+2];
			
			dist = new Point[n+2];
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				dist[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			visit[0] = true;
			dfs(dist[0].x, dist[0].y,0);
			
			
			if(flag)System.out.println("happy");
			else System.out.println("sad");
		}
	}
	private static void dfs(int x, int y, int num) {
		if(num == n+1) {
			flag = true;
		}else {
			
		for (int i = 1; i < n+2; i++) {
			if(!visit[i] &&(Math.abs(dist[i].x - x) + Math.abs(dist[i].y - y)) <= 1000) {
				visit[i] = true;
				dfs(dist[i].x,dist[i].y, i);
			}
		}
		}
		
	}
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
