package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7562 {

	/*
	 * [백준] 나이트의 이동
	 * 
	 * 1. 최소 이동
	 * 
	 * 2. 한변의 길이 4<=I<=300
	 * 
	 * 3. BFS
	 */
	static int[][] pos = {{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int l = Integer.parseInt(br.readLine());
			boolean[][] visit = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startr = Integer.parseInt(st.nextToken());
			int startc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endr = Integer.parseInt(st.nextToken());
			int endc = Integer.parseInt(st.nextToken());
			int ans= 0 ;
			
			Queue<int[]> q= new LinkedList<>();
			visit[startr][startc] = true;
			q.add(new int[] {startr,startc,0});
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				if(cur[0] == endr && cur[1] == endc) {
					ans = cur[2];
					break;
				}
				
				for (int j = 0; j < 8; j++) {
					int nr = cur[0] + pos[j][0];
					int nc = cur[1] + pos[j][1];
					if(nr>=0 && nc>=0 && nr< l && nc<l && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new int[] {nr,nc,cur[2]+1});
					}
				}
			}
			System.out.println(ans);
		}
	}
}
