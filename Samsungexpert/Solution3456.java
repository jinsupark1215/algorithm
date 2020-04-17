package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3456 {

	/*
	 * [삼성] 직사각형 길이 찾기
	 * 
	 * 1. 나머지 한 변의 길이
	 * 
	 * 2. a,b,c <=100
	 * 
	 * 3. 찾기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == b) {
				System.out.println("#"+ tc + " " +c);
			}else if(a==c){
				System.out.println("#" + tc + " " + b);
			}else {
				System.out.println("#" + tc + " " + a);
			}
		}
	}
}
