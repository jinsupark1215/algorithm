package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main20302 {

	/*
	 * [백준] 민트초코
	 * 1. 정수면 민트초코 유리수면 치약
	 * 
	 * 2. N <=1000000
	 * 
	 * 3. 계산
	 */
	static int[] divide;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int num = Integer.parseInt(input[0]);
		divide = new int[100001];
		
		if(N == 1) {
			System.out.println("mint chocolate");
		}else {
			chk(num, true);
			
			boolean flag = false;
			if(num == 0)flag = true;
			
			for (int i = 1; i < (N*2)-1; i+=2) {
				if(!flag) {
					int tmp = Integer.parseInt(input[i+1]);
					if(tmp ==0) {
						flag = true;
						continue;
					}
					
					if(input[i].equals("*"))chk(tmp,true);
					else chk(tmp,false);
				}
			}
			
			boolean check = true;
			if(!flag) {
				for (int i = 2; i <= 100000; i++) {
					if(divide[i] <0) {
						System.out.println("toothpaste");
						check = false;
						break;
					}
				}
			}
			if(check)
				System.out.println("mint chocolate");
		}
	}

	private static void chk(int num, boolean flag) {
		for (int i = 2; i*i <= num; i++) {
			while(Math.abs(num) %i == 0) {
				if(flag) divide[i]++;
				else divide[i]--;
				num /=i;
			}
		}
		
		if(num >1) {
			if(flag)divide[num]++;
			else divide[num]--;
		}
	}
}
