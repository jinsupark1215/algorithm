package Backjoon;

import java.util.Scanner;

public class Main14712 {

	/*
	 * [백준] 넴모넴모
	 * 
	 * 1. 넴모를 이루지 않는 배치의수
	 * 
	 * 2. N,M <= 25
	 * 
	 * 3. 총 가짓수에서 네모 가짓수 뺴기
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 1;
		for (int i = 0; i < N*M; i++) {
			ans *= 2;
		}
		
	}
}
