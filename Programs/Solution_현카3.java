package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_현카3 {

	public static void main(String[] args) {
		String[] rooms = {"[101]Azad,Guard", "[202]Guard", "[303]Guard,Dzaz"};
		int target = 202;
		System.out.println(Arrays.toString(solution(rooms, target)));
	}

	private static String[] solution(String[] rooms, int target) {
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.cnt == o2.cnt) {
					if(o1.dis == o2.dis) {
						return o1.name.compareTo(o2.name);
					}
					return o1.dis - o2.dis;
				}
				return o1.cnt - o2.cnt;
			}
		});
		
		Map<String, Point> map = new HashMap<>();
		ArrayList<String> ok = new ArrayList<>();
		
		StringBuilder sb;
		for (int i = 0; i < rooms.length; i++) {
			sb = new StringBuilder();
			int chk = 0;
			if(rooms[i].charAt(4) ==']')chk= 4;
			else chk = 5;
			
			for (int j = 1; j < chk; j++) {
				sb.append(rooms[i].charAt(j));
			}
			int tar = Integer.parseInt(sb.toString());
			
			String[] names = rooms[i].substring(chk+1, rooms[i].length()).split(",");
			for (int j = 0; j < names.length; j++) {
				if(tar == target) {
					ok.add(names[j]);
					continue;
				}
				if(!map.containsKey(names[j])) {
					map.put(names[j], new Point(names[j],1,Math.abs(target - tar)));
				}else {
					map.replace(names[j], new Point(names[j],map.get(names[j]).cnt+1, Math.min(Math.abs(target-tar), map.get(names[j]).dis)));
				}
			}
		}
		
		for(String key:map.keySet()) {
			if(!ok.contains(map.get(key).name))
			pq.add(map.get(key));
		}
		
		int size = pq.size();
		String[] ans = new String[size];
		for (int i = 0; i < size; i++) {
			ans[i]= pq.poll().name;
		}
		return ans;
	}

	static class Point{
		public Point(String name, int cnt, int dis) {
			super();
			this.name = name;
			this.cnt = cnt;
			this.dis = dis;
		}
		String name;
		int cnt, dis;
	}
}
