package Backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main7570_줄세우기 {

	/*
	 * 1. 최소로 줄세우는 방법
	 * 
	 * 2. 어린이 수 <=1,000,000
	 * 
	 * 3. 증가범위가 1, 순서대로 있는 것 뺴고 앞이나 뒤로 다보내버림 -> (연속된 수 몇개인지 찾기)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max =0;
		int[] cnt = new int[N+1];
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			cnt[arr[i]] = cnt[arr[i]-1] + 1;
			if(cnt[arr[i]] > max)max = cnt[arr[i]];
		}
		System.out.println(N-max);
	}
}
