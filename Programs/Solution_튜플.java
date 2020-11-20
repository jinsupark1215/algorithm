package Programs;

import java.util.HashMap;
import java.util.Map;

public class Solution_튜플 {

	public int[] solution(String s) {
		int[] answer = {};
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == '{') {
				StringBuilder sb = new StringBuilder();
				for (int j = i+1; j < s.length(); j++) {
					if(s.charAt(j) == '}')break;
					else sb.append(s.charAt(j));
				}
				
				String[] input = sb.toString().split(",");
				for (int j = 0; j < input.length; j++) {
					if(!map.containsKey(Integer.parseInt(input[j])))map.put(Integer.parseInt(input[j]), 1);
					else map.replace(Integer.parseInt(input[j]), map.get(Integer.parseInt(input[j]))+1);
				}
			}
		}
		int size = map.size();
		answer = new int[size];
		for(Integer key : map.keySet()) {
			answer[size - map.get(key)] = key;
		}
		return answer;
	}
}
