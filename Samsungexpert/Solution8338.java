package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8338 {

	/*
	 * 1. 나올 수 있는 최댓값
	 * 
	 * 2. N <= 9
	 * 
	 * 3. 완탐
	 */
	static int N, ans;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N+1];
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			go(0,num[0]);
			
			System.out.println("#"  + tc + " " + ans);
		}
	}

	private static void go(int idx, int sum) {
		if(idx == N) {
			ans = Math.max(ans, sum);
			return;
		}
		
		go(idx+1, sum + num[idx+1]);
		go(idx+1, sum * num[idx+1]);
	}
}
