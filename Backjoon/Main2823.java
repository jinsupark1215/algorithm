package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2823 {

	/*
	 * 1. 막다른 길이 있다면 0 없다면 1
	 * 
	 * 2. 3 <= R,C <= 10
	 * 
	 * 3. 길을 봤을 때 주변의 길이 1개이면 막다른 길이 존재.
	 */
	
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		boolean flag = false;
		//갯수 세기
		fin:
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.') {
					int cnt = 0;
					
					for (int k = 0; k < 4; k++) {
						int nr = i + pos[k][0];
						int nc = j + pos[k][1];
						if(nr>=0 && nr < R && nc>=0 && nc < C && map[nr][nc] == '.') {
							cnt++;
						}
					}
					
					if(cnt ==1) {
						flag = true;
						break fin;
					}
				}
			}
		}
		
		if(flag)System.out.println(1);
		else System.out.println(0);
	}
}

