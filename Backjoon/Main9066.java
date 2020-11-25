package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main9066 {
	/*
	 * [백준] 금고
	 * 
	 * 1. 최소 횟수로 주어진 맵을 만드는 방법
	 * 
	 * 2. N < 10^3, N은 짝수, dfs나 bfs 구현시 메모리초과, 규칙찾기
	 * 
	 * 3. 각 줄의 스톤 수를 센다. B일 시에 자기 자신 스톤을 빼고 홀수인 것을 체크
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			int[] row = new int[N];
			int[] col = new int[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);

					if (map[i][j] == 'V') {
						row[i]++;
						col[j]++;
					}
				}
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int stone = row[i] + col[j];
					if (map[i][j] == 'V') {
						stone--;
					}

					if (stone % 2 != 0)
						result++;
				}
			}
			System.out.println(result);
		}
	}
}
