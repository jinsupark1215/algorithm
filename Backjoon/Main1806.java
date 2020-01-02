package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806 {

	/*
	 * 1. 주어진 수열에서 합이 S를 넘는 가장 작은 연속수열의 갯수
	 * 
	 * 2. N < 100,000. S는 1억 이하. 시간 주의!
	 * 
	 * 3. firstIndex 와 secondIndex로 이동해가며 가장 적은 부분합의 갯수를 찾음.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int sum =0;
		int answer =100001;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		int firstIdx = 0, secondIdx = 0;
		while(true) {
			if(sum >= S) {
				sum -= arr[firstIdx];
				firstIdx++;
				answer = Math.min(answer, (secondIdx-firstIdx+1));
			}else if(secondIdx == N)break;
			else {
				sum += arr[secondIdx];
				secondIdx++;
			}
		}
		
		if(answer == 100001) {
			System.out.println(0);
		}else {
			System.out.println(answer);			
		}
	}
}
