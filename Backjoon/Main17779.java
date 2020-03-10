package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17779 {

	/*
	 * 1. 선거구의  최소차이를 구하여라
	 * 
	 * 2. 
	 * 
	 * 3. 구현
	 */
	public static int N, ans;
	public static int[][] map;
	public static int[][] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사각형을 그릴 수 있는지 확인
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (j - d2 < 0 || i + d1 + d2 >= N || j + d1 >= N)
							continue;
						count(i, j, d1, d2);
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void count(int r, int c, int d1, int d2) {
		num = new int[N][N];
		int[] people = new int[5]; // 각 선거구별 인구수를 저장할 배열

		// 5 구역
		int row = r, col = c;
		int width = d1, height = d2;
		while (width >= 0 && height >= 0) {
			for (int i = 0; i <= width; i++) { // 오른쪽 아래 대각선(w)
				num[row + i][col + i] = 5;
				num[row + height + i][col - height + i] = 5;
			}

			for (int i = 1; i < height; i++) { // 왼쪽 아래 대각선(h)
				num[row + i][col - i] = 5;
				num[row + width + i][col + width - i] = 5;
			}
			width--;
			height--;
			row++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (num[i][j] == 5)
					people[4] += map[i][j];
			}
		}

		// 1 구역
		for (int i = 0; i < r + d2; i++) {
			for (int j = 0; j <= c; j++) {
				if (num[i][j] != 5)
					people[0] += map[i][j];
			}
		}

		// 2 구역
		for (int i = 0; i <= r + d1; i++) {
			for (int j = c + 1; j < N; j++) {
				if (num[i][j] != 5)
					people[1] += map[i][j];
			}
		}

		// 3 구역
		for (int i = r + d2; i < N; i++) {
			for (int j = 0; j < c + d1 - d2; j++) {
				if (num[i][j] != 5)
					people[2] += map[i][j];
			}
		}

		// 4 구역
		for (int i = r + d1 + 1; i < N; i++) {
			for (int j = c + d1 - d2; j < N; j++) {
				if (num[i][j] != 5)
					people[3] += map[i][j];
			}
		}
		
		Arrays.sort(people);
		int result = people[4] - people[0];
		if (ans > result)
			ans = result;
	}
}

