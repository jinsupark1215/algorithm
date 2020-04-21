package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8911 {

	/*
	 * [백준] 거북이
	 * 
	 * 1. 다 포함하는 가장 작은 직사각형
	 * 
	 * 2. 명령어 길이 <= 500
	 * 
	 * 3. 구현 후 최대 r, c 최소 r,c 구해서 넓이
	 */
	static int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
	static int maxr,maxc,minr,minc;
	static String input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			input = br.readLine();
			maxr =0;maxc =0;minr=0;minc=0;
			
			dfs(0,0,0,0);
			
			System.out.println((maxr-minr)*(maxc-minc));
		}
	}

	private static void dfs(int r, int c, int dir, int idx) {
		maxr = maxr<r?r:maxr;
		maxc = maxc<c?c:maxc;
		minr = minr>r?r:minr;
		minc = minc>c?c:minc;
		
		if(idx == input.length()) {
			return;
		}else {
			char a = input.charAt(idx);
			
			if(a == 'F') {
				dfs(r+pos[dir][0], c+pos[dir][1],dir,idx+1);
			}else if(a == 'B') {
				dfs(r-pos[dir][0], c-pos[dir][1],dir,idx+1);
			}else if(a == 'L') {
				if(dir ==0) dir =4; 
				dfs(r, c,dir-1,idx+1);
			}else if(a == 'R') {
				dfs(r, c,(dir+1)%4,idx+1);
			}
		}
	}
}
