package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2230 {

	/*
	 * [백준] 수고르기
	 * 
	 * 1. M이상이면서 가장 작은 차이를 출력
	 * 
	 * 2. N,M<=2000000000, 수는 10억 이하
	 * 
	 * 3. 투포인터 사용, 정렬해서 둘의 차이가 최소인 것 찾기
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr= new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		
		int s = 0, e =1;
		while(e < N) {
			if(arr[e] - arr[s] < M) {
				e++;
				continue;
			}
			if(arr[e] - arr[s] == M) {
				min = M;
				break;
			}
			min = Math.min(min, arr[e]-arr[s]);
			s++;
		}
		
		System.out.println(min);
	}
}
