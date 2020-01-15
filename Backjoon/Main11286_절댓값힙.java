package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main11286_절댓값힙 {

	/*
	 * 1. 최소힙 구현
	 * 
	 * 2. N <=100,000
	 * 
	 * 3. 우선순위 큐 사용
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)==Math.abs(o2))return o1-o2;
				else return Math.abs(o1)-Math.abs(o2);
			}
		});
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(q.isEmpty())System.out.println(0);
				else System.out.println(q.poll());
			}else {
				q.add(num);
			}
		}
	}
}
