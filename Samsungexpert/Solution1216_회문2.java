package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1216_회문2 {

	/*
	 * 1. 회문을 찾았을 때 가장 긴 길이의 회문 길이찾기
	 * 
	 * 2. 가로세로 직선 회문일 때, 최대길이 
	 * 
	 * 3. dfs 로 체크 후 가장 긴 회문 길이찾기
	 */
	static int N, ans;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase <= 10; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			ans = 0;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 4; k++) {
						sb = new StringBuilder();
						dfs(i, j, k);
					}
				}
			}
			System.out.println("#" + testcase + " " + ans);
		}
	}
	private static void dfs(int r, int c, int dir) {
		sb.append(map[r][c]);
			String sb1 = sb.toString();
			String sb2 = sb.reverse().toString();
			
			if(sb1.equals(sb2)) {
				ans = Math.max(ans, sb.length());
			}
			sb.reverse();
		int nr = r + pos[dir][0];
		int nc = c + pos[dir][1];
		if(nr >=0 && nc>=0 && nr<100 && nc <100) {
			dfs(nr,nc,dir);
		}
	}
}
