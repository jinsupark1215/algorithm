package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17845 {

	/*
	 * 1. 공부시간을 최대로해서 얻을 수 있는 최대 중요도를 구하라
	 * 
	 * 2. N < 10000, K < 1000
	 * 
	 * 3. 조합을 통해서 최대 공부시간 완탐(시간초과) ->X
	 * 
	 * dfs 탐색(시간초과) -> X
	 * 
	 * dp 활용(Knapsack) 배낭 알고리즘 이용;
	 */
	public static void main(String[] args) throws IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n,k,m,c;
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	n = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());
	int[] cost = new int[n+1];
	while(k-->0) {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		for(int i=n;i>=c;i--){
			cost[i] = Math.max(cost[i], cost[i-c]+m);
		}
	}
	System.out.println(cost[n]);
	}
}
