package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_라2 {

	public static void main(String[] args) {
		int[] ball = {1, 2, 3, 4, 5, 6};
		int[] order = {6, 2, 5, 1, 4, 3};
		System.out.println(Arrays.toString(solution(ball, order)));
	}

	private static int[] solution(int[] ball, int[] order) {
		int[] ans = new int[ball.length];
		ArrayList<Integer> list = new ArrayList<>();
		
		// 빠질 원소
		boolean[] visit = new boolean[ball.length];
		// 빠진 원소
		boolean[] chk = new boolean[ball.length];
		
		for (int i = 0; i < order.length; i++) {
			//체크
			for (int j = 0; j < ball.length; j++) {
				if(ball[j] == order[i])visit[j] = true;
			}
			
			//왼쪽
			for (int j = 0; j < visit.length; j++) {
				if(chk[j])continue;
				if(!chk[j] &&visit[j]) {
					list.add(ball[j]);
					chk[j] = true;
				}else break;
			}
			//오른쪽
			for (int j = visit.length-1; j >=0; j--) {
				if(chk[j])continue;
				if(!chk[j] &&visit[j]) {
					list.add(ball[j]);
					chk[j] = true;
				}else break;
			}
		}
		
		for (int i = 0; i < ball.length; i++) {
			ans[i] = list.get(i);
		}
        return ans;
	}
}
