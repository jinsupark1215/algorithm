package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_카카오_실패율 {

	/*
	 * 1. 압축해서 가장 짧은 길이는?
	 * 
	 * 2. s <= 1000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

		System.out.println(Arrays.toString(solution(N,stages)));
	}

	private static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		int[] succes = new int[N+2];
		int[] fail = new int[N+2];
		for (int i = 0; i < stages.length; i++) {
			for (int j = 1; j <= stages[i]; j++) {
				succes[j]++;
			}
			fail[stages[i]]++;
		}
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		for (int i = 1; i < N+1; i++) {
			if(succes[i] !=0) {
				q.add(new Point(i,(double)fail[i]/succes[i]));
			}else if(succes[i] == 0 && fail[i] ==0) {
				q.add(new Point(i,0));
			}else {
				q.add(new Point(i,1));
			}
		}
		
		for (int i = 0; i < N; i++) {
			answer[i] = q.poll().idx;
		}
		return answer;
	}
	static class Point implements Comparable<Point>{
		int idx;
		double cnt;

		public Point(int idx, double cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if(o.cnt == this.cnt)return this.idx - o.idx;
			return Double.compare(o.cnt, this.cnt);
		}
	}
}
