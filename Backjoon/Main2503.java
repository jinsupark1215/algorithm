package Backjoon;

import java.util.Scanner;

public class Main2503 {

	static int[][] map;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][5];
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int strike = sc.nextInt();
			int ball = sc.nextInt();
			
			map[i][0] = num/100;
			map[i][1] = (num/10)%10;
			map[i][2] = num%10;
			map[i][3] = strike;
			map[i][4] = ball;
			}

		/*
		 * 	1. 문제이해 : 숫자야구를 해서 답이 가능한 갯수 구하기
		 * 
		 * 	2. 제약 조건 : 서로 다른 수. 3자리
		 * 					자리와 숫자가 같으면 strike
		 * 					자리다르고 숫자 같으면 ball
		 * 
		 * 3. 로직 : 전체 수 찾아보고 중복되면 넘어가고 strike와 ball 체크.
		 */
		
		solve();
		System.out.println(solve());
		}
	private static int solve() {
		int answer = 0;
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(i == j) continue;
				for (int k = 1; k <= 9; k++) {
					if(i==k) continue;
					if(j==k) continue;
					
					boolean flag = true;
					for (int l = 0; l < n; l++) {
						int strike = 0;
						int ball = 0;
						
						//첫번째자리
						if(i == map[l][0]) {
							strike++;
						}else if(i == map[l][1] || i == map[l][2]) {
							ball++;
						}
						
						//두번째자리
						if(j == map[l][1]) {
							strike++;
						}else if(j == map[l][0] || j == map[l][2]) {
							ball++;
						}
						
						//세번째자리
						if(k == map[l][2]) {
							strike++;
						}else if(k == map[l][1] || k == map[l][0]) {
							ball++;
						}
						
						if(strike != map[l][3] || ball != map[l][4]) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						answer++;
					}
				}
			}
		} 
		return answer;
	}
}
