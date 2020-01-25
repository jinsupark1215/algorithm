package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16637_괄호추가하기 {

	/*
	 * 1. 괄호를 적절히 추가해서 얻을 수 있는 최댓값
	 * 
	 * 2. 1<= N <=19, 연산자 +,-,*  , 왼쪽부터 순서대로 계산
	 * 
	 * 3. dfs -> 완탐
	 * 괄호를 친 경우 
	 * 괄호를 안치고 다음꺼에 괄호를 친 경우
	 * 
	 */
	
	static int ans, n;
	static int[] num;
	static char[] operation;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n/2+1];
		operation = new char[n/2];
		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			if(i%2==0) {
				num[i/2] = input.charAt(i)-'0';
			}else {
				operation[i/2] = input.charAt(i);
			}
		}
		ans = Integer.MIN_VALUE;
		dfs(0,num[0]);
		System.out.println(ans);
	}

	private static void dfs(int idx, int sum) {
		if(idx >=n/2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		//현재 idx에서 괄호를 침
		int res = cal(sum,operation[idx],num[idx+1]);
		dfs(idx +1, res);
		
		//다음 연산자에 괄호를 침
		if(idx+1 < n/2) {
			res = cal(sum, operation[idx], cal(num[idx+1],operation[idx+1], num[idx+2]));
			dfs(idx+2, res);
		}
	}

	private static int cal(int a, char oper, int b) {
		if(oper == '+')return a + b;
		else if(oper == '-')return a - b;
		else if(oper == '*')return a * b;
		return 0;
	}
}
