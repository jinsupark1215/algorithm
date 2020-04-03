package Programs;

import java.util.Arrays;

public class Solution_단어변환 {

	/*
	 * [프로그래머스] 단어변환
	 * 
	 * 1. 몇번만에 바꿀 수 있나
	 * 
	 * 2. 단어의 길이 3 이상 10 이하
	 * 
	 * 3. dfs
	 */
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		
		System.out.println(solution(begin,target,words));
	}

	static int answer;
	private static int solution(String begin, String target, String[] words) {
		boolean[] visit = new boolean[words.length];
		answer = Integer.MAX_VALUE;
		go(begin,target,words,visit,0);
		
		return answer;
	}

	private static void go(String begin, String target, String[] words, boolean[] visit, int cnt) {
		if(begin.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if (!visit[i]) {
				int diff = 0;
				for (int j = 0; j < begin.length(); j++) {
					if (words[i].charAt(j) != begin.charAt(j))
						diff++;
				}
				if (diff == 1) {
					visit[i] = true;
					go(words[i], target, words, visit, cnt + 1);
					visit[i] = false;
				}
			}
		}
	}


}
