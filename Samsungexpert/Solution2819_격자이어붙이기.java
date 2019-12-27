package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution2819_격자이어붙이기 {

	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map;
	static Set<String> set;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			set = new HashSet<String>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					StringBuilder sb = new StringBuilder();
					sb.append(map[i][j]);
					dfs(i,j,0, sb);
				}
			}
			System.out.println("#" + testcase + " " + set.size());
		}
	}
	private static void dfs(int r, int c, int cnt, StringBuilder sb) {
		if(cnt == 6) {
			set.add(sb.toString());
			sb.delete(sb.length()-1,sb.length());
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nc>=0 && nr< 4 && nc<4) {
				sb.append(map[nr][nc]);
				dfs(nr,nc,cnt+1, sb);
			}
		}
		sb.delete(sb.length()-1, sb.length());
	}
}
