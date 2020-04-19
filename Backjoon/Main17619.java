package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main17619 {

	/*
	 * 1. 두 통나무로 이동이 가능한지?
	 * 
	 * 2. N <= 100,000, Q <= 100,000
	 * 
	 * 3. dfs, bfs -> (시간초과) 
	 * MST 알고리즘 사용 크루스칼
	 */
	static int n, m;
	static int set[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n][3];

		set = new int[n + 2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
			arr[i][2] = i + 1;
			set[i + 1] = i + 1;
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n - 1; i++) {
			if (arr[i][0] <= arr[i + 1][0] && arr[i + 1][0] <= arr[i][1]) {
				union(arr[i][2], arr[i + 1][2]);
				if (arr[i + 1][1] < arr[i][1])
					arr[i + 1][1] = arr[i][1];
				arr[i + 1][0] = arr[i][0];
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) == find(b)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

	static int find(int x) {
		if (x == set[x]) {
			return x;
		} else {
			return set[x] = find(set[x]);
		}
	}

	static void union(int x, int y) {
		int xx = find(x);
		int yy = find(y);

		if (xx != yy)
			set[yy] = xx;
	}
}
