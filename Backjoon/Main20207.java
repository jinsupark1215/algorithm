package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20207 {

	/*
	 * [백준] 달력
	 * 1. 코팅지의 면적
	 * 
	 * 2. N <=1000
	 * 
	 * 3. 배열하나
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[366];
		int s = 366, e = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for (int j = start; j <= end; j++) {
				arr[j]++;
			}
			s = (s > start)? start : s;
			e = (e <end)? end : e;
		}
		
		int max = 0;
		int pre = s;
		int ans  =0;
		for (int i = s; i < e+2; i++) {
			if(arr[i] == 0) {
				ans += (i-pre)*max;
				max = 0;
				pre = i+1;
				continue;
			}
			max = (max < arr[i])? arr[i] : max;
		}
		
		System.out.println(ans);
	}
}
