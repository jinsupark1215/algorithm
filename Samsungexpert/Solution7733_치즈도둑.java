package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7733_치즈도둑 {

	/*
	 * 1. 치즈 조각이 가장 많이 나오는 덩어리 갯수
	 * 
	 * 2. N <=100
	 * 
	 * 3. 각 날짜별로 먹었으면 0으로 만들고 visit 처리를 통해서 갯수 세기
	 */
	static int N, ans, maxday;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = 1;
			maxday = 0;

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > maxday)
						maxday = map[i][j];
				}
			}

			for (int day = 1; day <= maxday; day++) {
				visit = new boolean[N][N];
				int cnt =0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j] == day)map[i][j] = 0;
					}
				}
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(!visit[i][j] && map[i][j] !=0) {
							bfs(i,j);
							cnt++;
						}
					}
				}
				ans = Math.max(ans, cnt);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void bfs(int r, int c) {
		Queue<Integer> q = new LinkedList<>();
		q.add(r);q.add(c);
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			int curc = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr + pos[i][0];
				int nc = curc + pos[i][1];
				if(nr>=0 && nr < N && nc>=0 && nc< N && !visit[nr][nc] && map[nr][nc] !=0) {
					visit[nr][nc] = true;
					q.add(nr);q.add(nc);
				}
			}
		}
	}
}
