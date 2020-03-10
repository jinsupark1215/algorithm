package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1824 {

	/*
	 * 1. 주어진 프로그램이 끝날 수 있는지 없는지 판단.
	 * 
	 * 2. R,C는 20이하
	 * 
	 * 3. bfs로 최대 400번 이상 넘으면 못가는걸로체크
	 */
	static int[][] pos = {{0,1},{0,-1},{1,0},{-1,0}};
	static String ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] map = new char[R][C];
			ArrayList<Point> arr = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				String input = br.readLine();
				for (int j = 0; j < C; j++) {
					char tmp = input.charAt(j);
					map[i][j] = tmp;
					if(tmp == '@') {
						arr.add(new Point(i,j,0,0,0));
					}
				}
			}
			ans = "NO";
			Queue<Point> q = new LinkedList<>();
			
			if(map[0][0]-'0' <10 && map[0][0]-'0'>=0) {
				q.add(new Point(0,0,0,map[0][0]-'0',0));
			}else {
				q.add(new Point(0,0,0,0,0));
			}
			
			if(arr.size() ==0)q.clear();
			while(!q.isEmpty()) {
				Point p = q.poll();
				
				for (int i = 0; i < arr.size(); i++) {
				if(p.r == arr.get(i).r && p.c == arr.get(i).c) {
					ans = "YES";
					break;
				}
				}
				if(p.cnt > 400 || q.size() > 100)break;
				int nr=0;int nc = 0;
				if(map[p.r][p.c]== '<' ) {
					nr = p.r + pos[1][0];
					nc = p.c + pos[1][1];
					if(nc <0)q.add(new Point(nr,C-1,1,p.memory,p.cnt+1));
					else q.add(new Point(nr,nc,1,p.memory,p.cnt+1));
				}else if(map[p.r][p.c]== '>') {
					nr = p.r + pos[0][0];
					nc = p.c + pos[0][1];
					if(nc ==C)q.add(new Point(nr,0,0,p.memory,p.cnt+1));
					else q.add(new Point(nr,nc,0,p.memory,p.cnt+1));
				}else if(map[p.r][p.c]== '^') {
					nr = p.r + pos[3][0];
					nc = p.c + pos[3][1];
					if(nr < 0)q.add(new Point(R-1,nc,3,p.memory,p.cnt+1));
					else q.add(new Point(nr,nc,3,p.memory,p.cnt+1));
				}else if(map[p.r][p.c]== 'v') {
					nr = p.r + pos[2][0];
					nc = p.c + pos[2][1];
					if(nr == R)q.add(new Point(0,nc,2,p.memory,p.cnt+1));
					else q.add(new Point(nr,nc,2,p.memory,p.cnt+1));
				}else if(map[p.r][p.c]== '_') {
					if(p.memory == 0) {
					nr = p.r + pos[0][0];
					nc = p.c + pos[0][1];
					if(nc ==C)q.add(new Point(nr,0,0,p.memory,p.cnt+1));
					else q.add(new Point(nr,nc,0,p.memory,p.cnt+1));
					}else {
						nr = p.r + pos[1][0];
						nc = p.c + pos[1][1];
						if(nc <0)q.add(new Point(nr,C-1,1,p.memory,p.cnt+1));
						else q.add(new Point(nr,nc,1,p.memory,p.cnt+1));
					}
				}else if(map[p.r][p.c]== '|') {
					if(p.memory == 0) {
						nr = p.r + pos[2][0];
						nc = p.c + pos[2][1];
						if(nr == R)q.add(new Point(0,nc,2,p.memory,p.cnt+1));
						else q.add(new Point(nr,nc,2,p.memory,p.cnt+1));
					}else {
						nr = p.r + pos[3][0];
						nc = p.c + pos[3][1];
						if(nr < 0)q.add(new Point(R-1,nc,3,p.memory,p.cnt+1));
						else q.add(new Point(nr,nc,3,p.memory,p.cnt+1));
					}
				}else if(map[p.r][p.c]== '?') {
					for (int i = 0; i < 4; i++) {
						nr = p.r + pos[i][0];
						nc = p.c + pos[i][1];
						if(nc ==C)q.add(new Point(nr,0,0,p.memory,p.cnt+1));
						else if(nc <0)q.add(new Point(nr,C-1,1,p.memory,p.cnt+1));
						else if(nr == R)q.add(new Point(0,nc,2,p.memory,p.cnt+1));
						else if(nr < 0)q.add(new Point(R-1,nc,3,p.memory,p.cnt+1));
						else q.add(new Point(nr,nc,i,p.memory,p.cnt+1));
					}
				}else if(map[p.r][p.c]== '+') {
					nr = p.r + pos[p.dir][0];
					nc = p.c + pos[p.dir][1];
					if(nc ==C)q.add(new Point(nr,0,0,p.memory,p.cnt+1));
					else if(nc <0)q.add(new Point(nr,C-1,1,p.memory,p.cnt+1));
					else if(nr == R)q.add(new Point(0,nc,2,p.memory,p.cnt+1));
					else if(nr < 0)q.add(new Point(R-1,nc,3,p.memory,p.cnt+1));
					else {
						if(p.memory == 15) {
							q.add(new Point(nr,nc,p.dir,0,p.cnt+1));
						}else	q.add(new Point(nr,nc,p.dir,p.memory+1,p.cnt+1));
					}
				}else if(map[p.r][p.c]== '-') {	
					nr = p.r + pos[p.dir][0];
					nc = p.c + pos[p.dir][1];
					if(nc ==C)q.add(new Point(nr,0,0,p.memory,p.cnt+1));
					else if(nc <0)q.add(new Point(nr,C-1,1,p.memory,p.cnt+1));
					else if(nr == R)q.add(new Point(0,nc,2,p.memory,p.cnt+1));
					else if(nr < 0)q.add(new Point(R-1,nc,3,p.memory,p.cnt+1));
					else {
						if(p.memory == 0) {
							q.add(new Point(nr,nc,p.dir,15,p.cnt+1));
						}else	q.add(new Point(nr,nc,p.dir,p.memory-1,p.cnt+1));
					}
				}else if(map[p.r][p.c]== '.' ){
						nr = p.r + pos[p.dir][0];
						nc = p.c + pos[p.dir][1];
						if(nc ==C)q.add(new Point(nr,0,0,p.memory,p.cnt+1));
						else if(nc <0)q.add(new Point(nr,C-1,1,p.memory,p.cnt+1));
						else if(nr == R)q.add(new Point(0,nc,2,p.memory,p.cnt+1));
						else if(nr < 0)q.add(new Point(R-1,nc,3,p.memory,p.cnt+1));
						else q.add(new Point(nr,nc,p.dir,p.memory,p.cnt+1));
				}else {
					nr = p.r + pos[p.dir][0];
					nc = p.c + pos[p.dir][1];
					if(nc ==C)q.add(new Point(nr,0,0,p.memory,p.cnt+1));
					else if(nc <0)q.add(new Point(nr,C-1,1,p.memory,p.cnt+1));
					else if(nr == R)q.add(new Point(0,nc,2,p.memory,p.cnt+1));
					else if(nr < 0)q.add(new Point(R-1,nc,3,p.memory,p.cnt+1));
					else q.add(new Point(nr,nc,p.dir,map[p.r][p.c]-'0' ,p.cnt+1));
				}
			}
			System.out.println("#" + testcase + " " + ans);
			
		}
	}
	static class Point{
		int r, c, dir, memory, cnt;

		public Point(int r, int c, int dir, int memory, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.memory = memory;
			this.cnt = cnt;
		}



	}
}