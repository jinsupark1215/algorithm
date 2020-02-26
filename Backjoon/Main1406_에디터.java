package Backjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main1406_에디터 {

	/*
	 * 구현
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Stack<Character> st1 = new Stack<>(); 
		Stack<Character> st2 = new Stack<>(); 
		for (int i = 0; i < input.length(); i++) {
			st1.add(input.charAt(i));
		}
		
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			char tmp = sc.next().charAt(0);
			if(tmp == 'L') {
				if(!st1.isEmpty())st2.add(st1.pop());
			}else if(tmp == 'D') {
				if(!st2.isEmpty())st1.add(st2.pop());
			}else if(tmp == 'B') {
				if(!st1.isEmpty())st1.pop();
			}else {
				st1.add(sc.next().charAt(0));
			}
		}
		int size = st1.size();
		for (int i = 0; i < size; i++) {
			st2.add(st1.pop());
		}
		size = st2.size();
		for (int i = 0; i < size; i++) {
			System.out.print(st2.pop());
		}
	}
}
