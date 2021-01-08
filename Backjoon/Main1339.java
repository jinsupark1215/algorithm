package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1339 {

	/*
	 * [백준] 단어수학
	 * 
	 * 1. 단어의 최댓값
	 * 
	 * 2.
	 * 
	 * 3. dp
	 */

	static int N, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		String alpha[] = new String[input];
		int dp[] = new int[10];
		int num[] = new int[10];

		for (int i = 0; i < input; i++) {
			alpha[i] = br.readLine();
		}
		for (int i = 0; i < input; i++) { // 한줄
			int ten = 1;
			for (int j = alpha[i].length() - 1; j >= 0; j--) { // 끝문자

				for (int q = 0; q < 10; q++) {
					if (dp[q] == 0) {
						dp[q] = (int) alpha[i].charAt(j);
						num[q] += ten;
						break;
					} else if (dp[q] == (int) alpha[i].charAt(j)) {
						num[q] += ten;
						break;
					}
				}
				ten *= 10;
			}
		}
		int sum = 0;

		Arrays.sort(num);
		
		for (int i = 9; i > 0; i--) {
			sum += num[i] * i;
		}
		System.out.println(sum);
	}
}
