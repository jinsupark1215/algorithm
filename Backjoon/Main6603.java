package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {

	/*
	 * [백준] 로또
	 * 
	 * 1. 수를 고르는 모든 방법
	 * 
	 * 2. 
	 * 
	 * 3. 조합짜기
	 */
	static int N;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			arr= new int[N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			nCr(0,0);
			
			System.out.println();
		}
		
	}

	private static void nCr(int idx, int cnt) {
		if(cnt == 6) {
			for (int i = 0; i < N; i++) {
				if(visit[i])System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				nCr(i,cnt+1);
				visit[i] = false;
			}
		}
	}
}
