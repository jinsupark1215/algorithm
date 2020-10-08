package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1238 {

	/*
	 * [백준] 파티
	 * 
	 * 1. N명의 학생들 중 오고가는데 가장 오래걸리는 소요시간
	 * 
	 * 2. N <=1000, M<= 10000
	 * 
	 * 3. 플로이드 와샬
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		//먼저 계산을 위해 무한대값으로 셋팅
		for(int[] data: map) {
			Arrays.fill(data, 100000000);
		}
		
		//자신과 자신으로 가는 길은 0
		for(int i=0; i<N+1; i++) {
			map[i][i]=0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[start][end]=w;
		}
		
		//1부터 하는 이유는 1이 시작점이기 때문
		for(int mid=1; mid<N+1; mid++) {
			for(int start=1; start<N+1; start++) {
				for(int end=1; end<N+1; end++) {
					map[start][end]=Math.min(map[start][end], map[start][mid]+map[mid][end]);
				}
			}
		}
		
		int result = 0;
		//자신의 집에서 X를 들렸다가 다시 자신의 집으로 가야되니까
		for(int i=1; i<N+1; i++) {
			result = Math.max(map[i][X]+map[X][i], result);
		}
		System.out.println(result);
		
	}
}
