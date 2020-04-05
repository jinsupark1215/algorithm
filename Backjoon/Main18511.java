package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main18511 {

	/*
	 * 1. K의 원소로만 구성된 가장 큰 수
	 * 
	 * 2. N <=100000000
	 * 
	 * 3. 포함됬나안됬나 확인
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = n; i >=0; i--) {
			boolean flag = true;
			int num = i;
			while(num !=0) {
				if(!list.contains(num%10)) {
					flag = false;
					break;
				}
				else num/=10;
			}
			if(flag) {
				n = i;
				break;
			}
		}
		System.out.println(n);
	}
}
