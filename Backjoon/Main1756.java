package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1756 {

	/*
	 * 1. 마지막 피자 위치를 구하라.
	 * 
	 * 2. 1<=D,N <= 300000
	 * 
	 * 3. 
	 * 3-1.반죽의 배열 arr[], 피자가 들어가면 pizza[]
	 * 3-2. 피자반죽이 배열의 숫자보다 작으면  그 전 인덱스를 트루로 만들어주고
	 * 3-3. 0번쨰부터 true인 것을 찾으면 끝
	 * -> 시간초과
	 * 
	 * 3-1. 오븐 크기를 전것과 비교해서 작은것만 넣는다
	 * 3-2. 피자를 넣으면서 해당 위치 저장
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] oven = new int[D];
		int[] pizza = new int[N];
		
		//작은 것과 비교해서 어짜피 못들어가기 떄문에 작은 값 저장
		st = new StringTokenizer(br.readLine());
		oven[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < D; i++) {
			oven[i] = Math.min(oven[i-1], Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx =0;
		int ans = 0;
		
		for (int i = D-1; i >=0; i--) {
			if(oven[i] >= pizza[idx]) {
				idx++;
			}
			
			if(idx == N) {
				ans = i+1;
				break;
			}
		}
		
		System.out.println(ans);
	}
}

