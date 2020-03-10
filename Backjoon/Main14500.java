package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500 {

	/*
	 * 1. 종이 위에 테트로미노 하나를 올렸을 때 최고 합의 값
	 * 
	 * 2. N,M <= 500, O(n*n)
	 * 
	 * 3. dfs 완전탐색
	 * 3-1 1,2,3,4 는 한번에 구현
	 * 3-2 'ㅗ'은 예외 
	 */
	static int N,M,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i,j,0,0);
				go(i,j,map[i][j]);
			}
		}
		System.out.println(ans);
	}

	//'ㅗ'
	//+에서 하나 빼주기
	private static void go(int r, int c, int sum) {
		int cnt = 1;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nr < N && nc >=0 && nc < M) {
				cnt++;
				sum+= map[nr][nc];
				min = Math.min(min, map[nr][nc]);
			}
		}
		
		if(cnt == 4) {
			ans  = Math.max(ans, sum);
		}else if(cnt==5) {
			ans = Math.max(ans, sum-min);
		}
		
	}

	//1,2,3,4 해결
	private static void dfs(int r, int c, int idx, int sum) {
		if(idx == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nr < N && nc >=0 && nc < M && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr,nc,idx+1,sum+map[nr][nc]);
				visit[nr][nc] = false;
			}
		}
	}
}

