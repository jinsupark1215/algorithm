package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {

	/*
	 * 1. 치즈가 녹아서 없어지는데 걸리는 시간 및 마지막 전의 치즈조각 개수
	 * 
	 * 2. <= 100
	 * 
	 * 3. bfs 
	 */
	static int N, M, ans, anscnt;
	static int[][] map;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = 0;
		anscnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			ArrayList<Integer> list = new ArrayList<>();
			int cnt = 0;
			
			boolean[][] visit = new boolean[N][M];
			
						Queue<Integer> q = new LinkedList<>();
						q.add(0);q.add(0);
						visit[0][0] = true;
						while (!q.isEmpty()) {
							int r = q.poll();
							int c = q.poll();
							
							for (int k = 0; k < 4; k++) {
								int nr = r + pos[k][0];
								int nc = c + pos[k][1];
								if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc]) {
									if (map[nr][nc] == 0) {
										q.add(nr);
										q.add(nc);
										visit[nr][nc] = true;
									}else {
										list.add(nr);list.add(nc);
										visit[nr][nc] = true;
										cnt++;
									}
								}
							}
						}
			
			if(cnt == 0) {
				break;
			}else {
				for (int i = 0; i < list.size(); i+=2) {
					map[list.get(i)][list.get(i+1)] = 0;
				}
				anscnt = cnt;
			}
			ans++;
		}
		System.out.println(ans);
		System.out.println(anscnt);
	}
}
