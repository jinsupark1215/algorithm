package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7964 {

	/*
	 * [부먹왕국의 차원이동]
	 * 1. 차원관문의 최소 갯수
	 * 
	 * 2. N <= 300,000
	 * 
	 * 3. 1과 1사이의 거리동안의 0의 갯수/D 를 더해줌
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i] == 0) {
				cnt++;
			}else if(arr[i] == 1 && cnt>0) {
				ans+= cnt/D;
				cnt = 0;
			}else continue;
		}
		if(ans == 0)ans = cnt/D;
		
		System.out.println("#" + tc + " " + ans);
		}
	}
}
