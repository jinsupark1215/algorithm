package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main2957 {

	/*
	 * [백준] 이진탐색트리
	 * 
	 * 1. cnt 출력
	 * 
	 * 2. N <=300,000
	 * 
	 * 3. TreeSet 이용
	 * 각 num보다 작은 수와 큰수의 tree차수에 +1했을때 더 깊은 애를 찾는다
	 * 차수만큼 cnt를 더해줌
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Integer> tree = new TreeSet<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] height = new int[N+2];
		height[0] = -1;
		height[N+1] = -1;
		// 양 끝을 -1처리
		
		tree.add(0);
		tree.add(N+1);
		long cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			height[num] = Math.max(height[tree.lower(num)] + 1, height[tree.higher(num)] + 1);
			cnt += height[num];
			tree.add(num);
			sb.append(cnt).append('\n');
		}
		System.out.println(sb.toString());
	}
}
