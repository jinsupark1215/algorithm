package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1111 {

	/*
	 * [백준] IQ test
	 * 
	 * 1. 다음 수 구하기
	 * 
	 * 2. N <= 50
	 * 
	 * 3. 크기가 1인경우 2인경우 그 나머지 경우
	 * 다음 수 한개인 경우 여러개인경우 없는경우
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 1) {
			System.out.println("A");
		}else if(N == 2) {
			if(arr[0] == arr[1])System.out.println(arr[0]);
			else System.out.println("A");
		}else {
			//1,2,3 숫자 대입하고 규칙 맞는지 찾기
			int a = 0;
			int b = 0;
			boolean flag = true;
			
			for (int i = 0; i < N-2; i++) {
				if(i == 0) {
					if(arr[i+1] - arr[i] == 0) {
						a = 0;
						b = arr[i+1];
					}else {
						a = (arr[i+2]-arr[i+1]) / (arr[i+1]-arr[i]);
						b = arr[i+1]- (arr[i]*a);
					}
				}
				
				if((arr[i]*a)+b != arr[i+1]) {
					flag = false;
					break;
				}
			}
			
			if(flag)System.out.println(arr[N-1]*a + b);
			else System.out.println("B");
		}
	}
}
