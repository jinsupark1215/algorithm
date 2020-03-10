package DP;

import java.util.Scanner;

public class Main9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr= new int[12];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		arr[4] = 7;
		for (int i = 5; i < 12; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}
	}
}
