package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2696 {

	/*
	 * [백준] 중앙값 구하기
	 * 
	 * 1. 중앙값 개수와 중앙값 구하기
	 * 
	 * 2. 
	 * 
	 * 3. 정렬 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> list;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			list = new ArrayList<Integer>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			sb.append(((N/2)+1) + "\n");
			for (int j = 0; j < N; j++) {
				if(j !=0 && j%10 ==0)st = new StringTokenizer(br.readLine());
				
				if(j%2==0) {
					list.add(Integer.parseInt(st.nextToken()));
					Collections.sort(list);
					sb.append(list.get(j/2) + " ");
				}else {
					list.add(Integer.parseInt(st.nextToken()));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
