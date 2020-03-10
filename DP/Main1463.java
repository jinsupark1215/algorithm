package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Main1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] arr= new int[X+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[X]=0;
		
		while(X>0) {
			if(X%3 ==0) 
			arr[X/3] = Math.min(arr[X/3], arr[X]+1);
			if(X%2 ==0) 
			arr[X/2] = Math.min(arr[X/2], arr[X]+1);
			arr[X-1] = Math.min(arr[X-1], arr[X]+1);
			X--;
		}
		System.out.println(arr[1]);
	}
}
