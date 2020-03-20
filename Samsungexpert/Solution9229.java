package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9229 {

	/*
	 * [삼성] 한빈이와 spot mart
	 * 
	 * 1. 2개의 과자봉지 무게 최대합
	 * 
	 * 2. N<=1000, M <2000000
	 * 
	 * 3. 구현
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans = -1;
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					if(arr[i]+arr[j] <=m)ans = Math.max(ans, arr[i]+arr[j]);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
