package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18310 {

	/*
	 * 1. 거리의 합이 최소가 되는 경우
	 * 
	 * 2. N <=200,000
	 * 
	 * 3. 허탈
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if (N % 2 == 0) {
			System.out.println(arr[(N / 2) - 1]);
		} else {
			System.out.println(arr[N / 2]);
		}
	}
}
