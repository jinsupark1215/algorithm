package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13335 {

	/*
	 * [백준] 트럭 1. 다 건널수 있는 최단시간
	 * 
	 * 2.
	 * 
	 * 3. 구현
	 */
	static int[] bridge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int time = 1;
		bridge = new int[w];
		int idx = 0;

		bridge[0] = arr[idx++];

		while (true) {
			if (idx == n) 
				break;
			move();
			time++;

			if (Sum() + arr[idx] <= L) {
				bridge[0] = arr[idx++];
			}
		}

		System.out.println(time + w);

	}

	static int Sum() { 
		int sum = 0;
		for (int w : bridge)
			sum += w;
		return sum;
	}

	static void move() {
		for (int i = bridge.length - 1; i > 0; i--) {
			bridge[i] = bridge[i - 1];
		}
		bridge[0] = 0;

	}
}
