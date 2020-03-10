package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2748 {
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
		long[] arr = new long[91];
		arr[0] = 0; arr[1] = 1;
		for (int i = 2; i <= 90; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
	}
}

