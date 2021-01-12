package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2812 {

	/*
	 * [백준] 크게만들기
	 * 
	 * 1. K개 지워을 떄 얻을수 있는 가장큰 수
	 * 
	 * 2. N<=500000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		String line = br.readLine();
		
		for (int i = 0; i < N; i++) {
			arr[i] = line.charAt(i) - '0';
		}
		
		int max = 0, idx = 0;
		for (int i = 0; i < N - K; i++) {
			max = 0;
			for (int j = idx; j <= K + i; j++) {
				if (arr[j] > max) {
					max = arr[j];
					idx = j;
					if (max == 9) {
						break;
					}
				}
			}
			idx++;
			sb.append(max);
		}
		bw.write(sb.append('\n').toString());
		bw.close();
	}
}
