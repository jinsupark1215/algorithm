package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18352 {

	/*
	 * [백준] 특정 거리의 도시 찾기
	 * 
	 * 1. X와 거리가 K인 것들
	 * 
	 * 2. N <=300,000, M <=1000000
	 * 
	 * 3. 맵에 그린 후BFS -> 메모리초과
	 * 
	 * 인접리스트 만든 후 거리 배열로 거리만 표시
	 */
	static int N, M, K, X;
	static ArrayList[] arr;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		ans = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		Queue<City> q = new LinkedList<>();
		ans[X] = -1;
		for (int i = 0; i < arr[X].size(); i++) {
			q.add(new City((int) arr[X].get(i), 1));
			ans[(int) arr[X].get(i)] = 1;
		}

		while (!q.isEmpty()) {
			City c = q.poll();

			if (c.dist <= K) {
				for (int i = 0; i < arr[c.end].size(); i++) {
					if (ans[(int) arr[c.end].get(i)] == 0) {
						q.add(new City((int) arr[c.end].get(i), c.dist + 1));
						ans[(int) arr[c.end].get(i)] = c.dist+1;
					}
				}
			}

		}

		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (ans[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		if (!flag)
			System.out.println(-1);
	}

	static class City {
		int end, dist;

		public City(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}
	}
}