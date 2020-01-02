package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2151 {

	/*
	 * 1. 방문에서 다른 방문까지 가는데 몇개의 거울(몇번 반사커브)가 필요한가?
	 * 
	 * 2. 거울은 45도로 설치되서 90도로 빛이 반사되고 커브가 적은것부터 최소로해서 빨리 답찾기
	 * 
	 * 3. 우선순위 큐를 써서 속도를 줄이고 커브 수가 적은 것부터 찾아냄.
	 */
	static int N;
	static char[][] map;
	static PriorityQueue<Node> q = new PriorityQueue<>();
	static int sr, sc, er, ec;
	static boolean[][][] visited;
	static int[][] pos = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[] d1 = { 3, 2, 1, 0 };
	static int[] d2 = { 2, 3, 0, 1 };

	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N][4];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j];
				if (temp[j] == '#') {
					if (idx == 0) {
						sr = i;
						sc = j;
					} else {
						er = i;
						ec = j;
					}
					idx++;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			q.add(new Node(sr, sc, i, 0));
		}

		while (!q.isEmpty()) {

			Node cur = q.poll();

			int r = cur.r;
			int c = cur.c;
			int dir = cur.dir;
			int curve = cur.curve;

			if (visited[r][c][dir])
				continue;

			visited[r][c][dir] = true;

			if (cur.r == er && cur.c == ec) {
				min = cur.curve;
				break;
			}

			int nr = r + pos[dir][0];
			int nc = c + pos[dir][1];

			if (!isRange(nr, nc) || map[nr][nc] == '*')
				continue;

			if (map[nr][nc] == '!') {
				q.add(new Node(nr, nc, d1[dir], curve + 1));
				q.add(new Node(nr, nc, d2[dir], curve + 1));
			}
			q.add(new Node(nr, nc, dir, curve));
		}
		System.out.println(min);
	}

	static boolean isRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}
}

class Node implements Comparable<Node> {
	int r;
	int c;
	int dir;
	int curve;

	Node(int r, int c, int dir, int dis) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.curve = dis;
	}

	@Override
	public int compareTo(Node o) {
		return this.curve - o.curve;
	}

}
