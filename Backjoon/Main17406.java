package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17406 {

	/*
	 * 1. 회전 연산을 하고 배열 A값의 최소값을 구하라.
	 * 
	 * 2. 3<=n,m<=50, k<=6, (1,1)부터 시작
	 * 
	 * 3. 
	 * 3-1. 조합을 통해 순서를 짜는 함수
	 * 3-2. 조합한 순서대로 배열 돌리기
	 * 3-3. 최종배열에서 최소값 구하기.
	 */
	static int ans , n, m, k;
	static int[][] map;
	static int[][] chk;
	static int[] order;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		chk = new int[k][3];
		order = new int[k];
		visit = new boolean[k];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			chk[i][0] = Integer.parseInt(st.nextToken());
			chk[i][1] = Integer.parseInt(st.nextToken());
			chk[i][2] = Integer.parseInt(st.nextToken());
		}
		
		nCr(0);
		
		System.out.println(ans);
	}
	private static void nCr(int idx) {
		if(idx == k) {
			rotate(0,map);
			return;
		}
		
		for (int i = 0; i < k; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[i] = idx;
				nCr(idx+1);
				visit[i] = false;
			}
		}
	}
	private static void rotate(int cnt, int[][] map2) {
		if(cnt == k) {
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum += map2[i][j];
				}
				ans = Math.min(ans, sum);
			}
			return;
		}
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][j] = map2[i][j];
			}
		}
		
		int nr = chk[order[cnt]][0]-1;
		int nc = chk[order[cnt]][1]-1;
		int tmpcnt = chk[order[cnt]][2];
		for (int i = 1; i <= tmpcnt; i++) {
			
			//위쪽 돌리기
			int num = tmp[nr-i][nc+i];
			for (int j = nc+i; j > nc-i; j--) {
				tmp[nr-i][j] = tmp[nr-i][j-1];
			}
			//왼쪽
			for (int j = nr-i; j < nr+i; j++) {
				tmp[j][nc-i] = tmp[j+1][nc-i];
			}
			//아래
			for (int j = nc-i; j < nc+i; j++) {
				tmp[nr+i][j] = tmp[nr+i][j+1];
			}
			//오른쪽
			for (int j = nr+i; j > nr-i; j--) {
				tmp[j][nc+i] = tmp[j-1][nc+i];
			}
			tmp[nr-i+1][nc+i] = num;
		}
		rotate(cnt+1,tmp);
	}
}
