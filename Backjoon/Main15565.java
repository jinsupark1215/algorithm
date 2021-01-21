package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main15565 {

	/*
	 * [백준] 귀여운 라이언
	 * 
	 * 1. 연속된 인형의 집합 최소크기
	 * 
	 * 2. N,K <=10^6
	 * 
	 * 3. 1 사이의 갯수 세기
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
        int chk = 0;
        int tmp = 0;
        int first = -1;
        for (int i = 0; i < N; i++) {
            if (first >= 0) tmp++;
            if (arr[i]== 1) {
                if (first == -1) {
                    first = i;
                    tmp++;
                }
                chk++;
                if (chk == K) {
                    if (min > tmp) min = tmp;
                    while (first < i) {
                        tmp--;
                        first++;
                        if (arr[first]== 1) break;
                    }
                    chk--;
                }
            }
        }
		
		System.out.println(min == Integer.MAX_VALUE ? -1: min);
	}
}
