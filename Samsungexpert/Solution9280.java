package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution9280 {

	/*
	 * [삼성] 진용이네 주차공간
	 * 
	 * 1. 벌어들일 총 수입을 계산하는 프로그램
	 * 
	 * 2. n<=100, m<=2000
	 * 
	 * 3. 들어갈 때 차량 계산 차량대기하는 queue를 두고 나가는 순간 큐 확인후 넣어주기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans = 0;

			int[] weight = new int[n];
			int[] parking = new int[n];
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(br.readLine());
			}
			int[] cars = new int[m];
			for (int i = 0; i < m; i++) {
				cars[i] = Integer.parseInt(br.readLine());
			}
			Queue<Integer> q = new LinkedList<>();

			// 로직
			for (int i = 0; i < m * 2; i++) {
				int car = Integer.parseInt(br.readLine());

				if (car > 0) {
					boolean flag = false;
					for (int j = 0; j < n; j++) {
						if (parking[j] == 0) {
							parking[j] = car;
							ans += weight[j] * cars[car - 1];
							flag = true;
							break;
						}
					}

					if (!flag)
						q.add(car);
				} else {
					for (int j = 0; j < n; j++) {
						if (parking[j] == Math.abs(car)) {
							parking[j] = 0;
							break;
						}
					}

					if (!q.isEmpty()) {
						for (int j = 0; j < n; j++) {
							if (parking[j] == 0) {
								car = q.poll();
								parking[j] = car;
								ans += weight[j] * cars[car - 1];
								break;
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
