package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main10448 {

	/*
	 * [백준] 유레카 이론
	 * 1. 삼각수의 합은 1 아니면 0
	 * 
	 * 2.
	 * 
	 * 3. 완탐
	 */
	private static boolean[][] table;	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		table = new boolean[3][1001];
		int T;
		for (int i = 1; (T = i * (i + 1) / 2) < 1000; i++) {
			table[0][T] = true;
			for (int j = 1; j <= 2; j++) {
				for (int k = T + 1; k <= 1000; k++) {
					if (table[j - 1][k - T]) table[j][k] = true;
				}
			}
		}
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			if (table[2][Integer.parseInt(br.readLine())]) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		br.close();
		bw.close();
	}
}
