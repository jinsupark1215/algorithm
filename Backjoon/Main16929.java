package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16929 {

	/*
	 * [백준] Two dots
	 * 
	 * 1. 사이클이 존재하는지?
	 * 
	 * 2. N,M <=50
	 * 
	 * 3. visit 으로 시작점 잡고 돌아올수 있는지 체크
	 */
	static int N , M;
	static boolean flag;
	static int[][] map;
	static int[][] visit;
	static int[][] pos = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		flag = false;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - 'A';
			}
		}
		
		fin:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!flag) {
					dfs(i,j,i,j,1);
				}else break fin;
			}
		}
		
		if(flag)System.out.println("Yes");
		else System.out.println("No");
	}

	private static void dfs(int r, int c,int startr, int startc, int cnt) {
		
		visit[r][c] = cnt;
		
		if(!flag) {
		for (int i = 0; i < 4; i++) {
			if((cnt==2 && i==2)) continue;
			
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nc>=0 && nr < N && nc < M && map[nr][nc] == map[startr][startc]) {
				if(visit[nr][nc]== 0) {
					dfs(nr,nc,startr,startc, cnt+1);
				}else if(cnt !=2 &&visit[nr][nc] == 1){
					flag = true;
				}
			}
		}
		}
		visit[r][c] = 0;
	}

}
