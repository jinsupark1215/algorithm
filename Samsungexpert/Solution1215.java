package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1215 {

	/*
	 * 1. 직선거리의 5개를 선택했을 때 회문이 되는 갯수찾기
	 * 
	 * 2. 가로세로 직선 회문일 때
	 * 
	 * 3. dfs 로 5글자가 되는 경우 체크 후 갯수세기
	 */
	static int N, ans;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase <= 10; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String input = br.readLine();
				for (int j = 0; j < 8; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			ans = 0;
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					for (int k = 0; k < 4; k++) {
						sb = new StringBuilder();
						dfs(i, j, k, 0);
					}
				}
			}
			if(ans%2 == 0) {
				ans /=2;				
			}else {
				ans = (ans/2)+1;
			}
			System.out.println("#" + testcase + " " + ans);
		}
	}
	private static void dfs(int r, int c, int dir, int cnt) {
		sb.append(map[r][c]);
		if(cnt == N-1) {
			String sb1 = sb.toString();
			String sb2 = sb.reverse().toString();
			
			if(sb1.equals(sb2))ans++;
				return;
		}
		int nr = r + pos[dir][0];
		int nc = c + pos[dir][1];
		if(nr >=0 && nc>=0 && nr<8 && nc <8) {
			dfs(nr,nc,dir,cnt+1);
//			sb.delete(sb.length()-1, sb.length());
		}
	}
}

