package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1725 {

	/*
	 * [백준] 히스토그램
	 * 1. 최대 직사각형 넓이
	 * 
	 * 2. 높이 10억 이하, N <= 100000
	 * 
	 * 3. 앞뒤
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);

		for (int i = 1; i <= N + 1; i++) {

			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int height = arr[stack.peek()];
		        stack.pop();
		        int width = i - stack.peek() - 1;

				ans = Math.max(ans, width * height);
			}
			stack.push(i);
		}

		System.out.println(ans);
	}
}
