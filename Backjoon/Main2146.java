package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2146 {

	/*
	 * [백준] 다리 만들기
	 * 
	 * 1. 가장 짧은 다리
	 * 
	 * 2. N <=100
	 * 
	 * 3. 라벨링 후 bfs
	 */
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N;

	static int[][] map;
	static boolean[][] check;
	static int[][] bridge;

	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 육지 마다 번호를 다르게 매겨 구분해줌
				if (map[i][j] == 1 && !check[i][j]) {
					Numbering(i, j, ++cnt);

				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 섬의 인덱스를 큐에 저장
				if (map[i][j] != 0) {
					q.add(new Node(i, j));
				}
			}
		}

		// 다리 길이 count할 배열
		bridge = new int[N][N];
		check = new boolean[N][N];
		BFS(); // 큐에 저장된 좌표로 영역 확장 및 다리길이 count

		// ans 기본값 설정
		int ans = Integer.MAX_VALUE;
		for (int v : list) {
			if (ans > v) {
				ans = v;
			}
		}

		System.out.println(ans);

	}

	static void Numbering(int i, int j, int k) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(i, j));
		map[i][j] = k;
		check[i][j] = true;

		while (!qu.isEmpty()) {
			Node n = qu.poll();

			for (int p = 0; p < 4; p++) {
				int nr = n.r + pos[p][0];
				int nc = n.c + pos[p][1];

				if (0 <= nr && nr < N && 0 <= nc && nc < N) {
					if (map[nr][nc] == 1 && !check[nr][nc]) {
						qu.add(new Node(nr, nc));
						map[nr][nc] = k;
						check[nr][nc] = true;
					}
				}
			}
		}
	}

	// 다리 놓기
	static void BFS() {
		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = n.r + pos[i][0];
				int nc = n.c + pos[i][1];

				if (0 <= nr && nr < N && 0 <= nc && nc < N) {
					// 다리 놓기 완성 --> 각자 놓인 다리 수 더하기
					if (map[nr][nc] != 0 && map[nr][nc] != map[n.r][n.c]) {
						list.add(bridge[nr][nc] + bridge[n.r][n.c]);
					}

					// 다리 놓기
					if (map[nr][nc] == 0) {
						q.add(new Node(nr, nc));
						map[nr][nc] = map[n.r][n.c];
						bridge[nr][nc] = bridge[n.r][n.c] + 1;
					}
				}
			}
		}
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
