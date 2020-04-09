package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18311 {

	/*
	 * [백준] 왕복
	 * 
	 * 1. k가 몇번 코스인지?
	 * 
	 * 2. N<=100,000
	 * 
	 * 3. 배열
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int[] num = new int[N];
		long sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			num[i] = n;
			sum += n;
		}

		if (K >= sum) {
			K = K - sum;
			for (int i = N - 1; i >= 0; i--) {
				K -= num[i];
				if (K < 0) {
					System.out.println(i + 1);
					break;
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				K -= num[i];
				if (K < 0) {
					System.out.println(i + 1);
					break;
				}
			}
		}
	}
}
