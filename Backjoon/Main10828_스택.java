package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828_스택 {

	/*
	 * 1. 스택구현
	 * 
	 * 2. N<10000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				stack.add(Integer.parseInt(st.nextToken()));
				break;
			case "top":
				if(!stack.isEmpty())
				System.out.println(stack.peek());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "pop":
				if(stack.isEmpty())
				System.out.println(-1);
				else
				System.out.println(stack.pop());
				break;

			}
		}
	}
}
