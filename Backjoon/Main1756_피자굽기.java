package Backjoon;

import java.util.Scanner;

public class Main1756_피자굽기 {

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
	 * 3-1 뒤부터 시작 ( 수정 )
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int D = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[D];
		int[] pizza = new int[D];
		int maxarr = 0;
		int maxpizza = 0;
		for (int i = 0; i < D; i++) {
			arr[i] = sc.nextInt();
			maxarr = Math.max(maxarr, arr[i]);
		}
		for (int i = 0; i < N; i++) {
			pizza[i] = sc.nextInt();
			maxpizza = Math.max(maxpizza, pizza[i]);
		}
		int ans =-1;
		int tmp = 0;
		int idx = N-1;
		//최고보다 크면 다 안들어가지므로 끝내기 
		if(maxpizza > maxarr)System.out.println(0);
		else {
		//맨 끝의 숫자보다 가장 큰곳 찾기
		for (int j = 0; j < D; j++) {
			if(pizza[N-1] >arr[j]) {
				ans = j-1;
				tmp = j;
				break;
			}
		}
		
		//만약 못찾았으면 없는 것이므로 0
		if(ans == -1)System.out.println(0);
		else {
			//그 전에 몇개가 쌓여있는지 판단
			for (int i = N-2; i >=0 ; i--) {
				if(pizza[i] > arr[tmp]) {
					ans -= idx - i;
					idx = i;
				}else;//없으면 종료
			}
			//맨 위보다 더내려갔으면 가장 위이므로 1
			if(ans < 1)System.out.println(1);
			else System.out.println(ans+1);
		}
		}
	}
}
