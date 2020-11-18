package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715 {

	/*
	 * [백준] 카드 정렬하기
	 * 
	 * 1. 최소 비교횟수
	 * 
	 * 2. N<= 10000
	 * 
	 * 3. 정렬후 앞에서부터 더해주기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		
		int ans = 0;
		while(q.size() !=1) {
			int a = q.poll();
			int b = q.poll();
			ans += a+b;
			q.add(a+b);
		}
		System.out.println(ans);
	}
}
