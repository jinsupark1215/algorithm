package Programs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_마닷하1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,5,7}, new int[] {4,10,12}));
	}

	public static int solution(int[] openA, int[] closeB) {
		int ans =0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		for (int i = 0; i < openA.length; i++) {
			pq.add(new int[] {1,openA[i]});
		}
		for (int i = 0; i < closeB.length; i++) {
			pq.add(new int[] {2,closeB[i]});
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0] == 1) {
				while(true) {
					int[] tmp = pq.poll();
					if(tmp[0] == 2) {
						ans += tmp[1]-cur[1];
						break;
					}
				}
			}
		}
		
		return ans;
    }
}
