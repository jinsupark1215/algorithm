package Programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_라3 {

	public static void main(String[] args) {
		int n = 10007;
		System.out.println(Arrays.toString(solution(n)));
	}

	static int min, answer;
	private static int[] solution(int n) {
		int[] ans = new int[2];
		
		min = Integer.MAX_VALUE;
		answer = 0;
		
		dfs(0,n);
		
		
		ans[0] = min;
		ans[1] = answer;
		
        return ans;
	}

	private static void dfs(int cnt, int n) {
		if(n/10 == 0 && min > cnt) {
			min = cnt;
			answer = n;
		}
		int left = 0;
		int right = 0;
		int div = 10;
		int chk = 0;
		while(n >= div) {
			left = n / div;
			right = n%div;
			String tmp = String.valueOf(n);
			if(n!=(left*div)+right)continue;
			div*=10;
			chk++;
			if(chk !=1 &&tmp.substring(tmp.length()-chk, tmp.length()).charAt(0) == '0')continue;
			dfs(cnt+1,left+right);
		}
	}
}
