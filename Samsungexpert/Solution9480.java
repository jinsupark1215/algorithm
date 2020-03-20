package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9480 {

	/*
	 * [삼성]민정이와 광직이의 알파벳 공부 
	 * 
	 * 1. 만들 수 있는 단어 세트의 갯수
	 * 
	 * 2. N <=15, 단어 길이 100이하
	 * 
	 * 3. 완탐
	 */
	static int N;
	static String arr[];
	static boolean chk[];
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			chk = new boolean[N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}
			solve(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void solve(int idx) {
		if (idx == N) {
			int alphabet[] = new int[26];
			for (int i = 0; i < N; i++) {
				if (chk[i]) {
					for (int j = 0; j < arr[i].length(); j++) {
						alphabet[arr[i].charAt(j) - 'a'] = 1;
					}
				}
			}
			int alpha = 0;
			for (int i = 0; i < 26; i++) {
				if (alphabet[i] == 0) {
					alpha = 1;
				}
			}
			if (alpha == 0)
				ans++;
			return;
		}
		if (!chk[idx])
			chk[idx] = true;
		solve(idx + 1);
		chk[idx] = false;
		solve(idx + 1);
	}
}
