package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9996 {

	/*
	 * [백준] 한국이 그리울 땐 서버에 접속하지
	 * 1. 접두어랑 접미사가 같은가
	 * 
	 * 2. N < =100
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] str = new String[2];
		
		str = br.readLine().split("\\*");
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			boolean flag = false;
			
			if(input.length() >= (str[0].length()+str[1].length()) &&str[0].equals(input.substring(0, str[0].length())) && str[1].equals(input.substring(input.length() -str[1].length(), input.length()))) {
				flag = true;
			}
			if(flag)System.out.println("DA");
			else System.out.println("NE");
			
		}
	}
}
