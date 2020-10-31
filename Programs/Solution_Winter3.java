package Programs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Winter3 {

	public static void main(String[] args) {
	
		int[][] v = {{0,0,1,1},{1,1,1,1},{2,2,2,1},{0,0,0,2}};
		System.out.println(Arrays.toString(solution(v)));
	}
	static boolean[][] visited;
	static int n;
	static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
	public static int[] solution(int[][] v) {
		int[] answer = {0,0,0};
		n = v.length;
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					answer[v[i][j]]+=1;
					bfs(i,j,v[i][j],v);
				}
			}
		}
		
		return answer;
	}
	
	public static void bfs(int r,int c,int veg,int[][] v) {

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c));
		visited[r][c]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nr = p.r + pos[dir][0];
				int nc = p.c + pos[dir][1];
				if(nr >= n || nr < 0 || nc >= n || nc < 0) {
					continue;
				}
				if(v[nr][nc]==veg && !visited[nr][nc]) {
					q.offer(new Point(nr,nc));
					visited[nr][nc]=true;
				}
			}
		}
	}
	public static class Point{
		int r;
		int c;
		Point(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
}
