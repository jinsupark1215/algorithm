package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3987 {

	/*
	 * [백준] 보이저 1호
	 * 
	 * 1. 가장 멀리 갈수 있는 방법
	 * 
	 * 2. N,M <= 500
	 * 
	 * 3. 구현
	 */
	static int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N,M;
	static char[][] map;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		ans = new int[4];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int pr = Integer.parseInt(st.nextToken())-1;
		int pc = Integer.parseInt(st.nextToken())-1;
		
		for (int i = 0; i < 4; i++) {
			dfs(pr,pc,i,1,i);
		}
		
		int idx=0, cnt = 0;
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			if(ans[i] == 0) {
				flag = true;
				idx = i;cnt = ans[i];
				break;
			}else {
				if(cnt < ans[i]) {
					idx = i;
					cnt = ans[i];
				}
			}
		}
		if(!flag) {
			if(idx ==0) {
				System.out.println('U');
				System.out.println(cnt);
			}else if(idx ==1) {
				System.out.println('R');
				System.out.println(cnt);
			}else if(idx ==2) {
				System.out.println('D');
				System.out.println(cnt);
			}else if(idx ==3) {
				System.out.println('L');
				System.out.println(cnt);
			}
		}else {
			if(idx == 0)System.out.println('U');
			else if(idx == 1)System.out.println('R');
			else if(idx == 2)System.out.println('D');
			else if(idx == 3)System.out.println('L');
			System.out.println("Voyager");
		}
	}

	private static void dfs(int r, int c, int dir, int dist, int start) {
		if(dist == N*M) {
			ans[start] = 0;
		}else {
			int nr = r + pos[dir][0];
			int nc = c + pos[dir][1];
			if(nr>=0 && nr < N && nc >=0 && nc < M) {
				if(map[nr][nc] == '/') {
					if(dir ==0)dir = 1;
					else if(dir ==1)dir = 0;
					else if(dir ==2)dir = 3;
					else if(dir ==3)dir = 2;
					dfs(nr,nc,dir,dist+1,start);
				}else if(map[nr][nc] == 'C') {
					ans[start] = dist;
				}else if(map[nr][nc] == '.') {
					dfs(nr,nc,dir,dist+1,start);
				}else {
					if(dir ==0)dir = 3;
					else if(dir ==1)dir = 2;
					else if(dir ==2)dir = 1;
					else if(dir ==3)dir = 0;
					dfs(nr,nc,dir,dist+1,start);
				}
			}else {
				ans[start] = dist;
			}
		}
	}
}
