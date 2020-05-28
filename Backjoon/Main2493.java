package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {

	/*
	 * [백준] 탑
	 * 
	 * 1. Stack 사용
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Top> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek().height > tmp) {
					bw.write(stack.peek().position + " ");
					break;
				}
				stack.pop();
			}
				if(stack.isEmpty())bw.write("0 ");
				stack.push(new Top(tmp, i));
			}
		
		bw.flush();
	}
	static class Top{
		int height, position;

		public Top(int height, int position) {
			super();
			this.height = height;
			this.position = position;
		}
		
	}
}
