package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main10825 {

	/*
	 * [백준] 국영수
	 * 
	 * 1. 정렬기준으로 정렬
	 * 
	 * 2. N<=100,000
	 * 
	 * 3. Queue이용
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q.add(new Point(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.poll().name);
		}
	}
	static class Point implements Comparable<Point>{
		String name;
		int a,b,c;
		public Point(String name, int a, int b, int c) {
			super();
			this.name = name;
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Point o) {
			if(this.a == o.a) {
				if(this.b == o.b) {
					if(this.c == o.c) {
						return this.name.compareTo(o.name);
					}else return o.c - this.c;
				}else return this.b - o.b;
			}else return o.a-this.a;
		}
	}
}
