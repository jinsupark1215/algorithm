package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17142 {

	/*
	 * 1. M개를 선택했을 때 최소이동시간
	 * 
	 * 2. N <= 50, M <=10
	 * 
	 * 3. M개 선택할 수 있는 조합
	 * 퍼트리는 bfs - 다른 바이러스를 만났을 때 활성화
	 * 전체 방문했는지 판단 visit -> 됬으면 최솟값 답
	 */
	static int N, M , min;
	static int[][] map;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	static boolean[] chk;
	static ArrayList<Point> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		map = new int[N][N];
		visit = new boolean[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num ==1) {
					visit[i][j] = true;
				}
				if(num == 2) {
					list.add(new Point(i,j,0));
				}
			}
		}
		
		chk = new boolean[list.size()];
		nCr(0,0);
		
		if(min == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	
	private static void nCr(int idx, int cnt) {
		if(cnt == M) {
			bfs();
			return;
		}
		
		for (int i = idx; i < chk.length; i++) {
			chk[i] = true;
			nCr(i+1,cnt+1);
			chk[i] = false;
		}
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] tmp = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = visit[i][j];
			}
		}
		for (int i = 0; i < chk.length; i++) {
			if(chk[i]) {
				q.add(list.get(i));
				tmp[list.get(i).r][list.get(i).c] = true;
			}
		}
		
		int max = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(map[p.r][p.c]!=2 )
			max = Math.max(max, p.cnt);
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr>=0 && nc >=0 && nr < N && nc < N && !tmp[nr][nc] && map[nr][nc] !=1) {
					tmp[nr][nc] = true;
					q.add(new Point(nr,nc,p.cnt+1));
				}
			}
		}
		
		if(check(tmp)) {
			min = Math.min(min, max);
		}
	}
	private static boolean check(boolean[][] tmp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!tmp[i][j])return false;
			}
		}
		return true;
	}
	static class Point{
		int r, c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}
}

