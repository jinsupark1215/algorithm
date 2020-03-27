package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution7699 {

	/*
	 * [삼성] D4 수지의 수지 맞는 여행
	 * 1. 중복되지않고 볼수 있는 최대갯수
	 * 
	 * 2. R, C <= 20
	 * 
	 * 3. 각섬마다 dfs
	 */
	static int R,C,ans;
	static char[][] map;
	static Map<Character, Boolean> m;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			ans = 0;
			
			for (int i = 0; i < R; i++) {
				String input = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			
			
					m = new HashMap<>();
					dfs(0,0,1);
				
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int r, int c, int cnt) {
			ans = Math.max(ans, cnt);
			m.put(map[r][c], true);
			
			for (int i = 0; i < 4; i++) {
				int nr = r + pos[i][0];
				int nc = c + pos[i][1];
				if(nr>=0 && nr < R && nc >=0 && nc < C && !m.containsKey(map[nr][nc])) {
					dfs(nr,nc,cnt+1);
					m.remove(map[nr][nc]);
				}
			}		
	}
}
