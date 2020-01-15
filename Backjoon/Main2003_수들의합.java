package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003_수들의합 {
/*
 * 1. i부터 j 까지 합이 M이 되는 경우의 수를 구하라
 * 
 * 2. N <=10000, M <=300000000
 * 
 * 3. firstidx와 secondidx를 이용해서 
 * M보다 같으면 답+1 secondidx 더하고증가
 * M보다 크면 firstidx 빼고 증가 
 * M보다 작으면 secondidx 더하고 증가
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int firstidx =0, secondidx =0, sum = 0, ans =0;
		
		while(secondidx <= N) {
			if(sum < M) {
				sum += arr[secondidx++];
			}else if(sum == M) {
				ans++;
				sum += arr[secondidx++];				
			}else {
				sum -= arr[firstidx++];
			}
		}
		System.out.println(ans);
	}
}
