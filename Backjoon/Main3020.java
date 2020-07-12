package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3020 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] top = new int[m + 2];
		int[] bottom = new int[m + 2];

		for (int i = 0; i < n / 2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}

		for (int i = top.length - 2; i >= 0; i--) {
			bottom[i] += bottom[i + 1];
			top[i] += top[i + 1];
		}
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 1; i <= m; i++) {

			int total = bottom[i] + top[m - i + 1];

			if (min >= total) {
				if (min == total)
					count++;
				else {
					count = 1;
					min = total;
				}

			}
		}

		System.out.println(min + " " + count);

	}
}
