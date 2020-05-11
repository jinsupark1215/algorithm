package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_까까오3 {

	/*
	 * 1. 모든 종류의 물건을 1개이상포함하는 것
	 * 
	 * 2. gems 1~100,000
	 * 
	 * 3. 슬라이딩 윈도우,
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
//		String[] gems = {"AA", "BB", "CC", "CC", "AA", "AA","BB", "CC"};
//		String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };

		System.out.println(Arrays.toString(solution(gems)));
	}

	private static int[] solution(String[] gems) {
		int[] ans = new int[2];

		Set<String> set = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < gems.length; i++) {
			set.add(gems[i]);
			map.put(gems[i], 0);
		}
		int max = set.size();

		int size = 0;
		int length = 0;
		int left = 0;
		int right = 0;
		int cnt = Integer.MAX_VALUE;

		//오른쪽
		while (true) {
			if (size == max) {
				//왼쪽
				while (true) {

					if (map.get(gems[left]) == 1) {
						map.put(gems[left], map.get(gems[left]) - 1);
						size--;

						if ((right - left - 1) < cnt) {
							ans[0] = left;
							ans[1] = right;
						}

						cnt = Math.min(cnt, (right - left - 1));
						left++;
						break;
					} else {
						map.put(gems[left], map.get(gems[left]) - 1);
						cnt = Math.min(cnt, (right - left - 1));

						if ((right - left - 1) < cnt) {
							ans[0] = left;
							ans[1] = right;
						}

						left++;
					}
				}
			} // end

			if (right == gems.length) {
				break;
			}

			map.put(gems[right], map.get(gems[right]) + 1);
			if (map.get(gems[right]) - 1 == 0) {
				size++;
			}
			right++;

			length++;
		} // end

		ans[0]++;
		return ans;

	}
}
