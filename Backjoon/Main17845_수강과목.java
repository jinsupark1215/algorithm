package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17845_수강과목 {

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
	static int N, K;
	static Study[] study;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		study = new Study[K+1];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			study[i] = new Study(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int[][] arr = new int[K+1][N+1];
		
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if(study[i].time > j)
					arr[i][j] = arr[i-1][j];
				else {
					arr[i][j] = Math.max(study[i].important + arr[i-1][j-study[i].time], arr[i-1][j]);
				}
			}
		}
		
		System.out.println(arr[K][N]);
	}
	static class Study{
		int important, time;

		public Study(int important, int time) {
			super();
			this.important = important;
			this.time = time;
		}
	}
}
