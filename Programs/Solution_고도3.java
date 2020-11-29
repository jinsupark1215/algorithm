package Programs;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_고도3 {

	public static void main(String[] args) {
		String s = "aab";
		int n = 4;
		System.out.println(solution(s, n));
	}

	private static int solution(String s, int n) {

		int[] alpa = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alpa[s.charAt(i) - 'a']++;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < alpa.length; i++) {
			if (alpa[i] != 0)
				list.add(alpa[i]);
		}
		Collections.sort(list);
		int ans = list.get(list.size() - 1) - list.get(0);
		// 5 2 1
		// 4 4 1
		int size = 0;
		for (int i = 0; i < n; i++) {

			if (list.size() > 0) {
				Collections.sort(list);
				if (list.get(size) == 1) {
					list.remove(size);
				} else {
					list.set(size, list.get(size) - 1);
				}
				if (size != 0) {
					size = list.size() - 1;
				} else {
					size = 0;
				}
				if (list.size() > 0) {
					Collections.sort(list);
					ans = Math.min(ans, list.get(list.size() - 1) - list.get(0));
				}
			}
		}

		list = new ArrayList<Integer>();
		for (int i = 0; i < alpa.length; i++) {
			if (alpa[i] != 0)
				list.add(alpa[i]);
		}
		// 5 2 1
		// 4 4 1
		size = list.size() - 1;
		for (int i = 0; i < n; i++) {

			if (list.size() > 0) {
				Collections.sort(list);
				if (list.get(size) == 1) {
					list.remove(size);
				} else {
					list.set(size, list.get(size) - 1);
				}
				if (size != 0) {
					size = list.size() - 1;
				} else {
					size = 0;
				}
				if (list.size() > 0) {
					Collections.sort(list);
					ans = Math.min(ans, list.get(list.size() - 1) - list.get(0));
				}
			}
		}

		return ans;
	}
}
