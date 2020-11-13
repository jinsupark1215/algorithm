package Programs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_캐시 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Queue<String> q = new LinkedList<>();

		for (int i = 0; i < cities.length; i++) {
			// 캐시에 등록 되있으면 hit
			if (q.contains(cities[i].toUpperCase())) {
				answer += 1;
				q.remove(cities[i].toUpperCase());
				q.add(cities[i].toUpperCase());
			} else {
				// 캐시가 꽉찾으면 순서대로 지우고 뒤에 넣어줌
				if (cacheSize != 0 && q.size() == cacheSize) {
					q.poll();
					q.add(cities[i].toUpperCase());
					answer += 5;
				} else if (cacheSize != 0) {
					// 캐시가 덜 찼으면 캐시에 입력
					q.add(cities[i].toUpperCase());
					answer += 5;
				} else {
					answer += 5;
				}
			}
		}

		return answer;
	}
}
