package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1213_D3_String {

	/*
	 * 1. 해당 문자가 몇번 나왔는지 검색
	 * 
	 * 2. 검색문장 10 문장의 길이 최대 1000
	 * 
	 * 3.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			String tmp = br.readLine();
			String input = br.readLine();
			
			int tmpsize = tmp.length();
			int inputsize = input.length();
			for (int i = 0; i <inputsize - tmpsize+1 ; i++) {
				if(tmp.equals(input.substring(i, i+tmpsize)))ans++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
