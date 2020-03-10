package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_쿠팡1 {

	public static void main(String[] args) {
		int n = 5;
		int min_position = -5;
		int max_position = 3;
		int[] positions = {-1,-3,3};
		System.out.println(Arrays.toString(solution(n,min_position,max_position,positions)));
	}

	private static int[] solution(int n, int min_position, int max_position, int[] positions) {
		int[] answer;
		
		Map<Integer,Boolean> map = new HashMap<>();
		for (int i = 0; i < positions.length; i++) {
			map.put(positions[i], true);
		}
		int idx = (max_position - min_position)/(n-1);
		int start = min_position;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = min_position; i <= max_position; i+=(max_position - min_position)/(n-1)) {
			if(!map.containsKey(i))list.add(i);
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
