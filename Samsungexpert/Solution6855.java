package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6855 {

	/*
	 * 1. 설치하는 전선 길이의 최솟값
	 * 
	 * 2. N,K < 10000
	 * 
	 * 3. 조합
	 */

	static int N, K, ans;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N - 1];
			ans = 0;
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			for (int i = 1; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i - 1] = tmp - pre;
				pre = tmp;
			}
			Arrays.sort(map);

			for (int i = N - 1 - K; i >= 0; i--) {
				ans += map[i];
			}

			System.out.println("#" + testcase + " " + ans);
		}
	}

}
