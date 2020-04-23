package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main11003{

	/*
	 * [백준] 최솟값 찾기
	 * 
	 * 1. 순서대로 출력
	 * 
	 * 2. N,L <=5,000,000
	 * 
	 * 3. 슬라이딩 윈도우 방법 -> 데크 개념
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] deque = new int[N];
		int[] ans = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int left = 0, right = 0;
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
			while (left != right && A[deque[right - 1]] > A[n]) {
				right--;
			}
			deque[right++] = n;
			if (deque[left] <= n - L) {
				left++;
			}
			ans[n] = A[deque[left]];
		}
		for (int a : ans) {
			bw.write(a + " ");
		}
		bw.close();
	}
}
