package Programs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_고도5 {

	public static void main(String[] args) {
		int[] votes = {5,10,7,3,8};
		System.out.println(solution(votes));
	}

	private static int solution(int[] votes) {
		int ans = 0;
		
		int N = votes.length;
		
		if(N!= 1) {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			
			//0번 유권자
			int zero = votes[0];
			for (int i = 1; i < N; i++) {
				pq.add(votes[i]);
			}
			
			//유권자들이 없을때 까지
			while(!pq.isEmpty()) {
				int vote = pq.poll();
				
				//0번 유권자보다 투표수가 많으면 뺴주고 다시 큐에 넣기
				if(zero <= vote) {
					ans++;
					zero++;
					pq.add(vote-1);
				}
			}
		}
		
		return ans;
	}
}
