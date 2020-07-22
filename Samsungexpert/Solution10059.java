package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10059 {

	/*
	 * [삼성] 유효기간
	 * 
	 * 1. 어떤 표기법인지 찾기
	 * 
	 * 2. 
	 * 
	 * 3. if문
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			String input = br.readLine();
			int a = Integer.parseInt(input.substring(0, 2));
			int b = Integer.parseInt(input.substring(2, 4));
			
			if(a<13 && b < 13 && a>0 && b>0) {
				System.out.println("#"+test + " AMBIGUOUS");
			}else if(b < 13 && b >0) {
				System.out.println("#"+test + " YYMM");
			}else if(a <13 && a>0) {
				System.out.println("#"+test + " MMYY");
			}else {
				System.out.println("#"+ test + " NA");
			}
		}
	}
}
