package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_현대카드4 {

	public static void main(String[] args) {
		int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
		System.out.println(Arrays.toString(solution(macaron)));
	}

	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map;
	private static String[] solution(int[][] macaron) {
		String[] ans = new String[6];
		
		map = new int[6][6];
		
		for (int i = 0; i < macaron.length; i++) {
			go(macaron[i][0]-1,macaron[i][1]);
			drop();
			chk();
		}
		
		for (int i = 0; i < ans.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < ans.length; j++) {
				sb.append(map[i][j]);
			}
			ans[i] = sb.toString();
		}
		return ans;
	}
	private static void chk() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if(map[i][j] !=0) {
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i,j));
					boolean[][] visit = new boolean[6][6];
					int cnt = 1;
					visit[i][j]= true;
					while(!q.isEmpty()) {
						Point p = q.poll();
						
						for (int k = 0; k < 4; k++) {
							int nr = p.r + pos[k][0];
							int nc = p.c + pos[k][1];
							if(nr>=0 && nr< 6 && nc>=0 && nc<6 && map[nr][nc] == map[i][j] && !visit[nr][nc]) {
								visit[nr][nc] = true;
								q.add(new Point(nr,nc));
								cnt++;
							}
						}
					}
					if(cnt >= 3) {
						for (int k = 0; k < 6; k++) {
							for (int l = 0; l < 6; l++) {
								if(visit[k][l])map[k][l] = 0;
							}
						}
						drop();
						chk();
					}
				}
			}
		}
		
	}
	private static void drop() {
		int[][] tmp = new int[6][6];
		for (int i = 0; i < 6; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 5; j >=0; j--) {
				if(map[j][i] != 0)list.add(map[j][i]);
			}
			int idx = 5;
			for (int j = 0; j < list.size(); j++) {
				tmp[idx][i] = list.get(j);
				idx--;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}
	private static void go(int idx, int num) {
		int tmp = 0;
		for (int i = 5; i >=0; i--) {
			if(map[i][idx] ==0) {
				map[i][idx] = num;
				tmp = i;
				break;
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(tmp,idx));
		boolean[][] visit = new boolean[6][6];
		int cnt = 1;
		visit[tmp][idx]= true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr>=0 && nr< 6 && nc>=0 && nc<6 && map[nr][nc] == num && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new Point(nr,nc));
					cnt++;
				}
			}
		}
		if(cnt >= 3) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if(visit[i][j])map[i][j] = 0;
				}
			}
		}
	}
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
}
