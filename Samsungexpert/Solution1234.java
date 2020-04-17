package Samsungexpert;

import java.util.Scanner;

public class Solution1234 {

	/*
	 * [삼성] 비밀번호
	 * 
	 * 1. 비밀번호 찾기
	 * 
	 * 2. N <=100
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N =sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append(sc.next());
			
			while(true) {
				boolean flag = false;
				int length = sb.length();
				for (int j = 0; j < length-1; j++) {
					if(sb.charAt(j) == sb.charAt(j+1)) {
						sb.delete(j, j+2);
						flag = true;
						break;
					}
				}
				if(!flag)break;
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
