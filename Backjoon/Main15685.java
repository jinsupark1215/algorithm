package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15685 {

	/*
	 * [백준] 드래곤커브
	 * 
	 * 1. 정사각형을 이루는 드래곤커브갯수
	 * 
	 * 2. x,y <= 100, g <=10
	 * 
	 * 3. 드래곤 커브의 점 찍고 판단
	 */
	static int N, ans;
	static boolean[][] map;
	static int[][] pos = {{0,1},{-1,0},{0,-1},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		ans= 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			list.add(dir);
			
			for (int j = 0; j < g; j++) {
				for (int s = list.size()-1; s >=0; s--) {
					int nd = (list.get(s) +1)%4;
					list.add(nd);
				}
			}
			map[r][c] = true;
			for (int j = 0; j < list.size(); j++) {
				r += pos[list.get(j)][0];
				c += pos[list.get(j)][1];
				map[r][c] = true;
			}
			list.clear();
		}
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])ans++;
			}
		}
		System.out.println(ans);
	}
}
