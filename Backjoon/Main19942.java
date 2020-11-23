package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main19942 {

	/*
	 * [백준] 다이어트
	 * 
	 * 1. 최소비용으로 만들 수 있는 경우
	 * 
	 * 2. N <=15
	 * 
	 * 3. 완탐
	 */
	static int N, a,b,c,d,ans;
	static boolean[] visit;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][5];
		ans = 100000;
		sb = new StringBuilder();
		sb.append(-1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
			map[i][3] = Integer.parseInt(st.nextToken());
			map[i][4] = Integer.parseInt(st.nextToken());
		}
		
		visit = new boolean[N];
		for (int i = 1; i <= N; i++) {
			nCr(0,0,i,0,0,0,0,0);
		}
		System.out.println(sb.toString());
	}
	private static void nCr(int idx, int cnt, int chk,int suma, int sumb, int sumc, int sumd, int sum) {
			System.out.println(Arrays.toString(visit));
			if (suma >= a && sumb >= b && sumc >= c && sumd >= d && ans > sum) {

				sb = new StringBuilder();
				ans = sum;
				sb.append(ans + "\n");
				for (int i = 0; i < N; i++) {
					if (visit[i])
						sb.append(i + 1+ " ");
				}
				return;
			}
		
		for (int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				nCr(i+1,cnt+1,chk,suma +map[i][0],sumb +map[i][1],sumc +map[i][2],sumd +map[i][3],sum +map[i][4]);
				visit[i] = false;
			}
		}
	}
}
