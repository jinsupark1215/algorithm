package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1662 {

	/*
	 * [백준] 압축
	 * 1. 압축되지 않은 길이
	 * 
	 * 2. 최대 50
	 * 
	 * 3. 스택 사용
	 */
	static String line;
	static int[] reverse;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = br.readLine();
		Stack<Integer> stack = new Stack<>();
		reverse = new int[50];
		
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)=='(') stack.add(i);
			if(line.charAt(i)==')') reverse[stack.pop()] = i;
		}
		System.out.println(go(0,line.length()));
	}
	
	public static int go(int start, int end) {
		int lineLength=0;
		
		for(int i=start;i<end;i++) {
			if(line.charAt(i)=='(') {
				lineLength += (line.charAt(i-1) - '0' ) * go(i+1,reverse[i])-1;
				i=reverse[i];
			} else {
				lineLength++;
			}
		}
		return lineLength;
	}
}
