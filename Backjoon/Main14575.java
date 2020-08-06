package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14575 {

	/*
	 * [백준] 뒤풀이
	 * 
	 * 1. 가장 작은 값 S를 구해라
	 * 
	 * 2. 
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int S = 0;
		
		while(S<=1000000) {
			int summin = 0;
			int summax = 0;
			boolean flag = true;
			
			for (int i = 0; i < N; i++) {
				if (arr[i][0] <= S) {
					if (S >= arr[i][1]) {
						summax += arr[i][1];
						summin += arr[i][0];
					} else {
						summax += S;
						summin += arr[i][0] <= S? arr[i][0] : S;
					}
				} else {
					flag = false;
					break;
				}
			}
			
			if(flag && summax>= T && summin <= T) break;
			
			S++;
		}
		
		if(S>1000000)System.out.println(-1);
		else System.out.println(S);
	}
}
