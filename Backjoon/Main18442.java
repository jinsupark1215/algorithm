package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18442 {

	/*
	 * [백준] 우체국
	 * 
	 * 1. 거리의 최솟값과 우체국을 지을 마을을 고르는 법
	 * 
	 * 2. P,V <=20, L < 10^12
	 * 
	 * 3. 조합 돌려서 최솟값 찾고 그 배열 반환
	 */
	static int V,P;
	static long ans,L;
	static long[] arr;
	static boolean[] chk;
	static boolean[] ansarr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		ans = Long.MAX_VALUE;
		arr = new long[V];
		chk = new boolean[V];
		ansarr = new boolean[V];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Combi(0,0);
		
		System.out.println(ans);
		for (int i = 0; i < V; i++) {
			if(ansarr[i])System.out.print(arr[i] + " ");
		}
	}

	private static void Combi(int idx, int cnt) {
		if(cnt == P) {
			long tmp = go();
			if(ans > tmp) {
				ans = tmp;
				for (int i = 0; i < V; i++) {
					ansarr[i] = chk[i];
				}
			}
			return;
		}
		
		for (int i = idx; i < V; i++) {
			if(!chk[i]) {
				chk[i] = true;
				Combi(i+1,cnt+1);
				chk[i] = false;
			}
		}
	}

	private static long go() {
		long sum = 0;
		for (int i = 0; i < V; i++) {
			long min = Long.MAX_VALUE;
			for (int j = 0; j < V; j++) {
				if(chk[j]) {
					min = Math.min(min, Math.min(Math.abs(arr[i] - arr[j]), L-Math.abs(arr[i] - arr[j])));
				}
			}
			sum += min;
		}
		return sum;
	}
}
