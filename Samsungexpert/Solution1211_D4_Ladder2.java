package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class Solution1211_D4_Ladder2 {

	/*
	 * 1. 누가 걸릴지 찾아라
	 * 
	 * 2.복수 개인 경우 큰 x좌표
	 * 
	 * 3. 답이 2부터 꺼꾸로 올라가 답 찾기
	 */
	
	static int[][] pos = {{0,1},{0,-1},{-1,0}};
	static int ans, cntmax;
	static int[][] map;
	static ArrayList<Point> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase <= 10; testcase++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			ans = 0;
			cntmax = Integer.MAX_VALUE;
			arr = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 100; i++) {
				if(map[99][i] == 1)dfs(99,i,0, 0);
			}
			
			for (int i = 0; i < arr.size(); i++) {
				if(arr.get(i).cnt == cntmax) {
					ans = Math.max(ans, arr.get(i).c);
				}
			}
			System.out.println("#" + testcase + " " + ans);
		}
	}
	private static void dfs(int r, int c, int dir, int cnt) {
		if(r == 0) {
			if(cntmax >= cnt) {
				cntmax = cnt;
				arr.add(new Point(cnt,c));
			}
			return;
		}
		
		if(dir == 2) {
			for (int i = 0; i < 3; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nc>=0 && nr < 100 && nc < 100 && map[nr][nc] == 1) {
				dfs(nr,nc,i,cnt+1);
				break;
			}
			}
		}else if(dir == 0) {
			int nr = r + pos[2][0];
			int nc = c + pos[2][1];
			if(nr>=0 && nc>=0 && nr < 100 && nc < 100 ) {
				if(map[nr][nc] == 1)dfs(nr,nc,2,cnt+1);
				else dfs(r+pos[0][0], c + pos[0][1], 0,cnt+1);
			}
		}else if(dir == 1) {
			int nr = r + pos[2][0];
			int nc = c + pos[2][1];
			if(nr>=0 && nc>=0 && nr < 100 && nc < 100 ) {
				if(map[nr][nc] == 1)dfs(nr,nc,2,cnt+1);
				else dfs(r+pos[1][0], c + pos[1][1], 1,cnt+1);
			}
		}
	}
	static class Point{
		int cnt, c;

		public Point(int cnt, int c) {
			super();
			this.cnt = cnt;
			this.c = c;
		}

	}
}
