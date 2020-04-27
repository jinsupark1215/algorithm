package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2980 {

	/*
	 * [백준] 도로와 신호등
	 * 
	 * 1. 끝까지 이동하는데 걸리는 시간
	 * 
	 * 2. N<=100, L <=1000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] stop = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stop[i][0] = Integer.parseInt(st.nextToken());
			stop[i][1] = Integer.parseInt(st.nextToken());
			stop[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int idx = 0;
		while(idx != L) {
			
			boolean flag = true;
			
			for (int i = 0; i < stop.length; i++) {
				if(stop[i][0] == idx) {
					if(ans%(stop[i][1]+stop[i][2]) < stop[i][1]) {
						flag = false;
						ans++;
					}
				}
			}
			
			if(flag) {
				ans++;
				idx++;
			}
		}
		System.out.println(ans);
	}
}
