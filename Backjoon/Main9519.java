package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main9519 {

	/*
	 * 1. X번 깜빡이기 전의 글자를 찾아라
	 * 
	 * 2. 홀수인 경우 뒤에글자가 더 적음, X는 10억이하
	 * 
	 * 3. X번만큼 stingbulider로 
	 * 짝수
	 * 홀수번째 더하고 뒤에서부터 짝수번째더한다
	 * 홀수
	 * 홀수번째 더하고 마지막 전에서부터
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		String input = br.readLine();
		ArrayList<String> ans= new ArrayList<>();
		ans.add(input);
		while(true) {
			StringBuilder sb = new StringBuilder();
			
			int length = input.length();
			if(length%2 ==0) {
				for (int i = 0; i < length; i+=2) {
					sb.append(input.charAt(i));
				}
				for (int i = length-1; i > 0; i-=2) {
					sb.append(input.charAt(i));
				}
			}else {
				for (int i = 0; i < length; i+=2) {
					sb.append(input.charAt(i));
				}
				for (int i = length-2; i > 0; i-=2) {
					sb.append(input.charAt(i));
				}
			}
			input = sb.toString();
			if(ans.get(0).equals(input))break;
			ans.add(input);
		}
		System.out.println(ans.get(x%ans.size()));
	}
}

