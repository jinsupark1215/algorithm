package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main10867 {

	/*
	 * [백준] 중복 빼고 정렬하기
	 * 
	 * 1. 중복제거 후 정렬
	 * 
	 * 2. 절댓값 1000이하
	 * 
	 * 3. 우선순위 큐
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		boolean[] chk = new boolean[2002];
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken())+1000;
			if(!chk[num]) {
				chk[num] = true;
				pq.add(num);
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.print((pq.poll()-1000) + " ");
		}
	}
}
