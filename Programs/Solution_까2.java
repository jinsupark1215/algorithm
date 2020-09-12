package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_까2 {

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		System.out.println(Arrays.toString(solution(orders, course)));
	}

	static char[] tmp;
	static boolean[] v;
	static Map<String, Integer> map;
	
	private static String[] solution(String[] orders, int[] course) {
		String[] ans = {};
		map = new HashMap<>();
		
		for (int i = 0; i < orders.length; i++) {
			tmp = new char[orders[i].length()];
			v = new boolean[tmp.length];
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = orders[i].charAt(j);
			}
			Arrays.sort(tmp);
			for (int j = 0; j < tmp.length; j++) {
				sb.append(tmp[j]);
			}
			orders[i] = sb.toString();
			
			for (int j = 2; j <= tmp.length; j++) {
				dfs(0,0,j, "");
			}
		}
		PriorityQueue<Point>[] q = new PriorityQueue[11];
		for (int i = 0; i < 11; i++) {
			q[i] = new PriorityQueue<>(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					return o2.b - o1.b;
				}
			});
		}
		ArrayList<String> list = new ArrayList<>();
		
		Iterator<String> keys = map.keySet().iterator(); 
		
		for (int i = 0; i < course.length; i++) {
		while( keys.hasNext() ){
				String key = keys.next();
					int cnt = 0;
					
				for (int j = 0; j < orders.length; j++) {
					int chk = 0;

					for (int k = 0; k < key.length(); k++) {
						for (int l = 0; l < orders[j].length(); l++) {
							if (orders[j].charAt(l) == key.charAt(k)) {
								chk++;
								break;
							}
						}
					}
					if (chk == key.length())
						cnt++;
				}
					
					if (cnt > 1) {
						q[key.length()].add(new Point(key, map.get(key)));
					}
			}
		
		}
		for (int i = 0; i < course.length; i++) {
			if(q[course[i]].size()>0) {
				
				Point p = q[course[i]].poll();
				list.add(p.a);
				while(q[course[i]].size()>0) {
					Point tmp = q[course[i]].poll();
					if(p.b == tmp.b)list.add(tmp.a);
					else break;
					if(q[course[i]].size()==0)break;
				}
			}
		}

		Collections.sort(list);
		ans = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		
        return ans;
	}

	private static void dfs(int idx, int cnt, int fin, String input) {
		if(cnt == fin) {
			if(map.containsKey(input))map.replace(input, map.get(input) + 1);
			else map.put(input, 1);
		}
		
		for (int i = idx; i < tmp.length; i++) {
			if(!v[i]) {
				v[i] =true;
				dfs(i,cnt+1,fin,input+tmp[i]);
				v[i] = false;
			}
		}
	}
	static class Point{
		String a;
		int b;
		public Point(String a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
}
