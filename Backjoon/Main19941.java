package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main19941 {

	/*
	 * [백준] 햄버거 분배
	 * 
	 * 1. 최대 많이 먹을 수 있는 사람수
	 * 
	 * 2. N <=20000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String input = br.readLine();
		boolean[] visit= new boolean[N];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			if(input.charAt(i) == 'P') {
				for (int j = i-K; j <= i+K; j++) {
					if(0<=j && j < N && input.charAt(j) == 'H' && !visit[j]) {
						visit[j] = true;
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
