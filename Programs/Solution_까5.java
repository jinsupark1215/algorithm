package Programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_까5 {

	public static void main(String[] args) {
		 
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		/*
		String play_time = "99:59:59";
		String adv_time = "25:00:00";
		String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
		 */
		System.out.println(solution(play_time, adv_time, logs));
	}

	private static String solution(String play_time, String adv_time, String[] logs) {
		StringBuilder ans = new StringBuilder();
		
		int size = 0;
		size  += Integer.parseInt(play_time.substring(0, 2)) * 3600;
		size  += Integer.parseInt(play_time.substring(3, 5)) * 60;
		size  += Integer.parseInt(play_time.substring(6, 8));
		int[] map = new int[size+1];
		
		int start, end;
		for (int i = 0; i < logs.length; i++) {
			start = 0;
			end = 0;
			start += Integer.parseInt(logs[i].substring(0, 2)) * 3600;
			start += Integer.parseInt(logs[i].substring(3, 5)) * 60;
			start += Integer.parseInt(logs[i].substring(6, 8));
			end += Integer.parseInt(logs[i].substring(9, 11)) * 3600;
			end += Integer.parseInt(logs[i].substring(12, 14)) * 60;
			end += Integer.parseInt(logs[i].substring(15, 17));
			
			map[start]++;
			map[end]--;
		}
		int idx = 0,during = 0, maxidx = 0;
		int sum = 0, max =0;
		during += Integer.parseInt(adv_time.substring(0, 2)) * 3600;
		during += Integer.parseInt(adv_time.substring(3, 5)) * 60;
		during += Integer.parseInt(adv_time.substring(6, 8));
		
		for (int i = size; i >= size-during; i--) {
				sum += map[i];
		}
		idx = size;
		
		while(idx-during >0) {
			if(sum != 0 &&sum >= max) {
				max = sum;
				maxidx = idx;
				}
			idx--;
			sum += map[idx+1];
		}
		
		if(maxidx/3600 < 10) {
			ans.append(0);
			ans.append(maxidx/3600);
		}else {
			ans.append(maxidx/3600);
		}
		maxidx %=3600;
		ans.append(":");
		if(maxidx/60 < 10) {
			ans.append(0);
			ans.append(maxidx/60);
		}else {
			ans.append(maxidx/60);
		}
		maxidx %=60;
		ans.append(":");
		if(maxidx < 10) {
			ans.append(0);
			ans.append(maxidx);
		}else {
			ans.append(maxidx);
		}
		
        return ans.toString();
	}
}
