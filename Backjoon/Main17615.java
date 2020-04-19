package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17615 {

	/*
	 * [백준] 볼 모으기
	 * 
	 * 1. 최소 이동횟수
	 * 
	 * 2. N <=500,000
	 * 
	 * 3. 빨강: 왼쪽으로하는 경우 오른쪽하는 경우
	 * 		파랑: 왼쪽, 오른쪽
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int R = 0;int B=0;
		
		for (int i = 0; i < N; i++) {
			if(input.charAt(i) == 'R')R++;
			else B++;
		}
		
		int ans = N;int cnt=0;
		//R 왼
		for (int i = 0; i < N; i++) {
			if(input.charAt(i) == 'R') {
				cnt++;
			}else break;
		}
		ans = Math.min(ans, R-cnt);
		cnt = 0;
		//R 오
		for (int i = N-1; i >=0; i--) {
			if(input.charAt(i) == 'R') {
				cnt++;
			}else break;
		}
		ans = Math.min(ans, R-cnt);
		cnt = 0;
		//B 왼
		for (int i = 0; i < N; i++) {
			if(input.charAt(i) == 'B') {
				cnt++;
			}else break;
		}
		ans = Math.min(ans, B-cnt);
		cnt = 0;
		//B 오
		for (int i = N-1; i >=0; i--) {
			if(input.charAt(i) == 'B') {
				cnt++;
			}else break;
		}
		ans = Math.min(ans, B-cnt);
		cnt = 0;
		
		System.out.println(ans);
	}
}
