package Programs;

public class Solution_방금그곡 {

	public static void main(String[] args) {
		System.out.println(solution("ABC", new String[] { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" }));
	}

	public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int len = musicinfos.length;

		StringBuilder sb = new StringBuilder();
		// 샵처리
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) == '#') {
				sb = new StringBuilder();
				sb.append(m.charAt(i - 1));
				sb.append('#');
				m = m.replace(sb.toString(), String.valueOf(m.charAt(i - 1) - 'A'));
				i -= 2;
			}
		}

		int length = 0;

		for (int i = 0; i < len; i++) {
			String[] input = musicinfos[i].split(",");
			int hour = (Integer.parseInt(input[1].substring(0, 2)) - Integer.parseInt(input[0].substring(0, 2))) * 60;
			int min = (Integer.parseInt(input[1].substring(3, 5)) - Integer.parseInt(input[0].substring(3, 5)));

			// 샵처리
			for (int j = 0; j < input[3].length(); j++) {
				if (input[3].charAt(j) == '#') {
					sb = new StringBuilder();
					sb.append(input[3].charAt(j - 1));
					sb.append('#');
					input[3] = input[3].replace(sb.toString(), String.valueOf(input[3].charAt(j - 1) - 'A'));
					j -= 2;
				}
			}
			sb = new StringBuilder();
			if (hour + min <= input[3].length()) {
				for (int j = 0; j < hour + min; j++) {
					sb.append(input[3].charAt(j));
				}
			} else {
				for (int j = 0; j < (hour + min) / input[3].length(); j++) {
					sb.append(input[3]);
				}
				for (int j = 0; j < (hour + min) % input[3].length(); j++) {
					sb.append(input[3].charAt(j));
				}
			}

			// 찾기
			if (sb.toString().contains(m) && length < sb.toString().length()) {
				answer = input[2];
				length = sb.toString().length();
			}
		}

		return answer;
	}
}
