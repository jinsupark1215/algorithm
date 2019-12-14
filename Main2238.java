package Backjoon;

import java.util.Scanner;

public class Main2238 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u = sc.nextInt();
		int n = sc.nextInt();
		int answer =0;
		String[] name = new String[n];
		int[] money = new int[n];
		int[] chk = new int[u+1];
		
		for (int i = 0; i < n; i++) {
			name[i] = sc.next();
			int num = sc.nextInt();
			money[i] = num;
			chk[num]++;
		}
		/*
		 * 1. 경매 낙찰된 사람과 금액 출력
		 * 
		 * 2. (중복이 없을 떄)1개의 가격을 제시한 사람 중 가장 작은 금액을 제시한 사람이 낙찰
		 * 		(중복이 있을 때) 가장 적은 중복의 숫자 중 가장 먼저 낙찰한 사람
		 * 
		 * 3. if 문 처리 (구현)
		 */
		int one = 0;
		int many = Integer.MAX_VALUE;
		for (int i = 0; i < u+1; i++) {
			if(chk[i] == 1) {
				one++;
			}else if(chk[i] >1) {
				many = many>chk[i]?chk[i]:many;
			}
		}
		
		if(one >0) {
			fin:
			for (int i = 0; i < u+1; i++) {
				if(chk[i] == 1) {
					for (int j = 0; j < n; j++) {
						if (i == money[j]) {
							System.out.println(name[j] + " " + money[j]);
							break fin;
						}
					}
				}
			}
		}else {
			fin:
			for (int i = 0; i < u+1; i++) {
				if(chk[i] == many) {
					for (int j = 0; j < n; j++) {
						if (i == money[j]) {
							System.out.println(name[j] + " " + money[j]);
							break fin;
						}
					}
				}
			}
		}
	}
}
