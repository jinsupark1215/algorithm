package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18430_무기공학 {

	/*
	 * 1. 부메랑의 합이 최대가 되는 경우
	 * 
	 * 2. N,M <= 5
	 * 
	 * 3. dfs 완전탐색
	 */
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		ans = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);

		System.out.println(ans);
	}

	private static void dfs(int r, int c, int cnt) {
		if (r == N) {
			ans = Math.max(ans, cnt);
			return;
		}

		if (!visit[r][c]) {
			for (int i = 0; i < 4; i++) {
				int nr1 = r + pos[i][0];
				int nc1 = c + pos[i][1];
				int nr2 = r + pos[(i+1)%4][0];
				int nc2 = c + pos[(i+1)%4][1];
				if(isRange(nr1,nc1) && isRange(nr2,nc2)) {
					visit[r][c] = true;
					visit[nr1][nc1] = true;
					visit[nr2][nc2] = true;
					if (c == M - 1) {
						dfs(r + 1, 0, cnt+(map[r][c]*2)+map[nr1][nc1] + map[nr2][nc2]);
					} else {
						dfs(r, c + 1, cnt+(map[r][c]*2)+map[nr1][nc1] + map[nr2][nc2]);
					}
					visit[r][c] = false;
					visit[nr1][nc1] = false;
					visit[nr2][nc2] = false;
				}
			}
		}
		
		if (c == M - 1) {
			dfs(r + 1, 0, cnt);
		} else {
			dfs(r, c + 1, cnt);
		}
	}

	private static boolean isRange(int r, int c) {
		if(r>=0 && r < N && c>=0 && c < M && !visit[r][c])return true;
		return false;
	}
}
