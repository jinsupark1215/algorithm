package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2105 {

	/*
	 * 1. 최대한 많은 종류의 디저트를 먹는 경우
	 * 
	 * 2. 4<= N <=20, 디저트 종류 100개이하
	 * 
	 * 3. dfs,
	 * 3-1 먹을 수 있는지?(먹었던 것인지 판단)
	 * 3-2 시작한 곳의 위치가 같은지와 방향이 오른쪽 대각선이 맞는지 판단
	 */
	static int N, ans, sr, sc;
	static int[][] map;
	static boolean[] chk;
	static int[][] pos = {{1,1},{1,-1},{-1,-1},{-1,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					chk = new boolean[101];
					sr = i; sc = j;
					dfs(i,j,1,0);
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void dfs(int r, int c, int cnt,int dir) {
		//종료조건
		if(sr == r && sc == c && dir ==3) {
			ans = Math.max(ans, cnt-1);
		}
		
		//방향 3이 마지막
		if(dir > 3)return;
		//이미 먹은 디저트면 리턴
		if(chk[map[r][c]]) return;
		//안먹은 디저트면 먹기
		chk[map[r][c]] = true;
		

			int nr = r + pos[dir][0];
			int nc = c + pos[dir][1];
			if(nr>= 0 && nr < N && nc >=0 && nc <N) {
				//문제 없으면 갈 수 있는 방향 다 진행
				dfs(nr,nc,cnt+1,dir);
				dfs(nr, nc, cnt+1, dir+1);
			}
			
			
		chk[map[r][c]] = false;
		return;
	}
}

