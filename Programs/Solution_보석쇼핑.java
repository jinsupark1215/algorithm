package Programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_보석쇼핑 {

	/*
	 * [카카오] 보석쇼핑 1. 한가지씩 포함하는 가장 짧은 구간
	 * 
	 * 2. gems <= 100000
	 * 
	 * 3.
	 */
	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		System.out.println(Arrays.toString(solution(gems)));
	}

	private static int[] solution(String[] gems) {
		Queue<String> q = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		HashMap<String, Integer> map = new HashMap<>();
		int start = 0;
		int end = Integer.MAX_VALUE;

		for (String s : gems) { // 보석종류
			set.add(s);
		}
		int startPoint = 0;
		for (int i = 0; i < gems.length; i++) {
			map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

			q.add(gems[i]);

			while (true) {
				String tmp = q.peek(); // 구간 내 보석이 1이상 있으면 start++
				if (map.get(tmp) > 1) {
					q.poll();
					start++;
					map.put(tmp, map.get(tmp) - 1);
				} else {
					break;
				}
			}
			if (map.size() == set.size() && end > q.size()) {
				end = q.size();
				startPoint = start;
			}

		}
		return new int[] { startPoint + 1, startPoint + end };
	}
}
