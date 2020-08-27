package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main19583 {

	/*
	 * [백준] 싸이버개강총회
	 * 
	 * 1. 출석확인수
	 * 
	 * 2. 
	 * 
	 * 3. point :  중복제거 및 언제 끝낼것인지 
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int open = Integer.parseInt(sc.next().replace(':', '0'));
		int close = Integer.parseInt(sc.next().replace(':', '0'));
		int finsh = Integer.parseInt(sc.next().replace(':', '0'));
		Map<String, Boolean> map = new HashMap<>();
		int ans = 0;
		
		while(sc.hasNext()) {
			int enter = Integer.parseInt(sc.next().replace(':', '0'));
			String name = sc.next();
			
			if(enter <= open && !map.containsKey(name)) {
				map.put(name, false);
			}else if(close <= enter && enter <= finsh && map.containsKey(name) && !map.get(name)) {
				ans++;
				map.remove(name);
			}
		}
		System.out.println(ans);
	}
}
