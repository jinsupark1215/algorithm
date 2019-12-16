package Programs;

import java.util.Scanner;
import java.util.Stack;

public class Ntech3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = "3+([5+1])";
		System.out.println(solution(input));
	}

	public static boolean solution(String input) {
		boolean answer = false;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '(') {
				stack.push(input.charAt(i));
			}
			switch (input.charAt(i)) {
			case ']':
				if (stack.peek() == '[') {
					stack.pop();
				}
				if(!stack.isEmpty() &&(stack.contains('[') || stack.contains('{')  || stack.contains('(') )) {
					stack.push('0');
				}
				break;
			case '}':
				if (stack.peek() == '{') {
					stack.pop();
				}
				if(!stack.isEmpty() &&(stack.contains('{')  || stack.contains('('))) {
					stack.push('0');
				}
				break;
			case ')':
				if (stack.peek() == '(') {
					stack.pop();
				}
				if(!stack.isEmpty() && stack.contains('(')) {
					stack.push('0');
				}
				break;

			}

		}
		if (stack.isEmpty())
			answer = true;
		return answer;
	}
}
