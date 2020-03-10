package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1217 {

	/*
	 * 1. 거듭제곱을 구하라
	 * 
	 * 2. Integer 범위
	 * 
	 * 3. 구현
	 */
	
	static int n,m,ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ans =0;
			go(n,1);
			System.out.println("#"+ tc + " " + ans);
		}
	}

	private static void go(int num, int cnt) {
		if(cnt == m) {
			ans = num;
			return;
		}
		else {
			go(num*n,cnt+1);
		}
	}
}

