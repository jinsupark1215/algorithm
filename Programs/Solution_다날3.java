package Programs;

import java.util.Arrays;
import java.util.Stack;

public class Solution_다날3 {

	public static void main(String[] args) {
		int[] price = { 4, 1, 4, 7, 6 };
		System.out.println(Arrays.toString(solution(price)));
	}

	private static int[] solution(int[] price) {
		int n = price.length;
		int[] ans = new int[n];

		Stack<int[]> stack = new Stack<int[]>();

		for (int i = 0; i < n; i++) {
			ans[i] = -1;
			if (stack.isEmpty()) {
				stack.add(new int[] { i, price[i] });
			} else {
				if (stack.peek()[1] < price[i]) {
					while (true) {
						int[] cur = stack.pop();
						ans[cur[0]] = i - cur[0];
						if (stack.isEmpty() || stack.peek()[1] >= price[i])
							break;
					}
				}
				stack.add(new int[] { i, price[i] });

			}

		}
		return ans;
	}
}
