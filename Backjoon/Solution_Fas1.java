package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution_Fas1 {

	public static void main(String[] args) {

		String s = "ab{}cd{efg{}h}{ij}";
		int[] idx = { 3, 6, 11, 3, 14, 11 };
		System.out.println(Arrays.toString(solution(s, idx)));
	}

	public static int[] solution(String s, int[] idx) {
		int[] ans = new int[idx.length];
		int[] chk = new int[s.length()];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '{') {
				stack.add(i);
			}else if(s.charAt(i) == '}') {
				int tmp = stack.pop();
				chk[tmp] = i;
				chk[i] = tmp;
			}
		}
		
		for (int i = 0; i < idx.length; i++) {
			ans[i] = chk[idx[i]];
		}
		
		return ans;
	}
}
