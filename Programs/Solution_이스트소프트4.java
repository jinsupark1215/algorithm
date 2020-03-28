package Programs;

import java.util.HashMap;
import java.util.Map;

public class Solution_이스트소프트4 {

	public static void main(String[] args) {
		String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		String C = "Example";
		System.out.println(solution(S, C));
	}

	private static String solution(String S, String C) {
		StringBuilder sb = new StringBuilder();

		String[] input = S.split(";");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < input.length; i++) {
			sb.append(input[i]);
			
			StringBuilder tmp = new StringBuilder();
			tmp.append(" <");
			String[] arr = input[i].trim().split(" ");
			tmp.append(arr[arr.length-1].replace("-", "").toLowerCase());
			tmp.append('_');
			tmp.append(arr[0].toLowerCase());
			
			if(!map.containsKey(tmp.toString())) {
				map.put(tmp.toString(), 1);
			}else {
				map.replace(tmp.toString(), map.get(tmp.toString())+1);
				tmp.append(map.get(tmp.toString()));
			}
			
			tmp.append('@');
			tmp.append(C.toLowerCase());
			if(i == input.length-1) {
				tmp.append(".com>");
			}else {
				tmp.append(".com>;");
			}
			sb.append(tmp.toString());
		}
		
		return sb.toString();
	}
}
