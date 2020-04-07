package Samsungexpert;

import java.util.Scanner;

public class Solution3752 {

	/*
	 * [삼성] 가능한 시험점수
	 * 
	 * 1. 가능한 시험점수의 경우의 수
	 * 
	 * 2. N<= 100
	 * 
	 * 3. dp
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			boolean[] num = new boolean[10001];
			num[0] = true;
			int cnt = 1;
			int max = 0;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				for (int j = max; j >= 0; j--) {
					if (num[j] && !num[j + a]) {
						num[j + a] = true;
						cnt++;
					}
				}
				max += a;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
