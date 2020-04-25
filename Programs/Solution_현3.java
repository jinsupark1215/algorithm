package Programs;

import java.util.HashMap;
import java.util.Map;

public class Solution_현대카드3 {

	public static void main(String[] args) {
		String[] registered_list = {"apple1", "orange", "banana3"};
		String new_id = "apple";
		System.out.println(solution(registered_list,new_id));
	}

	private static String solution(String[] registered_list, String new_id) {
		String ans = "";
		boolean flag = false;
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < registered_list.length; i++) {
			map.put(registered_list[i], true);
		}
		while(!flag) {
			if(!map.containsKey(new_id)) {
				flag = true;
				break;
			}
		StringBuilder sb1= new StringBuilder();
		StringBuilder sb2= new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			if(new_id.charAt(i) -'0' >=0 && new_id.charAt(i) -'0' <= 9) {
				sb1.append(new_id.charAt(i));
			}else {
				sb2.append(new_id.charAt(i));
			}
		}
		int N=0;
		if(sb1.length()>0)N = Integer.parseInt(sb1.toString());
		
		sb2.append(N+1);
		new_id = sb2.toString();
		}
		
		ans = new_id;
		return ans;
	}

	
}
