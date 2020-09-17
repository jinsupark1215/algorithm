package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2023 {

	/*
	 * [백준] 신기한 소수
	 * 1. N자리 숫자중 신기한소수
	 * 
	 * 2. N <=8
	 * 
	 * 3. 오름차순, 루트 N 시간복잡도, 약분되는 수 이용
	 */
	
	static int N;
	public static void main(String args[]) throws Exception	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		dfs(0, 0);
	}
	
	public static void dfs(int n, int length) {
		if (!isPrime(n))return;

		if (length == N) {
			System.out.println(n);
			return;
		}

		else {
			int i = 1;
			if (length == 0) i = 2;
			for (; i <= 9; i++) {
				dfs(n * 10 + i, length + 1);
			}
		}
	}
	public static boolean isPrime(int k) {
		for (int i = 2; i <= Math.sqrt(k); i++) {
			if (k % i == 0) return false;
		}
		return true;
	}
}
