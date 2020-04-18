package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main3671 {

	/*
	 * [백준] 산업스파이의 편지
	 * 
	 * 1. 만들수 있는 수가 소수인가
	 * 
	 * 2. c <= 200
	 * 
	 * 3. 소수를 구해 놓고 만들 수 있는 수 찾기
	 */
	static String N;
	static boolean[] num = new boolean[10000000];
	static boolean[] chk;
	static int[] order;
	static Set<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//소수
		num[0] = true;num[1] = true;
		for (int i = 2; i*i < 10000000; i++) {
			if(!num[i]) {
				for (int j = i*i; j < 10000000; j+=i) {
					num[j] = true;
				}
			}
		}
		set = new HashSet<>();
		for (int tc = 0; tc < T; tc++) {
			N = br.readLine();

			chk = new boolean[N.length()];
			order = new int[N.length()];
			go(0);
			
			System.out.println(set.size());
			set.clear();
		}
	}
	private static void go(int idx) {
		if(idx>= N.length()) {
			return;
		}
		
		for (int i = 0; i < N.length(); i++) {
			if(!chk[i]) {
				order[idx] = i;
				chk[i] = true;
				
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j <= idx; j++) {
					sb.append(N.charAt(order[j]));
				}
				if(!num[Integer.parseInt(sb.toString())])set.add(Integer.parseInt(sb.toString()));
				
				go(idx+1);
				chk[i] = false;
			}
		}
	}
}
