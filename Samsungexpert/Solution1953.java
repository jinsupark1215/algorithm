package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953 {

	/* [삼성] 탈주범 검거
	 * 
	 * 1. 탈주범이 있을 수 있는 공간의 갯수 세기
	 * 
	 * 2. 5<= N,M <=50, L <=20
	 * 
	 * 3. 각 방향대로 갈 수 있는 곳 bfs
	 * 
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] tunnel = {
			{},
			{0,1,2,3},
			{0,1},
			{2,3},
			{1,2},
			{0,2},
			{0,3},
			{1,3}
	};
	static int N,M,L,R,C,ans;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve();
			
			System.out.println("#"+ tc + " " + ans);
		}
	}
	
	private static void solve() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(map[R][C],R,C,0));
		
		while (!q.isEmpty()) {
			int size = q.size();
			int idx =0;
			if(idx == L)break;
			for (int k = 0; k < size; k++) {
				
			Point p = q.poll();
			visit[p.r][p.c] = true; 
			if(p.time == L)break;
			ans++;
			
			for (int i = 0; i < tunnel[p.num].length; i++) {
				int nr = p.r + pos[tunnel[p.num][i]][0];
				int nc = p.c + pos[tunnel[p.num][i]][1];
				if(nr>=0 && nr <N && nc >=0 && nc < M && !visit[nr][nc] &&map[nr][nc] !=0) {
					if(tunnel[p.num][i] == 0 && map[nr][nc] == 5)continue;
					if(tunnel[p.num][i] == 0 && map[nr][nc] == 6)continue;
					if(tunnel[p.num][i] == 0 && map[nr][nc] == 3)continue;
					if(tunnel[p.num][i] == 1 && map[nr][nc] == 4)continue;
					if(tunnel[p.num][i] == 1 && map[nr][nc] == 7)continue;
					if(tunnel[p.num][i] == 1 && map[nr][nc] == 3)continue;
					if(tunnel[p.num][i] == 2 && map[nr][nc] == 4)continue;
					if(tunnel[p.num][i] == 2 && map[nr][nc] == 5)continue;
					if(tunnel[p.num][i] == 2 && map[nr][nc] == 2)continue;
					if(tunnel[p.num][i] == 3 && map[nr][nc] == 6)continue;
					if(tunnel[p.num][i] == 3 && map[nr][nc] == 7)continue;
					if(tunnel[p.num][i] == 3 && map[nr][nc] == 2)continue;
					q.add(new Point(map[nr][nc],nr,nc, p.time+1));
					visit[nr][nc] = true;
				}
			}
		}
			idx++;
		}
	}
	
	static class Point{
		int num,r,c,time;

		public Point(int num, int r, int c, int time) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}
}

