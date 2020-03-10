package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main5568{

	/*
	 * 1. 만들 수 있는 숫자의 수
	 * 
	 * 2. 4<= n <=10, 2<=k<=4
	 * 
	 * 3. 조합을 통해 만들 수 있는 수의 갯수 set 사용
	 */
	static int n, k;
	static int[] arr;
	static boolean[] visit;
	static Set<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		set = new HashSet<>();
		
		nCr(0,0,"");
		System.out.println(set.size());
	}
	private static void nCr(int idx, int cnt, String s) {
		if(cnt == k) {
//			System.out.println(Arrays.toString(visit));
			set.add(s);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {				
			visit[i] = true;
			nCr(i,cnt+1,s+arr[i]);
			visit[i] = false;
			}
		}
	}
}

