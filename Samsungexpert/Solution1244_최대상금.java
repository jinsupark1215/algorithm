package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1244_최대상금 {

	/*
	 * 1. 횟수만큼 바꿧을 때 최대인 상금 금액.
	 * 
	 * 2. 바뀐 횟수가 꼭 n만큼이어야 함
	 * 
	 * 3. 조합 문제(자기자신은 선택되면 안됨)
	 */
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] num = st.nextToken().toCharArray();
			int n = Integer.parseInt(st.nextToken());
			answer = 0;

			dfs(num, n, 0);

			System.out.println("#" + testcase + " " + answer);
		}
	}

	// 바꿀 두가지를 선택하고 체크
	private static void dfs(char[] num, int n, int idx) {

		if (n == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < num.length; i++) {
				sb.append(num[i]);
			}
			answer = Math.max(answer, Integer.parseInt(sb.toString()));
			return;
		} 
		

		for (int i = idx; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				if (num[i] <= num[j]) {
					swap(num,i,j);
					dfs(num, n-1, i);
					swap(num,i,j);
				}
				
			}
		}

	}

	// 선택된 두가지 위치를 바꾸는 함수
	private static void swap(char[] num, int idx1, int idx2) {
		char tmp = num[idx1];
		num[idx1] = num[idx2];
		num[idx2] = tmp;

	}
}
