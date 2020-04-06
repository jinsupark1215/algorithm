package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289 {

	/*
	 * [삼성] 원재의 메모리 복구
	 * 
	 * 1. 최소 수정 횟수
	 * 
	 * 2. 길이 <= 50
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] input = br.readLine().toCharArray();
			int cnt =0;
			for (int i = 0; i < input.length; i++) {
				if(input[i] == '1') {
					cnt++;
					for (int j = i; j < input.length; j++) {
						if(input[j] == '1')input[j] = '0';
						else input[j] ='1';
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
