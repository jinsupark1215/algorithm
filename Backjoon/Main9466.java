package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9466 {

	/*
	 * [백준] 팀 프로젝트
	 * 
	 * 1. 팀에 속하지 못한 수
	 * 
	 * 2. N <= 100000
	 * 
	 * 3. dfs
	 */
	static int N, cnt;
	static int[] arr;
	static boolean[] visit, fin;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			arr = new int[N+1];
			visit = new boolean[N+1];
			fin = new boolean[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				if(!fin[i]) {
					dfs(i);
				}
			}
			System.out.println(N-cnt);
		}
	}

	private static void dfs(int idx) {
		if(visit[idx]) {
			fin[idx] = true;
			cnt++;
		}else visit[idx] = true;
		
		if(!fin[arr[idx]])dfs(arr[idx]);
		
		visit[idx] =false;
		fin[idx] = true;
		
	}
}
