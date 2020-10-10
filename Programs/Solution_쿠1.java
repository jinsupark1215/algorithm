package Programs;

import java.util.Arrays;

public class Solution_쿠1 {

	public static void main(String[] args) {
		int N = 14;
		System.out.println(Arrays.toString(solution(N)));
	}

	private static int[] solution(int N) {
		int[] ans = new int[2];
		int max = 0;
		int idx = 0;
		
		
		for (int i = 2; i < 10; i++) {
			int tmp = N;
			int mul = 1;
			while(tmp>0) {
				if(tmp%i !=0) {
					mul *= tmp % i;
				}
				tmp /= i;
			}
			if(max <= mul) {
				max = mul;
				idx = i;
			}
		}
		
		ans[0] = idx;
		ans[1] = max;
		
		return ans;
	}
}
