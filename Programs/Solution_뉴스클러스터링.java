package Programs;

import java.util.ArrayList;

public class Solution_뉴스클러스터링 {
	public int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		// 각각 알파벳인 경우, 소문자 == 대문자 같게 배열에 넣기
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		for (int i = 0; i < str1.length() - 1; i++) {
			String tmp = str1.substring(i, i + 2);
			boolean flag = false;
			if (tmp.charAt(0) - 'A' >= 0 && tmp.charAt(0) - 'Z' <= 0 && tmp.charAt(1) - 'A' >= 0
					&& tmp.charAt(1) - 'Z' <= 0) {
				list1.add(tmp);
			}
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			String tmp = str2.substring(i, i + 2);
			boolean flag = false;
			if (tmp.charAt(0) - 'A' >= 0 && tmp.charAt(0) - 'Z' <= 0 && tmp.charAt(1) - 'A' >= 0
					&& tmp.charAt(1) - 'Z' <= 0) {
				list2.add(tmp);
			}
		}

		// 합집합, 교집합 구하기
		boolean[] visit = new boolean[list1.size()];
		ArrayList<String> list = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < list1.size(); i++) {
			list.add(list1.get(i));
		}

		for (int i = 0; i < list2.size(); i++) {
			boolean flag = true;
			for (int j = 0; j < list1.size(); j++) {
				if (list.get(j).equals(list2.get(i)) && !visit[j]) {
					visit[j] = true;
					flag = false;
					cnt++;
					break;
				}
			}
			if (flag)
				list.add(list2.get(i));
		}

		if (list.size() == 0)
			answer = 65536;
		else
			answer = cnt * 65536 / list.size();

		return answer;
	}
}
