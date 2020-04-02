package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
	 * 3. 맵에 그린 후BFS
	 */
	static int N, M, K, X;
	static ArrayList[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		Queue<Point> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		visit[X] = true;
		for (int i = 0; i < arr[X].size(); i++) {
				q.add(new Point((int) arr[X].get(i), 1));
				visit[(int)arr[X].get(i)] = true;
		}

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.dist == K) {
				list.add(p.end);
			} else {
				for (int i = 0; i < arr[p.end].size(); i++) {
					if (!visit[(int)arr[p.end].get(i)]) {
						q.add(new Point((int) arr[p.end].get(i), p.dist + 1));
						visit[(int)arr[p.end].get(i)] = true;
					}
				}
			}
		}
		if (list.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}

	}

	static class Point {
		int end, dist;

		public Point(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}
	}
}
