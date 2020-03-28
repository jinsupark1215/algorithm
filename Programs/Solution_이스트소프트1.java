package Programs;

import java.util.Arrays;

public class Solution_이스트소프트1 {

	public static void main(String[] args) {
		int[] A = { 3,1,4,1,5 };
		System.out.println(solution(A));
	}

	private static int solution(int[] A) {
		int answer = 0;

		Arrays.sort(A);
		int cnt = 0;

		for (int i = A.length - 1; i >= 0; i--) {
			if (i == 0) {
				cnt++;
				if (cnt == A[i]) {
					return A[i];
				}
				break;
			}
			if (A[i] == A[i - 1]) {
				cnt++;
			} else {
				cnt++;
				if (cnt == A[i]) {
					return A[i];
				} else {
					cnt = 0;
				}
			}
		}
		return answer;
	}
}
