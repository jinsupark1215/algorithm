package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1240 {

	/*
	 * 1. 암호 코드 합의 값
	 * 
	 * 2.
	 * 
	 * 3. 구현
	 */

	static String[] arr = { "0001101", "0011001", "0010011",
			"0111101", "0100011", "0110001", 
			"0101111", "0111011","0110111", "0001011" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			int[] ans = new int[8];
			
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = M - 1; j >= 0; j--) {
					if (!flag &&input.charAt(j) == '1') {
						flag = true;
						for (int k = j - 55; k <= j; k++) {
							sb.append(input.charAt(k));
						}
					}
				}
			}
			
			int idx = 0;
			for (int i = 0; i < 56; i+=7) {
				for (int j = 0; j < 10; j++) {
					if(sb.substring(i,i+7).equals(arr[j])) {
						ans[idx++] = j;
						break;
					}
				}
			}
			
			int answer =0;
			if((((ans[0]+ans[2]+ans[4]+ans[6])*3) + ans[1]+ans[3]+ans[5]+ans[7])%10 ==0) {
				for (int i = 0; i < 8; i++) {
					answer += ans[i];
				}
			}
			System.out.println("#"+ tc+ " " + answer);
		}
	}
}

