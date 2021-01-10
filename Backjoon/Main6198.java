package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main6198 {

	/*
	 * [백준] 옥상정원 꾸미기
	 * 
	 * 1. 벤치마킹 가능한 빌딩의 수의 합
	 * 
	 * 2. N <=80000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] h = new int[N];
		int[] n = new int[N];
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}
		long result = 0;
		int c = 0;
		for (int i = N-1; i >= 0; i--) {
			c = 0;
			n[i] = i + 1;
			while (n[i] < N && h[n[i]] < h[i]) {
				c += n[n[i]] - n[i];
				n[i] = n[n[i]];
			}
			result += c;
		}
		System.out.println(result);
	}
}
