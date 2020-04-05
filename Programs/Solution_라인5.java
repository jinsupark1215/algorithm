package Programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_라인5 {

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] tags = { "t1", "t2", "t3" };
		System.out.println(Arrays.toString(solution(dataSource, tags)));
	}

	private static String[] solution(String[][] dataSource, String[] tags) {
		String[] answer = {};

		PriorityQueue<Point> q = new PriorityQueue<>();
		int cnt;
		
		for (int j = 0; j < dataSource.length; j++) {
			cnt = 0;
			for (int k = 0; k < dataSource[j].length; k++) {
				for (int i = 0; i < tags.length; i++) {
					if (tags[i].equals(dataSource[j][k])) {
						cnt++;
						break;
					}
				}
			}
			if(cnt !=0)
			q.add(new Point(dataSource[j][0], cnt));
		}
		
		answer = new String[q.size()];
		int size = q.size();
		for (int i = 0; i < size; i++) {
			answer[i] = q.poll().name;
		}

		return answer;
	}

	static class Point implements Comparable<Point> {
		String name;
		int cnt;

		public Point(String name, int cnt) {
			super();
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if(o.cnt == this.cnt)return 1;
			return o.cnt - this.cnt;
		}
	}
}
