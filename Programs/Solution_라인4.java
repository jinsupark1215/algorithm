package Programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution_라인4 {

	public static void main(String[] args) {
		String[][] snapshots = {{"ACCOUNT1", "100"},{"ACCOUNT2", "150"}};
		String[][] transactions = {{"1", "SAVE", "ACCOUNT2", "100"},{"2", "WITHDRAW", "ACCOUNT1", "50"},
				{"1", "SAVE", "ACCOUNT2", "100"},{"4", "SAVE", "ACCOUNT3", "500"},
				{"3", "WITHDRAW", "ACCOUNT2", "30"}};
		int n = 3;
		System.out.println(Arrays.toString(solution(snapshots,transactions)));
	}

	private static String[][] solution(String[][] snapshots, String[][] transactions) {
		String[][] answer = {};
		
		Map<String, Boolean> chk = new HashMap<>();
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < snapshots.length; i++) {
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}
		
		for (int i = 0; i < transactions.length; i++) {
			if(!chk.containsKey(transactions[i][0])) {
				chk.put(transactions[i][0], true);
				if(transactions[i][1].equals("SAVE")) {
					if(map.containsKey(transactions[i][2])) {
						map.replace(transactions[i][2], map.get(transactions[i][2]) + Integer.parseInt(transactions[i][3]));
					}else {
						map.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
					}
				}else {
					map.replace(transactions[i][2], map.get(transactions[i][2]) - Integer.parseInt(transactions[i][3]));
				}
			}
		}
		
		answer = new String[map.size()][2];
		int idx = map.size()-1;
		Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()){
            String key = keys.next();
            answer[idx][0] = key;
            answer[idx][1] = String.valueOf(map.get(key));
            idx--;
        }
		return answer;
	}
}
