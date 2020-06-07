package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14719 {

	/*
	 * [백준] 빗물
	 * 1. 빗물이 얼마나 쌓이는지
	 * 
	 * 2.
	 * 
	 * 3. maxval을 찾아서 뺴주기
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int[] map = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int[] maxVal = new int[M];
		for (int i = 0; i < M; i++) {
			max = Math.max(max, map[i]);
			maxVal[i] = max;
		}
		max = 0;
		for (int i = M-1; i >= 0; i--) {
			max = Math.max(max, map[i]);
			maxVal[i] = Math.min(maxVal[i], max);
		}
		for (int i = 0; i < M; i++) {
			ans += Math.max(0, maxVal[i] - map[i]);
		}
		
		System.out.println(ans);
	}
}
