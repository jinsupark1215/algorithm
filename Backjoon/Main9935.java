package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9935 {

	/*
	 * [백준] 문자열 폭발
	 * 
	 * 1. 폭발하고 남은 문자열
	 * 
	 * 2. 길이 <=1000000
	 * 
	 * 3. 인덱스 제어
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] bomb = br.readLine().toCharArray();
		
		char[] ans = new char[input.length()];
		int length = bomb.length;
		int idx =0;
		
		for (int i = 0; i < input.length(); i++) {
			ans[idx++] = input.charAt(i);
			if(ans[idx-1] == bomb[length - 1]) {
				if(idx - length < 0)continue;
				boolean flag = false;
				for (int j = 0; j < length; j++) {
					if(ans[idx - 1 - j] != bomb[length -1 -j]) {
						flag = true;
						break;
					}
				}
				if(!flag)idx -=length;
			}
		}
		
		if(idx == 0)System.out.println("FRULA");
		else {
			for (int i = 0; i < idx; i++) {
				System.out.print(ans[i]);
			}
		}
	}
}
