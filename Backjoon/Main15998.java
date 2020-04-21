package Backjoon;

import java.util.Scanner;

public class Main15998 {

	/*
	 * [백준] 카카오머니
	 * 
	 * 1. 최소 충전단위가 될수 있는 수
	 * 
	 * 2. M <= 9 * 10^18
	 * 
	 * 3. 
	 * 최대 공약수 이용 
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long g = 0, a, b, newa, newb = 0, maxg = -1;
		for(int i = 0; i < N; i++){
			a = sc.nextLong();
			b = sc.nextLong();
			
			//음수거나 잔고보다 큰경우 -> 충전이 필요한 경우
			if(a < 0 && -a > newb){
				long tmp = -a + b - newb;
				g = gcd(tmp, g);
				if(b > maxg) maxg = b;
			}else if(newb + a != b) g = -1;
			
			newa = a;
			newb = b;
		}

		if(g == 0) g = 1;
		System.out.println(g > maxg ? g : -1);
	}
	
	public static long gcd(long a, long b){
		long c;
		while(b != 0){
			c = a;
			a = b;
			b = c % b;
		}
		return a;
	}
}
