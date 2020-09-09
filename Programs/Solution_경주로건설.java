package Programs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_경주로건설 {

	/*
	 * [카카오] 경주로 건설
	 * 
	 * 1. 최저 비용으로 경주로 건설
	 * 
	 * 2. 크기<=25
	 * 
	 * 3. bfs - visit을 가격으로해서 저가면 이동하도록
	 */
	public static void main(String[] args) {
//		int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
//		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},
		                 {0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(solution(board));
	}

	private static int solution(int[][] board) {
		int N = board.length;
		int[][] visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0,0,0});
		q.add(new int[] {0,0,1,0,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int nr =0, nc = 0,dir=0;
			//가는방향 좌
			if(cur[2]-1 == -1)dir = 3;
			else dir = cur[2]-1;
			nr = cur[0] + pos[dir][0];
			nc = cur[1] + pos[dir][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N && board[nr][nc] ==0 && visit[nr][nc] > 100*(cur[3]+1) + 500*(cur[4])) {
				visit[nr][nc] =100*(cur[3]+1) + 500*(cur[4]+1);
				q.add(new int[] {nr,nc,dir,cur[3]+1,cur[4]+1});
			}
			//가는방향
			nr = cur[0] + pos[cur[2]][0];
			nc = cur[1] + pos[cur[2]][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N && board[nr][nc] ==0 && visit[nr][nc] > 100*(cur[3]) + 500*cur[4]) {
				visit[nr][nc] =100*(cur[3]+1) + 500*cur[4];
				q.add(new int[] {nr,nc,cur[2],cur[3]+1,cur[4]});
			}
			//가는방향 우
			if(cur[2]+1 == 4)dir = 0;
			else dir = cur[2]+1;
			nr = cur[0] + pos[dir][0];
			nc = cur[1] + pos[dir][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N && board[nr][nc] ==0 && visit[nr][nc] > 100*(cur[3]+1) + 500*cur[4]) {
				visit[nr][nc] =100*(cur[3]+1) + 500*(cur[4]+1);
				q.add(new int[] {nr,nc,dir,cur[3]+1,cur[4]+1});
			}
		}
		return visit[N-1][N-1];
	}
}
