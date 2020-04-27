package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16942 {

	/*
	 * [백준] 문자열 접기
	 * 
	 * 1. 똑같은 문자로 만들수 있는 최대 길이
	 * 
	 * 2. 길이 <=1000
	 * 
	 * 3. 똑같은 숫자가 발견되면 접어보기, 완탐 -> 시간초과
	 * 
	 * 자기랑 홀수번쨰에 같은 문자가 있는지 판단
	 */
	static String input;
	static int ans, length;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		ans = 1;
		
		length = input.length();
		for (int i = 0; i < length/2; i++) {
			go(i,i+1,1);
		}
		
		System.out.println(ans);
	}
	private static void go(int idx, int newidx, int max) {
		if(max > ans)ans = max;
		
		if(newidx < length) {
		
		if(input.charAt(idx) == input.charAt(newidx)) {
			go(newidx,newidx+1,max+1);
		}else {
			go(idx,newidx+2,max);
		}
		}
	}
}
