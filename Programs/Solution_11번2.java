package Programs;

import java.util.Arrays;

public class Solution_11번2 {
	public static void main(String[] args) {
		String[] S = {"bdafg", "ceagi"};
		System.out.println(Arrays.toString(solution(S)));
	}

	private static int[] solution(String[] S) {
		int[] ans = {};
		
		int idx = 0;
		
		fin:
		for (int i = 0; i < S[0].length(); i++) {
			int[] cnt = new int[26];
			for (int j = 0; j < 26; j++) {
				cnt[j] = -1;
			}
			for (int j = 0; j < S.length; j++) {
				if(cnt[S[j].charAt(idx)-'a'] == -1) {
					cnt[S[j].charAt(idx)-'a'] = j;
				}else {
					ans = new int[3];
					ans[0] = cnt[S[j].charAt(idx)-'a'];
					ans[1] = j;
					ans[2] = idx;
					break fin;
				}
			}
			idx++;
		}
		return ans;
	}

}
