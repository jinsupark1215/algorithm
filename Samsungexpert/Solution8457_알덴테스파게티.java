package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8457_알덴테스파게티 {

	/*
	 * 1. 구입해도 되는 모래시계 갯수
	 * 
	 * 2. N<=100, B <=1440 , E <10^4
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				for (int j = B-E; j <= B+E; j++) {
					if(j%num == 0) {
						cnt++;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
