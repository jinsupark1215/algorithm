package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main18427 {

	/*
	 * 1. H를 만들 수 있는 경우의 수
	 * 
	 * 2. N,M <=50, H <=1000
	 * 
	 * 3. 완탐 ( 시간초과 )
	 * -> dp
	 */
	static int N, M, H, ans;
	static ArrayList[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new ArrayList[N];
		int[] dp = new int[H+1];
		
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.hasMoreTokens()) {
					map[i].add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			Collections.sort(map[i]);
		}
		
		for (int i = 0; i < N; i++) {
			int[] arr = new int[H+1];
			for (int j = 0; j < map[i].size(); j++) {
					int num = (int) map[i].get(j);
					arr[num]++;
					for (int k = 1; k <= H; k++) {
						if(k+num > H)break;
						arr[num+k] += dp[k];
				}
			}
			for (int j = 1; j <= H; j++) {
				dp[j] += arr[j];
				dp[j] %= 10007;
			}
		}
		
		System.out.println(dp[H]);
	}

}
