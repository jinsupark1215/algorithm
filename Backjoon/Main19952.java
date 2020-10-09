package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19952 {

	/*
	 * [백준] 인성 문제있어?
	 * 
	 * 1. 목적지 도찰 할 수 있는지
	 * 
	 * 2. 
	 * 
	 * 3. dfs -> bfs로 바꿔야 속도 빠를것 같음
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean flag;
	static int H,W,O,F,startr,startc,endr,endc;
	static int[][] map;
	static int[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			O= Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
			startr = Integer.parseInt(st.nextToken())-1;
			startc = Integer.parseInt(st.nextToken())-1;
			endr = Integer.parseInt(st.nextToken())-1;
			endc = Integer.parseInt(st.nextToken())-1;
			map = new int[H][W];
			visit = new int[H][W];
			flag= false;
			
			for (int j = 0; j < O; j++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				int height = Integer.parseInt(st.nextToken());
				map[r][c] = height;
			}
			
			dfs(startr,startc,F);
			
			if(flag)System.out.println("잘했어!!");
			else System.out.println("인성 문제있어??");
		}
	}
	private static void dfs(int r, int c, int power) {
		if(r == endr && c == endc) {
			flag = true;
		}
		
		if(!flag) {
		
		if(power >0) {
			for (int i = 0; i < 4; i++) {
				int nr = r + pos[i][0];
				int nc = c + pos[i][1];
				if(nr>=0 && nr< H && nc>=0 && nc < W && visit[nr][nc] < power) {
					visit[nr][nc] = power;
					if(map[r][c] >= map[nr][nc]) {
						dfs(nr,nc,power-1);
					}else {
						if(power >= map[nr][nc]-map[r][c]) {
							dfs(nr,nc,power-1);
						}
					}
				}
			}
		}
		}
	}
}
