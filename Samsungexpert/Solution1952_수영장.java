package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1952_수영장 {

	/*
	 * 1. 수영장을 이용할 때 가장 적은 비용으로 이용하는 방법
	 * 
	 * 2.
	 * 
	 * 3. 완탐. dfs
	 */
	static int day, one, three, ans;
	static int[] plan;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			one = Integer.parseInt(st.nextToken());
			three = Integer.parseInt(st.nextToken());
			ans = Integer.parseInt(st.nextToken());
			plan = new int[12];
			visit = new boolean[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void dfs(int idx, int sum) {
		if(idx >= 12) {
			ans = Math.min(ans, sum);
			return;
		}
		
		if(plan[idx] == 0)dfs(idx+1, sum);
		else {
			dfs(idx+1, sum + day*plan[idx]);
			dfs(idx+1, sum + one);
			dfs(idx+3, sum+ three);
		}
	}
}
