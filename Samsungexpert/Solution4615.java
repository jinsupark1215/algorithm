package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4615 {

	/*
	 * 1. 최종 백돌의 갯수와 흑돌의 갯수.
	 * 
	 * 2. N은 4,6,8
	 * 
	 * 3. 구현
	 */
	static int N, M, white, black;
	static int[][] map;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			map[(N/2)-1][(N/2)-1] = 2;
			map[(N/2)-1][N/2] = 1;
			map[N/2][(N/2)-1] = 1;
			map[N/2][N/2] = 2;
			white = 2;
			black = 2;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int dol = Integer.parseInt(st.nextToken());
				dfs(r-1,c-1,dol);
			}
			System.out.println("#" + tc + " " + black + " " + white);
		}
	}

	private static void dfs(int r, int c, int dol) {
		map[r][c] = dol;
		if(dol == 1)black++;
		else white++;
		
		for (int i = 0; i < 8; i++) {
			int end = 1;
			for (int j = 1; j <= N; j++) {
				int nr = r + pos[i][0] * j;
				int nc = c + pos[i][1] * j;
				if(nr>=0 && nr < N && nc >=0 && nc < N) {
					if(map[nr][nc] != dol && map[nr][nc] != 0) {
						end++;
					}else if(map[nr][nc] == dol && map[nr][nc] != 0){
						break;
					}else {
						end = 0;
						break;
					}
				}else {
					end = 0;
					break;
				}
			}
			
			for (int j = 1; j < end; j++) {
				int nr = r + pos[i][0] * j;
				int nc = c + pos[i][1] * j;
				if(nr>=0 && nr < N && nc >=0 && nc < N) {
					if(map[nr][nc] != dol && map[nr][nc] != 0) {
						map[nr][nc] = dol;
						if(dol == 1) {
							white--;
							black++;
						}else {
							white++;
							black--;
							
						}
					}else if(map[nr][nc] == dol && map[nr][nc] != 0){
						break;
					}
				}
			}
		}
	}
}

