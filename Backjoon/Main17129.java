package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17129 {

	/*
	 * [백준] 윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유
	 * 
	 * 1. 가장 빨리도착하는 경우의 시간
	 * 
	 * 2. n,m<=3000
	 * 
	 * 3. BFS
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		String ans1 = "NIE";
		int ans2 = 0;
		Queue<int[]> q= new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) -'0';
				if(map[i][j] == 2) {
					q.add(new int[] {i,j});
					visit[i][j] = true;
				}
			}
		}

		int idx = 0;
		fin:
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = arr[0] + pos[j][0];
					int nc = arr[1] + pos[j][1];
					if(nr>=0 && nr < N && nc>=0 && nc < M &&map[nr][nc] !=1 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new int[] {nr,nc});
						if(map[nr][nc] !=0) {
							ans1 = "TAK";
							ans2 = idx+1;
							break fin;
						}
					}
				}
			}
			idx++;
		}
		System.out.println(ans1);
		if(ans2 !=0)System.out.println(ans2);
	}
}
