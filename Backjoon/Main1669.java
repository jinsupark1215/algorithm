package Backjoon;

import java.util.Scanner;

public class Main1669 {

	/*
	 * [백준] 멍멍이 쓰다듬기
	 * 
	 * 1. 원숭이와 멍멍이 키가 같아지게되는 최소 일수
	 * 
	 * 2. X,Y <= 2^31
	 * 
	 * 3. 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long monkey = sc.nextLong();
		long dog = sc.nextLong();
		
		long diff = (dog-monkey)/2;
		
		long idx = 1;
		int ans = 0;
		while(true) {
			diff -=idx;
			ans++;
			if(diff==0) {
				ans*=2;
				break;
			}else if(diff<0) {
				ans= (ans*2)-1;
				break;
			}
			idx++;
		}
		System.out.println(ans);
	}
}
