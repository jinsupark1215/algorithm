package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int[] rd1 = new int[N];
			int[] rd2 = new int[M];
			int[] enter1 = new int[N];
			Person[] p1 = new Person[N];
			int[] enter2 = new int[M];
			Person[] p2 = new Person[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				rd1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				rd2[i] = Integer.parseInt(st.nextToken());
			}
			
			PriorityQueue<Person> repair = new PriorityQueue<>();
			PriorityQueue<Person> reception = new PriorityQueue<>();
			PriorityQueue<Person> ans = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				repair.add(new Person(i,Integer.parseInt(st.nextToken()), 0,0));
			}
			
			//����
			int idx = 0;
			while(true) {
				idx++;
				int zero = 0;
				for (int i = 0; i < N; i++) {
					if(enter1[i] == 0) {
						if(p1[i] != null) {
							reception.add(new Person(p1[i].num,idx, i+1, 0));
							p1[i] = null;
						}
						if(!repair.isEmpty()) {
							enter1[i] = rd1[i];
							p1[i] = repair.poll();														
						}
						zero++;
					}else {
						enter1[i] -= 1;
					}
				}
				if(zero == N && repair.isEmpty())break;
			}
			
			while(true) {
				int zero = 0;
				for (int i = 0; i < M; i++) {
					if(enter2[i] == 0) {
						if(p2[i] != null) {
							ans.add(new Person(p2[i].num,idx, p2[i].one, i+1));
							p2[i] = null;
						}
						if (!reception.isEmpty()) {
							enter2[i] = rd2[i];
							p2[i] = reception.poll();							
						}
						zero++;
					}else {
						enter2[i] -= 1;
					}
				}
				if(zero == N && reception.isEmpty())break;
			}
			
			int sum = 0;
			while(!ans.isEmpty()) {
				Person p = ans.poll();
				if(p.one == A && p.two == B)sum+=p.num;
			}
			
			if(sum == 0)sum = -1;
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	static class Person implements Comparable<Person>{
		int num, time, one, two;


		public Person(int num, int time, int one, int two) {
			super();
			this.num = num;
			this.time = time;
			this.one = one;
			this.two = two;
		}


		@Override
		public int compareTo(Person o) {
			if(this.time == o.time)return this.num - o.num;
			else return this.time - o.time;
		}
	}
}
