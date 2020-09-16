package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {

	/*
	 * [백준] 마인크래프트
	 * 1. 평탄화하기 위해 필요한 최소시간
	 * 
	 * 2. M,N <= 500, B <= ~~
	 * 
	 * 3. 평균 구하고 거기에 맞춰서 체크
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		

		int ans1 = Integer.MAX_VALUE, ans2 = 0;
		
		for (int chk = 0; chk <= 256; chk++) {
			int time = 0;
			int cnt = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] - chk >=0) {
						time += (map[i][j] - chk)*2;
						cnt += map[i][j] - chk;
					}else {
						time += chk - map[i][j];
						cnt -= chk - map[i][j];
					}
				}
			}
			if(cnt < 0)continue;
			if(ans1 >= time) {
				ans1 = time;
				ans2 = chk;
			}
		}
		
		
		System.out.println(ans1 + " " + ans2);
	}
}
