package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17090 {

	/*
	 * [백준] 미로탈출하기
	 * 
	 * 1. 탈출 가능한 칸의 수
	 * 
	 * 2. N,M <= 500
	 * 
	 * 3. 구현
	 */
	static int N,M,ans;
	static int[][] map;
	static int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = N*M;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char tmp = input.charAt(j);
				if(tmp == 'U')map[i][j] = 0;
				else if(tmp == 'R')map[i][j] = 1;
				else if(tmp == 'D')map[i][j] = 2;
				else if(tmp == 'L')map[i][j] = 3;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				go(i,j,0);
			}
		}
		
		System.out.println(ans);
	}
	private static void go(int r, int c, int cnt) {
		if(cnt == N*M) {
			ans--;
		}else {
			int nr = r + pos[map[r][c]][0];
			int nc = c + pos[map[r][c]][1];
			if(nr>=0 && nr< N && nc>=0 && nc<M) {
				go(nr,nc,cnt+1);
			}
		}
		
	}
}
