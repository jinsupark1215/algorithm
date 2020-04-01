package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main18310 {

	/*
	 * 1. 거리의 합이 최소가 되는 경우
	 * 
	 * 2. N <=200,000
	 * 
	 * 3. dp? 이분탐색 ?
	 */
	static int N,ans;
	static int[] arr,cnt;
	static PriorityQueue<Point> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		arr = new int[N];
		cnt = new int[100001];
		q = new PriorityQueue<>();
		boolean flag = true;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			cnt[num]++;
			if(cnt[num] >1)flag = false;
		}
		
		if (flag) {
			Arrays.sort(arr);
			if (N % 2 == 0) {
				ans = arr[(N / 2) - 1];
			} else {
				ans = arr[N / 2];
			}
		} else {
			for (int i = 0; i <= 100000; i++) {
				if(cnt[i] >1)go(i);
			}
			ans = q.poll().idx;
		}
		System.out.println(ans);
	}

	private static void go(int idx) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Math.abs(arr[i]-idx);
		}
		q.add(new Point(idx,sum));
	}
	static class Point implements Comparable<Point>{
		int idx, sum;

		public Point(int idx, int sum) {
			super();
			this.idx = idx;
			this.sum = sum;
		}

		@Override
		public int compareTo(Point o) {
			return this.sum - o.sum;
		}
	}
}
