package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {

	/*
	 * [백준] 공유기 설치
	 * 
	 * 1. 공유기 거리를 최대
	 * 
	 * 2. N <=200000
	 * 
	 * 3. 이분
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    int[] arr = new int[n];
	 
	    for (int i = 0; i < n; i++) {
	        arr[i] = Integer.parseInt(br.readLine());
	    }
	 
	    Arrays.sort(arr);
	 
	    int left = 1; 
	    int right = arr[n - 1] - arr[0];
	    int d = 0;
	    int ans = 0;
	 
	    while (left <= right) {
	        int mid = (left + right) / 2;
	        int start = arr[0];
	        int cnt = 1;
	 
	        for (int i = 1; i < n; i++) {
	            d = arr[i] - start;
	            if (mid <= d) {
	                ++cnt;
	                start = arr[i];
	            }
	        }
	 
	        if (cnt >= c) {
	            ans = mid;
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    System.out.println(ans);


	}
}
