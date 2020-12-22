package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13305 {

	/*
	 * [백준] 주유소
	 * 
	 * 1. 최소비용찾기 
	 * 
	 * 2. 10억
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dis = new long[N-1];
		long[] fuel = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			int d = Integer.parseInt(st.nextToken());
			dis[i] = d;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int f = Integer.parseInt(st.nextToken());
			fuel[i] = f;
		}
		
		long p = dis[0]*fuel[0];
		int cur = 0;
		int next = 1;
		
		while(next < N-1) {
			if(fuel[cur] < fuel[next]) {
				p += fuel[cur] * dis[next];
			}else {
				p += fuel[next] * dis[next];
				cur = next;
			}
			next++;
		}
		System.out.println(p);
	}
}
