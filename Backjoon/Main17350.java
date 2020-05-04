package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17350 {

	/*
	 * [백준] 2루수 이름이 뭐야
	 * 
	 * 1. anj 찾기
	 * 
	 * 2. 
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean flag = false;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if(input.equals("anj")) {
				flag = true;
				break;
			}
		}
		
		if(flag)System.out.println("뭐야;");
		else System.out.println("뭐야?");
	}
}
