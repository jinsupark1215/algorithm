package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1676 {

	/*
	 * [백준] 팩토리얼 0의 개수
	 * 1. 0의 갯수
	 * 
	 * 2. N <=500
	 * 
	 * 3. 5와 2의 갯수
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int two =0, five=0;
		boolean flag;
		for (int i = 2; i <= N; i++) {
			flag = true;
			int num = i;
			while(flag) {
				flag = false;
				if(num%2 ==0) {
					two++;
					num/=2;
					flag = true;
				}
				if(num%5 ==0) {
					five++;
					num/=5;
					flag = true;
				}
			}
		}
		
		System.out.println(Math.min(two, five));
	}
}
