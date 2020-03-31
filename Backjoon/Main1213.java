package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1213 {

	/*
	 * 1. 문자열로 바꾸는 법
	 * 
	 * 2. 최대 50글자
	 * 
	 * 3. 배열 사용
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] arr = new int[26];
		
		for (int i = 0; i < input.length(); i++) {
			arr[input.charAt(i) -'A']++;
		}
		
		boolean flag = true;
		for (int i = 0; i < 26; i++) {
			if(arr[i] % 2 !=0)flag = false;
		}
		
		if(!flag) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < arr[i]/2; j++) {
					sb.append((char)('A' +i));					
				}
			}
			for (int i = 25; i >=0; i--) {
				for (int j = 0; j < arr[i]/2; j++) {
					sb.append((char)('A' +i));					
				}
			}
			System.out.println(sb.toString());
		}
	}
}
