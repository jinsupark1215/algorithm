package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11727 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		arr[0]=1;
		arr[1]=3;
		for (int i = 2; i <n; i++) {
			arr[i]=(arr[i-1]+arr[i-2]*2)%10007;
		}
		System.out.println(arr[n-1]);
	}
}
