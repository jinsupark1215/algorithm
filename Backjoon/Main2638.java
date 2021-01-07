package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638 {

	/*
	 * [백준] 치즈
	 * 
	 * 1. 몇 번의 치즈가 없어지나
	 * 
	 * 2. 
	 * 
	 * 3. bfs
	 */
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	static Queue<int[]> air = new LinkedList<>();
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j * 2) - 48;
			}
		}
		air.add(new int[] { 0, 0 });
		
		int time = 0;
		while (true) {
			int size = air.size();
			
			while (size-- > 0) {
				int[] tmp = air.poll();
				dfs(tmp[0], tmp[1]);
			}
			
			if (air.isEmpty()) {
				break;
			}
			time++;
		}
		System.out.println(time);
	}
	
	private static void dfs(int x, int y) {
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + pos[i][0];
			int ny = y + pos[i][1];
			
			if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
				if (map[ny][nx] != 0) {
					if (++map[ny][nx] == 3) {
						air.add(new int[] { nx, ny });
					}
				} else {
					dfs(nx, ny);
				}
			}
		}
	}
}
