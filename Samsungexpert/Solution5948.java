package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution5948 {

	/*
	 * 1. 7개의 숫자중 3개의 합이 5번째로 큰 수 찾기
	 * 
	 * 2. 서로 다른 수
	 * 
	 * 3. boolean 배열 이용해서 중복 제거 5번째 수 찾기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int[] map = new int[7];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] ans = new boolean[700];
			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 6; j++) {
					for (int k = j + 1; k < 7; k++) {
						ans[map[i] + map[j] + map[k]] = true;
					}
				}
			}
			int idx = 0;
			for (int i = 699; i >= 0; i--) {
				if (ans[i]) {
					idx++;
				}
				if (idx == 5) {
					System.out.println("#" + testcase + " " + i);
					break;
				}
			}
		}
	}
}
