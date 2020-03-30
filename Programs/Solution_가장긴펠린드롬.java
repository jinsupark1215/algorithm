package Programs;

public class Solution_가장긴펠린드롬 {

	public static void main(String[] args) {
		String s = "abcdef";
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 0;
		int length = s.length();

		for (int i = 0; i < length; i++) {
			for (int j = length; j > answer; j--) {
				int left = i;
				int right = left + j - 1;
				while (right < length && left >= 0 && left < right && s.charAt(left) == s.charAt(right)) {
					left++;
					right--;
				}
				if (left >= right && answer < j) {
					answer = j;
					break;
				}
			}
		}

		return answer;
	}
}
