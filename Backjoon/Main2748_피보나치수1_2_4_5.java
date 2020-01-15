package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main2748_피보나치수1_2_4_5 {
/*
 * 1. n번째 피보나치 수 구하기
 * 
 * 2. n <=90
 * 
 * 3. dp
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger first = BigInteger.ZERO;
		BigInteger second = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		for (int i = 2; i <= n; i++) {
			sum = first.add(second);
			first = second;
			second = sum;
		}
		if(n == 1)System.out.println(1);
		else System.out.println(sum);
	}
}
