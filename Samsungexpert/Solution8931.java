package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution8931 {

	/*
	 * [삼성] 제로 1. 받아적은 수의 합
	 * 
	 * 2. K <= 100,000
	 * 
	 * 3. stack 이용
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Stack<Integer> stack = new Stack<>();
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < K; i++) {
				int num = Integer.parseInt(br.readLine());
				if (num != 0)
					stack.add(num);
				else
					stack.pop();
			}

			int ans = 0;
			while (!stack.isEmpty())
				ans += stack.pop();
			System.out.println("#" + tc + " " + ans);
		}
	}
}
