package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10202 {

	/*
	 * [삼성] 문자열 동화
	 * 1. 세 문자열을 동일하게 만드는 최소횟수
	 * 
	 * 2. n <= 1000
	 * 
	 * 3. 바꿔야하는 횟수 저장
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			String A = br.readLine();
			String B = br.readLine();
			String C = br.readLine();
			
			for (int i = 0; i < n; i++) {
				char tmpa = A.charAt(i);
				char tmpb = B.charAt(i);
				char tmpc = C.charAt(i);
				if(tmpa == tmpb && tmpa != tmpc) {
					ans++;
				}else if(tmpa == tmpc && tmpa != tmpb) {
					ans++;
				}else if(tmpb == tmpc && tmpa != tmpb) {
					ans++;
				}else if(tmpa != tmpc && tmpa != tmpb) {
					ans+=2;
				}
			}
			System.out.println("#"+ tc + " " + ans);
		}
	}
}
