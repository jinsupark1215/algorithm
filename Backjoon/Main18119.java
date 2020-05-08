package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18119 {

	/*
	 * [백준] 단어 암기
	 * 
	 * 1. 단어를 기억하는지?
	 * 
	 * 2. N <= 1000, M <= 50000
	 * 
	 * 3. 1은 잊고 2는 기억
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N][26];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				arr[i][input.charAt(j) - 'a'] = true;
			}
		}
		
		int ans = N;
		boolean[] flag = new boolean[N];
		int[] cnt = new int[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			char x = st.nextToken().charAt(0);
			
			if(o == 1) {
				for (int j = 0; j < N; j++) {
					if(arr[j][x-'a']) {
						cnt[j]++;
						if(!flag[j]) {
							ans--;
						}
						flag[j] = true;
					}
				}
			}
			else {
				for (int j = 0; j < N; j++) {
					if(flag[j] && arr[j][x-'a']) {
						cnt[j]--;
						if(cnt[j] == 0) {
						flag[j] = false;
						ans++;
						}
					}
				}
			}
			
			System.out.println(ans);
		}
	}
}
