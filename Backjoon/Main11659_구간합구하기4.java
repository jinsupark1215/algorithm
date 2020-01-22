package Backjoon;

import java.util.Scanner;

public class Main11659_구간합구하기4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int[] sum = new int[n];
		arr[0] = sum[0] = sc.nextInt();
		for (int i = 1; i < n; i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(start == 1)System.out.println(sum[end-1]);
			else System.out.println(sum[end-1] - sum[start-2]);
		}
	}
}
