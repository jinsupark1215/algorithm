package Programs;

public class Solution_다트게임 {
	public int solution(String dartResult) {
		int answer = 0;
		int tmp = 0;
		for (int i = 0; i < dartResult.length() - 1; i++) {
			if (dartResult.charAt(i) - '0' >= 0 && dartResult.charAt(i) - '9' <= 0) {
				int num = 0;

				if (i != dartResult.length() - 2 && dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
					num = go(10, dartResult.charAt(i + 2));
					if (i + 3 < dartResult.length()) {
						if (dartResult.charAt(i + 3) == '#') {
							num *= -1;
							answer += num;
							i++;
						} else if (dartResult.charAt(i + 3) == '*') {
							num *= 2;
							answer += num;
							answer += tmp;
							i++;
						} else {
							answer += num;
							i++;
						}
					} else {
						answer += num;
						i++;
					}
					tmp = num;
				} else {
					num = go(dartResult.charAt(i) - '0', dartResult.charAt(i + 1));

					if (i + 2 < dartResult.length()) {
						if (dartResult.charAt(i + 2) == '#') {
							num *= -1;
							answer += num;
							i++;
						} else if (dartResult.charAt(i + 2) == '*') {
							num *= 2;
							answer += num;
							answer += tmp;
							System.out.println(num);
							System.out.println(tmp);
							i++;
						} else {
							answer += num;
							i++;
						}
					} else {
						answer += num;
						i++;
					}
					tmp = num;
				}
			}
		}
		return answer;
	}

	public int go(int num, char chk) {
		if (chk == 'S')
			return num;
		else if (chk == 'D')
			return num * num;
		else if (chk == 'T')
			return num * num * num;
		return 0;
	}
}
