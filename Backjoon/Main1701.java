package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1701 {

	/*
	 * [백준] Cubeditor
	 * 
	 * 1. 2번이상 나오는 가장 긴 문자열
	 * 
	 * 2. N <=5000
	 * 
	 * 3. KMP 알고리즘  - 참고
	 * 
	 */
	static String input;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		ans = 0;
		for (int i = 0; i < input.length(); i++) {
			ans = Math.max(ans, getMax(input.substring(i, input.length())));
		}
		System.out.println(ans);
	}

	private static int getMax(String tmp) {
		int fail[] = new int[tmp.length()];
		int idx = 0, max = 0;
		for (int i = 1; i < tmp.length(); i++) {
			// 아니라면 갱신
			while(idx>0 && tmp.charAt(i) != tmp.charAt(idx)) {
				idx = fail[idx-1];
			}
			
			//같은 문자가 최대 몇개가 나오는지 판단
			if(tmp.charAt(i) == tmp.charAt(idx)) {
				max = Math.max(max, fail[i] = ++idx);
			}
		}
		return max;
	}
}
