package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1920 {

	/*
	 * 1. M의 숫자가 N에 있는지 찾는 프로그램
	 * 
	 * 2. N,M은 100000 이하
	 * 
	 * 3. Map 이용
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Boolean> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), true);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if(map.containsKey(Integer.parseInt(st.nextToken()))) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
}
