package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2406 {

	/*
	 * [백준] 안정적인 네트워크 
	 * 1. i, j 컴퓨터를 연결할 때 드는 비용
	 * 
	 * 2. n <=1000
	 * 
	 * 3. 최소스패닝 트리(크루스칼)
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] input = new int[m][2];
		int[][] computer = new int[n][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				computer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
}
