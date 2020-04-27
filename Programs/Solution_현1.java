package Programs;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_현대카드1 {

	/*
	 * [수정] 365일수 예외처리가 안됨 
	 * 
	 */
	public static void main(String[] args) {
		String[] purchase = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
		System.out.println(Arrays.toString(solution(purchase)));
	}

	private static int[] solution(String[] purchase) {
		int[] ans = new int[5];
		int[] month= {0,0,31,59,90,120,151,181,212,243,273,304,334,365};
		int[] map = new int[365];
		for (int i = 0; i < purchase.length; i++) {
			int m = Integer.parseInt(purchase[i].substring(5, 7));
			int d = Integer.parseInt(purchase[i].substring(8, 10));
			StringTokenizer st= new StringTokenizer(purchase[i]);
			st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 30; j++) {
				if(month[m]+d+j<365)
				map[month[m]+d+j] += x;
			}
		}
		
		for (int i = 0; i < 365; i++) {
			if(map[i] < 10000)ans[0]++;
			else if(map[i] < 20000)ans[1]++;
			else if(map[i] < 50000)ans[2]++;
			else if(map[i] < 100000)ans[3]++;
			else ans[4]++;
		}
		return ans;
	}
}
