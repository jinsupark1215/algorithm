package Backjoon;

import java.util.Scanner;

public class Main6588 {

	/*
	 * [백준] 골드바흐의 추측
	 * 
	 * 1. 소수로 식을 만들기
	 * 
	 * 2. N <= 10000000
	 * 
	 * 3. 체를 이용해 소수를 구한뒤 가능한지 판단
	 */
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	    	
	        boolean[] num = new boolean[1000000+1];
	        
	        for(int i = 2; i <= 1000000; i++) {
	            for(int j = i * 2; j <= 1000000; j += i) {
	                if(num[j]) continue;
	                num[j] = true;
	            }
	        }
	    	
	        while(true) {
	            int n = sc.nextInt();
	            boolean ok = false;
	            if(n == 0)
	                break;
	            for(int i = 2; i <= n/2; i++) {
	                if(!num[i] && !num[n-i]) {
	                    System.out.println(n + " = " + i + " + " + (n-i));
	                    ok = true;
	                    break;
	                }
	            }
	            if(!ok)
	                System.out.println("Goldbach's conjecture is wrong.");
	        }
	    }
}
