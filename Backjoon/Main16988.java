package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16988 {

	/*
	 * [백준]Baaaaaaaaaduk2
	 * 
	 * 1.두 곳에 백돌을 놓아 잡을 수 있는 최대 흑돌의 수
	 * 
	 * 2. N,M<=20
	 * 
	 * 3. 
	 * 3-1. 흑돌 근처의 0을 리스트에 넣고 두 곳에 백돌을 놓음
	 * 3-2. 흑돌근처에 0이 있는경우는 체크하지 않고 2인 경우 bfs 1인경우 체크
	 */
	static int N,M,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		list = new ArrayList<int[]>();
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					for (int k = 0; k < 4; k++) {
						int nr = i + pos[k][0];
						int nc = j + pos[k][1];
						if(nr>=0 && nr < N && nc>=0 && nc< M && !visit[nr][nc] && map[nr][nc] == 0) {
							visit[nr][nc] = true;
							list.add(new int[] {nr,nc});
						}
					}
				}
			}
		}
		
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j < list.size(); j++) {
				map[list.get(i)[0]][list.get(i)[1]] = 1;
				map[list.get(j)[0]][list.get(j)[1]] = 1;
				bfs();
				map[list.get(i)[0]][list.get(i)[1]] = 0;
				map[list.get(j)[0]][list.get(j)[1]] = 0;
			}
		}
		System.out.println(ans);
	}

	private static void bfs() {
		visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2 && !visit[i][j]) {
					int cnt = 1;
					boolean flag = true;
					q.add(new int[] {i,j});
					visit[i][j] = true;
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						
						for (int k = 0; k < 4; k++) {
							int nr = cur[0] +pos[k][0];
							int nc = cur[1] +pos[k][1];
							if(nr>=0 && nc>=0 && nr< N && nc < M && !visit[nr][nc]) {
								if(map[nr][nc] == 0) {
									flag = false;
								}else if(map[nr][nc] == 2) {
									visit[nr][nc] = true;
									cnt++;
									q.add(new int[] {nr,nc});
								}
							}
						}
					}
					if(flag)total += cnt;
				}
			}
		}
		ans = ans<total?total:ans;
	}
}
