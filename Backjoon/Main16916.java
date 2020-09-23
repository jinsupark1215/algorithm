package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16916 {

	/*
	 * [백준] 부분 문자열
	 * 1. 문자열 안에 포함되는지 안되는지
	 * 
	 * 2. 백만 넘지 않음
	 * 
	 * 3. KMP 개념으로 풀기 : 인덱스 이용
	 */
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String tmp = br.readLine();
		
		kmp(origin,tmp);
		System.out.println(ans);
		
	}

	static void kmp(String origin, String tmp) {
		int[] pi = getPi(tmp);
		int j=0;
		for(int i=0;i<origin.length();i++) {
			while(j>0 && origin.charAt(i)!=tmp.charAt(j)) {
				j=pi[j-1];
			}
			if(origin.charAt(i)==tmp.charAt(j)) {
				if(j==tmp.length()-1) {
					ans=1;
					break;
				}
				else
					j++;
			}
		}
	}
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j=0;
		for(int i=1;i<pattern.length();i++) {
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i)==pattern.charAt(j)) 
				pi[i] = ++j;
		}
		return pi;
	}
	
}
