package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1860 {

	/*
	 * [삼성] 진기의 붕어빵 가게
	 * 
	 * 1. 기다리는 시간 없이 붕어빵 제공가능
	 * 
	 * 2. N,M,K <=100
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			
			PriorityQueue<Integer> q = new PriorityQueue<>();
			boolean flag = false;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int time = 1;
			int bbang = 0;
			while(!q.isEmpty()) {
				int person = q.poll();
				
				if(time < person) {
					for (int i = time+1; i <= person; i++) {
						if(i%M ==0)bbang+=K;
					}
					time = person;
				}
				if(bbang == 0) {
					flag = true;
					break;
				}
				else {
					bbang--;
				}
			}
			
			if(flag)System.out.println("#"+tc+" " + "Impossible");
			else System.out.println("#"+tc+" " + "Possible");
		}
	}
	
}
