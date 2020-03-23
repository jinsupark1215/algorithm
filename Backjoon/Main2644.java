package Backjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2644 {

	/*
	 * 1. 촌수 계산
	 * 
	 * 2. n <=100
	 * 
	 * 3. 배열로 계산
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[m][2];
		for (int i = 0; i < m; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int[] dist = new int[n + 1];
		boolean[] visit = new boolean[n + 1];
		Arrays.fill(dist, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		dist[a] = 0;

		while (!q.isEmpty()) {
			int x = q.poll();
			visit[x] = true;

			for (int i = 0; i < m; i++) {
				if (arr[i][0] == x && !visit[arr[i][1]]) {
					q.add(arr[i][1]);
					dist[arr[i][1]] = dist[arr[i][0]] + 1;
				} else if (arr[i][1] == x && !visit[arr[i][0]]) {
					q.add(arr[i][0]);
					dist[arr[i][0]] = dist[arr[i][1]] + 1;
				}
			}
			if (!q.isEmpty() && q.peek() == b) {
				break;
			}
		}
		System.out.println(dist[b]);
	}
}
