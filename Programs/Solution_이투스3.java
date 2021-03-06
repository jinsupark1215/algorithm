package Programs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_이투스3 {

	public static void main(String[] args) {
		int[] s1 = {4,3,5,2,1,0,6};
		int[] s2 = {4,3,5,2,1,0,6};
		System.out.println(solution(s1, s2));
	}

	private static int solution(int[] s1, int[] s2) {
		int answer = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(s1);
		int turn = 0;
		
		fin:
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				
				int[] chk = q.poll();
			
				boolean flag = true;
				for (int j = 0; j < chk.length; j++) {
					if(s2[j] != chk[j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer = turn;
					break fin;
				}
				
				int zero = 0;
				for (int j = 0; j < chk.length; j++) {
					if(chk[j] == 0) {
						zero = j;
						break;
					}
				}
				
				for (int j = 0; j < chk.length; j++) {
					if(zero != j) {
						int tmp = chk[j];
						chk[j] = 0;
						chk[zero] = tmp;
						q.add(new int[] {chk[0],chk[1],chk[2],chk[3],chk[4],chk[5],chk[6]});
						chk[j] = tmp;
						chk[zero] = 0;
					}
				}
			}
			turn++;
		}
		return answer;
	}
}
