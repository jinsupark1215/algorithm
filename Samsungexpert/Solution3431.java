package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3431 {

	/*
	 * [삼성] 준환이의 운동관리
	 * 
	 * 1. 더하기
	 * 
	 * 2. 
	 * 
	 * 3.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			
			if(X < L) {
				ans = L-X;
			}else if(X >= L && X <= U) {
				ans = 0;
			}else {
				ans = -1;
			}
			
			System.out.println("#"+tc+" " + ans);
		}
	}
}
