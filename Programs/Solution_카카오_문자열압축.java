package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_카카오_문자열압축 {

	/*
	 * 1. 압축해서 가장 짧은 길이는?
	 * 
	 * 2. s <= 1000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = Integer.MAX_VALUE;

		for (int slice = 1; slice <= s.length() / 2 + 1; slice++) {
			StringBuilder sb = new StringBuilder();

			int idx = 0;
			int cnt = 1;
			while (true) {
				if (idx + slice + slice > s.length()) {
					if (cnt != 1)sb.append(cnt);
					sb.append(s.substring(idx, s.length()));
					break;
				}

				if (s.substring(idx, idx + slice).equals(s.substring(idx + slice, idx + slice + slice))) {
					cnt++;
				} else {
					if (cnt != 1)
						sb.append(cnt);

					sb.append(s.substring(idx, idx + slice));
					cnt = 1;
				}
				idx += slice;
			}
			answer = Math.min(answer, sb.length());
		}

		return answer;
	}
}
