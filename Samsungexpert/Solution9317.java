package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9317 {

	/*
	 * [삼성] 석찬이의 받아쓰기
	 * 
	 * 1. 맞게 받아적은 갯수
	 * 
	 * 2. N <=100000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String a = br.readLine();
			int ans = 0;
			for (int j = 0; j < N; j++) {
				if (input.charAt(j) == a.charAt(j))
					ans++;
			}
			System.out.println("#" + i + " " + ans);
		}
	}
}
