package Programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_쿠3 {

	public static void main(String[] args) {
		int k = 2;
		int[] score = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
		System.out.println(solution(k,score));
	}

	private static int solution(int k,int[] score) {
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		int[] diff = new int[score.length-1];
		
		for (int i = 0; i < score.length-1; i++) {
			diff[i] = score[i] - score[i+1];
			if(!map.containsKey(diff[i])) {
				map.put(diff[i], 1);
			}else {
				map.replace(diff[i], map.get(diff[i])+1);
			}
		}
		
		for (int i = 0; i < diff.length; i++) {
			if(map.get(diff[i]) >=k) {
				set.add(i);
				set.add(i+1);
			}
		}

		ans = score.length - set.size();

		return ans;
	}
}
