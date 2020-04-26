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
	 * 3. 방향의 끝에서 인것들을 타고들어가보기
	 */
	static int N,M,ans;
	static char[][] map;
	static boolean[][] visit;
	static int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		//왼쪽
		for (int i = 0; i < N; i++) {
			if(map[i][0] == 'L')go(i,0);
		}
		//오쪽
		for (int i = 0; i < N; i++) {
			if(map[i][M-1] == 'R')go(i,M-1);
		}
		//위쪽
		for (int i = 0; i < M; i++) {
			if(map[0][i] == 'U')go(0,i);
		}
		//아래쪽
		for (int i = 0; i < M; i++) {
			if(map[N-1][i] == 'D')go(N-1,i);
		}
		
		System.out.println(ans);
	}
	private static void go(int r, int c) {
		ans++;
		visit[r][c] = true;
		
		if(r-1>=0 && map[r-1][c] == 'D' && !visit[r-1][c]) {
			go(r-1,c);
		}
		if(r+1 < N && map[r+1][c] == 'U' && !visit[r+1][c]) {
			go(r+1,c);
		}
		if(c-1 >=0 && map[r][c-1] == 'R' && !visit[r][c-1]) {
			go(r,c-1);
		}
		if(c+1 <M && map[r][c+1] == 'L' && !visit[r][c+1]) {
			go(r,c+1);
		}
		
		
	}
}
