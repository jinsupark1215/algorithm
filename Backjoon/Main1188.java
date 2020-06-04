package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1188 {

	/*
	 * [백준] 음식 평론가
	 * 
	 * 1. 동일하게 소세지를 나눠주기 위해 최소의 칼질 수
	 * 
	 * 2. N,M <= 100
	 * 
	 * 3. 최대공약수 (GCD)
	 */
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		System.out.println(M-GCD(N,M));
	}

	private static int GCD(int n, int m) {
		if(n%m ==0)return m;
		return GCD(m,n%m);
	}
}
