package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2096 {

	/*
	 * [백준] 내려가기
	 * 
	 * 1. 최대점수와 최소 점수
	 * 
	 * 2. N <=100,000
	 * 
	 * 3. dp이용
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] max = new int[N][N];
		int[][] min = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			max[0][i] = min[0][i] = map[0][i];
		}
		
		int a =0,b=0,c=0,tmpmax=0,tmpmin=0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N; j++) {
				if(j ==0) {
					a = map[i+1][j];
					b = map[i+1][j+1];
					if(a>=b) {
						max[i+1][j] =max[i][j] +a;
						min[i+1][j] =min[i][j] + b; 
					}else {
						max[i+1][j] =max[i][j] +b;
						min[i+1][j] = min[i][j] +a; 
					}
				}else if(j == N-1) {
					a = map[i+1][j-1];
					b = map[i+1][j];
					if(a>=b) {
						max[i+1][j] =max[i][j] +a;
						min[i+1][j] = min[i][j] +b; 
					}else {
						max[i+1][j] =max[i][j] +b;
						min[i+1][j] = min[i][j] +a; 
					}
				}else {
					a = map[i+1][j-1];
					b = map[i+1][j];
					c = map[i+1][j+1];
					tmpmax = Math.max(a, Math.max(b, c));
					tmpmin = Math.min(a, Math.min(b, c));
						max[i+1][j] =max[i][j] +tmpmax;
						min[i+1][j] = min[i][j] +tmpmin; 
				}
			}
		}
		tmpmax = 0; tmpmin=Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			tmpmax = Math.max(tmpmax, max[N-1][i]);
			tmpmin = Math.min(tmpmin, min[N-1][i]);
		}
		System.out.println(tmpmax + " " + tmpmin);
	}
}
