package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504_괄호의값 {

	/*
	 * 1. 괄호의 합을 구하라
	 * 
	 * 2. () +2, [] +3, (X) 2x값, [X] 3x값, (XY) X+Y
	 * 
	 * 3. 스택으로 구현.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		int mult = 1;
		
		fin:
		for (int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			switch (tmp) {
			case '(':
				stack.push('(');
				mult *= 2;
				break;
			
			case '[':
				stack.push('[');
				mult *=3;
				break;
				
				
			case ')':
				if(stack.isEmpty() || stack.peek() != '(') {
					ans = 0;
					break fin;
				}
					if(input.charAt(i-1) == '(') {
						ans+=mult;
					}
					stack.pop();
					mult /=2;
					
					
				break;
			case ']':
				if(stack.isEmpty() || stack.peek() != '[') {
					ans = 0;
					break fin;
				}
					if(input.charAt(i-1) == '[') {
						ans+=mult;
					}
					stack.pop();
					mult /=3;
				
				break;
				
			}
		}
		if(stack.isEmpty())System.out.println(ans);
		else System.out.println(0);
	}
}
