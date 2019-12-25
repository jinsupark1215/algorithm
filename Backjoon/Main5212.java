package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main5212 {

	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static int startr,startc,endr,endc;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		startr =Integer.MAX_VALUE;startc =Integer.MAX_VALUE; endr=0;endc=0;

		for (int i = 0; i < r; i++) {
			String a = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = a.charAt(j);
			}
		}
		ArrayList<Point> arr = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 'X') {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i + pos[k][0];
						int nc = j + pos[k][1];
						if(nr>=0 && nc>=0 && nr< r && nc < c && map[nr][nc] == '.') {
							cnt++;
						}else if(nr<0 || nc<0 || nr>=r || nc>=c) {
							cnt++;
						}
					}
					if(cnt>2) {
						arr.add(new Point(i,j));
					}
				}
			}
		}
		
		for (int i = 0; i < arr.size(); i++) {
			map[arr.get(i).r][arr.get(i).c] = '.';
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 'X') {
					startr = Math.min(startr, i);
					startc = Math.min(startc, j);
					endr = Math.max(endr, i);
					endc = Math.max(endc, j);
				}
			}
		}
		
		for (int i = startr; i <= endr; i++) {
			for (int j = startc; j <= endc; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
