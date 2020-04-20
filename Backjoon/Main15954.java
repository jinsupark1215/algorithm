package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main15954 {

	/*
	 * [백준] 인형들
	 * 
	 * 1. 연속된 일렬로 했을 때 최소가 되는 표준편차
	 * 
	 * 2. N <= 500
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		double ans = 10000000;
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N-K; i++) {
			for (int m = 0; m <= N-K-i; m++) {
				
			long sum = 0;
			for (int j = i; j < i+K+m; j++) {
				sum += num[j];
			}
			double avg = (double)sum/(K+m);
			double tmp = 0;
			for (int j = i; j < i+K+m; j++) {
				tmp += ((num[j]-avg) * (num[j]-avg))/(K+m);
			}
			double b = Math.sqrt(tmp);
			ans = ans>b?b:ans;
			}
		}
		System.out.println(ans);
	}
}
