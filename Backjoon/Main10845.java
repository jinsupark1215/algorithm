package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10845 {

	/*
	 * 1. 큐를 구현
	 * 
	 * 2.  N <= 10000
	 * 
	 * 3. 배열을 이용해 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] queue = new int[10000];
		int frontidx = 0;
		int backidx = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if(input.equals("push")) {
				queue[backidx] = Integer.parseInt(st.nextToken());
				backidx++;
			}else if(input.equals("pop")) {
				if(backidx == frontidx)System.out.println(-1);
				else System.out.println(queue[frontidx++]);				
			}else if(input.equals("size")) {
				System.out.println(backidx - frontidx);
			}else if(input.equals("empty")) {
				if(backidx == frontidx)System.out.println(1);
				else System.out.println(0);
			}else if(input.equals("front")) {
				if(backidx == frontidx)System.out.println(-1);
				else System.out.println(queue[frontidx]);				
			}else if(input.equals("back")) {
				if(backidx == frontidx)System.out.println(-1);
				else System.out.println(queue[backidx-1]);				
			}
		}
	}
}
