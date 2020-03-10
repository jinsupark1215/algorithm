package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16987 {

	/*
	 * 1. 계란을 쳤을 때 꺠지는 최대 갯수
	 * 
	 * 2. N <=8
	 * 
	 * 3. 백트래킹 완탐
	 */
	static int N, ans;
	static int[][] egg;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg = new int[N][2];
		ans = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}


		dfs(0);

		System.out.println(ans);
	}

	private static void dfs(int idx) {
		//총 갯수 세기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(egg[i][0] <= 0)cnt++;
		}
		ans = Math.max(ans, cnt);
		//맨 오른쪽이면 끝
		if (idx == N) {
			return;
		}

		//백트레킹
		if(egg[idx][0] > 0) {
			for (int i = 0; i < N; i++) {
				if(i != idx && egg[i][0] > 0) {
					egg[idx][0] -= egg[i][1];
					egg[i][0] -= egg[idx][1];
					dfs(idx+1);
					egg[idx][0] += egg[i][1];
					egg[i][0] += egg[idx][1];
				}
			}
		}else dfs(idx+1);
	}
}

