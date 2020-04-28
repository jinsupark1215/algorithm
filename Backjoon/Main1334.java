package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main1334 {

	/*
	 * [백준] 다음 팰린드롬 수
	 * 
	 * 1. N보다 큰 수중 가장작은 팰린드롬
	 * 
	 * 2. N <=50
	 * 
	 * 3. 해당 수보다 큰 팰린드롬은 앞에 반을 뒤집었을 경우와 다른 경우 찾기
	 * 빅인티저로 계산
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		if(num.equals("9")){
			System.out.println("11");
			return;
		}
		String pre = num.substring(0, num.length()%2==1?num.length()/2+1:num.length()/2);
		String post = num.substring(0, num.length()/2);
		String rev = new StringBuilder(post).reverse().toString();
		String output = pre + rev;
		
		if(num.compareTo(output) < 0) {
			//output이 더 클때
			System.out.println(pre + rev);
		}
		else {
			//number가 더 크거나 같을때
			BigInteger bigPre = new BigInteger(pre);
			bigPre = bigPre.add(new BigInteger("1"));
			String nextpre = bigPre.toString();
			String nextpost = "";
			
			if(num.length()%2==1) {
				nextpost = bigPre.toString().substring(0,bigPre.toString().length()-1);
			}else {
				nextpost = bigPre.toString();
			}
			
			if(nextpost.length()!=post.length()) {
				nextpost = nextpost.substring(0, nextpost.length() - 1);
			}
			String nextrev = new StringBuilder(nextpost).reverse().toString();
			System.out.println(nextpre + nextrev);
		}
	}
}
