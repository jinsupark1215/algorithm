package Backjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1593 {

	/*
	 * [백준] 문자해독
	 * 
	 * 1. 문자열이 있는지 확인
	 * 
	 * 2. g<=3000, S <=30000000
	 * 
	 * 3. 갯수가 같은지 판단 
	 */
	static int g,s,ans;
	static String W,S;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = sc.nextInt();
		s = sc.nextInt();
		W = sc.next();
		S = sc.next();
		ans= 0;
		
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		
		for (int i = 0; i < g; i++) {
			if(!map1.containsKey(W.charAt(i))) {
				map1.put(W.charAt(i), 1);
			}else {
				map1.replace(W.charAt(i), map1.get(W.charAt(i))+1);
			}
			if(!map2.containsKey(S.charAt(i))) {
				map2.put(S.charAt(i), 1);
			}else {
				map2.replace(S.charAt(i), map2.get(S.charAt(i))+1);
			}
		}
		
		if(map1.equals(map2))ans++;
		for (int i = g; i < s; i++) {
			if(map2.get(S.charAt(i-g)) == 1)map2.remove(S.charAt(i-g));
			else map2.replace(S.charAt(i-g), map2.get(S.charAt(i-g))-1);
			
			if(!map2.containsKey(S.charAt(i))) {
				map2.put(S.charAt(i), 1);
			}else {
				map2.replace(S.charAt(i), map2.get(S.charAt(i))+1);
			}
			if(map1.equals(map2))ans++;
		}
		
		System.out.println(ans);
	}

}
