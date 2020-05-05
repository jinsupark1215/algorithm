package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14718 {

	/*
	 * [백준] 용감한 용사 진수
	 * 
	 * 1. 최소 스탯포인트
	 * 
	 * 2. N <= 100
	 * 
	 * 3. 조합 이용, 합의 최솟값 찾기 -> 시간초과
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Point[] arr = new Point[N];
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		 
		int cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				for (int k = 0; k < N; k++) {
					if(arr[k].str <= arr[i].str && arr[k].dex <= arr[j].dex)cnt++;
					
					if(cnt == K) {
						ans = Math.min(ans, arr[i].str+arr[j].dex+arr[k].luk);
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	static class Point implements Comparable<Point>{
		int str,dex,luk;

		public Point(int str, int dex, int luk) {
			super();
			this.str = str;
			this.dex = dex;
			this.luk = luk;
		}

		@Override
		public int compareTo(Point o) {
			return this.luk - o.luk;
		}
	}
}
