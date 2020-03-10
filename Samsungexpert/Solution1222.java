package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1222 {

	/*
	 * 1. 계산기 구현
	 * 
	 * 2. 숫자는 0~9, 연산자는 +하나뿐
	 * 
	 * 3. 더하기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			
		int n = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int ans =0;
		for (int i = 0; i < n; i++) {
			if(input.charAt(i)-'0' >=0 && input.charAt(i)-'0' < 10) {
				sb.append(input.charAt(i));
				if(!stack.isEmpty())sb.append(stack.peek());
			}else {
				stack.add('+');
			}
		}
		Stack<Integer> cal = new Stack<>();
		for (int i = 0; i < n; i++) {
			if(sb.toString().charAt(i)-'0'>=0 && sb.toString().charAt(i)-'0' < 10) {
				cal.add(sb.toString().charAt(i)-'0');
			}else {
				int num = cal.pop() + cal.pop();
				cal.add(num);
			}
		}
		ans =cal.pop();
		System.out.println("#" + tc +" " + ans);
		}
	}
}

