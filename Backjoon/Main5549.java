package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main5549 {

	/*
	 * 1. 정글,바다,얼음 의 개수
	 * 
	 * 2. N,M <= 1000, K <=100000
	 * 
	 * 3. 구현
	 */
	static int N,M,K;
	static int[][][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new int[M+1][N+1][3];
		
		for (int i = 1; i <= M; i++) {
			String input = br.readLine();
			for (int j = 1; j <= N; j++) {
				if( input.charAt(j-1) == 'J') {
					map[i][j][0] = 1;
				}else if( input.charAt(j-1) == 'O') {
					map[i][j][1] = 1;
				}else if( input.charAt(j-1) == 'I') {
					map[i][j][2] = 1;
				}
				
				for (int k = 0; k < 3; k++) {
					map[i][j][k] += map[i-1][j][k] + map[i][j-1][k] - map[i-1][j-1][k];
				}
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken())-1;
			int sc = Integer.parseInt(st.nextToken())-1;
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 3; j++) {
				bw.write(map[er][ec][j] - map[er][sc][j] - map[sr][ec][j] + map[sr][sc][j] + " ");
			}
			bw.newLine();
		}
		bw.flush();
	}
}

