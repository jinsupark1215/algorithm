package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_현대카드2 {

	public static void main(String[] args) {
		String[] ip_addrs = {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
		String[] langs = {"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"};
		int[] scores = {294, 197, 373, 45, 294, 62, 373, 373};
		System.out.println(solution(ip_addrs,langs,scores));
	}

	private static int solution(String[] ip_addrs, String[] langs, int[] scores) {
		int ans = ip_addrs.length;

		for (int i = 0; i < ip_addrs.length; i++) {
			if (scores[i] != 500) {

				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				for (int j = i + 1; j < ip_addrs.length; j++) {
					if (scores[j] != 500 && ip_addrs[i].equals(ip_addrs[j])) {
						list.add(j);
					}
				}
				if (list.size() >= 4) {
					for (int j = 0; j < list.size(); j++) {
						scores[list.get(j)] = 500;
					}
					ans -= list.size();
				} else if (list.size() == 3) {
					String a = langs[list.get(0)];
					String b = langs[list.get(1)];
					String c = langs[list.get(2)];
					if ((a.substring(0, 1).equals("C") && b.substring(0, 1).equals("C")&& c.substring(0, 1).equals("C")) 
							|| (a.equals(b) && b.equals(c) && c.equals(a))) {
						for (int j = 0; j < list.size(); j++) {
							scores[list.get(j)] = 500;
						}
						ans -= list.size();
					}
				} else if (list.size() == 2) {
					String a = langs[list.get(0)];
					String b = langs[list.get(1)];
					if((a.substring(0, 1).equals('C') && b.substring(0, 1).equals('C') || a.equals(b))){
						if(scores[list.get(0)] == scores[list.get(1)]) {
							for (int j = 0; j < list.size(); j++) {
								scores[list.get(j)] = 500;
							}
							ans -= list.size();
						}
					}
				}
			}
		}
		return ans;
	}

}
