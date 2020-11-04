package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2217 {

	/*
	 * [백준] 로프
	 * 
	 * 1. 최대중량 구하기
	 * 
	 * 2. N <= 100000
	 * 
	 * 3. 갯수만큼 했을 때 가장 많은 중량 찾기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i] *(N-i));
		}
		
		System.out.println(max);
	}
}
