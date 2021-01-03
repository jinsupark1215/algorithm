package Programs;

import java.util.PriorityQueue;

public class Solution_EST2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1,2,12,14,15 }, 2));
	}

	private static int solution(int[] scores, int k) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < scores.length - 1; i++) {
			pq.add(scores[i + 1] - scores[i]);
		}

			for (int i = 0; i < (scores.length-k); i++) {
				answer += pq.poll();
			}
		return answer;
	}
}
