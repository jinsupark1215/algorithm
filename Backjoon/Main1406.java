package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1406 {

	static public void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();

		// string
		String str = st.nextToken();

		// num of operation
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		// length of string
		int size = str.length();

		for (int i = 0; i < size; i++) {
			left.push(String.valueOf(str.charAt(i)));
		}

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());

			String op = st.nextToken();

			if (op.equals("L")) {
				if (!left.isEmpty())
					right.push(left.pop());
			} else if (op.equals("D")) {
				if (!right.isEmpty())
					left.push(right.pop());
			} else if (op.equals("B")) {
				if (!left.isEmpty())
					left.pop();
			} else {
				left.push(st.nextToken());
			}
		}

		while (!left.isEmpty()) {
			right.push(left.pop());
		}

		while (!right.isEmpty()) {
			System.out.print(right.pop());
		}
	}
}
