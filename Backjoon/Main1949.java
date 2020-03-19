package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1949 {

	/*
	 * [백준] 우수마을
	 * 1. 우수마을 주민 수의 최대 총합?
	 * 
	 * 2. N <=10,000
	 * 
	 * 3. dfs탐색 통해 최댓값
	 */
	static int n, visited[], city[];
	static long dp[][];
	static ArrayList<Integer> arr[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		city = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		//인접리스트
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		visited = new int[n+1];
		dp = new long[n+1][2];
		dfs(1);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	static void dfs(int p) {
		visited[p] = 1;
		dp[p][0] = 0;
		dp[p][1] = city[p];
		for(int c : arr[p]) {
			if(visited[c]==0) {
				dfs(c);
				dp[p][0] += Math.max(dp[c][0], dp[c][1]);
				dp[p][1] += dp[c][0];
			}
		}
	}
}
