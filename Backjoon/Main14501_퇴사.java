package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501_퇴사 {

	/*
	 * 1. 최대 이익을 출력
	 * 
	 * 2. 1 <= N <=15
	 * 
	 * 3.뒤에서 dp구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+2][2];
		int[] dp = new int[n+2];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n; i >0; i--) {
			int day = i+arr[i][0]; // 상담기간
			
			if(day<=n+1) {
				dp[i] = Math.max(arr[i][1] + dp[day], dp[i+1]);
			}else {
				dp[i] = dp[i+1];
			}
		}
		System.out.println(dp[1]);
	}
}
