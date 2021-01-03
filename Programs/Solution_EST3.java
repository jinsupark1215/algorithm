package Programs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_EST3 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]
	            {{1, 28, 41, 22, 25, 79, 4}, 
	         {39, 20, 10, 17, 19, 18, 8},
	         {21, 4, 13, 12, 9, 29, 19}, 
	         {58, 1, 20, 5, 8, 16, 9},
	         {5, 6, 15, 2, 39, 8, 29},
	         {39, 7, 17, 5, 4, 49, 5},
	         {74, 46, 8, 11, 25, 2, 11}}   
	      , 19, 6));
	}

	private static int solution(int[][] map, int p, int r) {
		int answer = 0;
		
		int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit;
		int len = map.length;
		
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map.length-1; j++) {
				visit = new boolean[map.length][map.length];
				q.add(new int[] {i,j});
				q.add(new int[] {i+1,j});
				q.add(new int[] {i,j+1});
				q.add(new int[] {i+1,j+1});
				visit[i][j] = true;
				visit[i+1][j] = true;
				visit[i][j+1] = true;
				visit[i+1][j+1] = true;
				int sum = 0;
				
					for (int turn = 1; turn <= (r/2); turn++) {
						int size = q.size();
						for (int k = 0; k < size; k++) {
							int[] cur = q.poll();
							if(turn != (r/2)) {
								if(map[cur[0]][cur[1]] <= p) {
									sum++;
								}
							}else {
								if(map[cur[0]][cur[1]] <= (p/2)) {
									sum++;
								}
							}
							
							for (int l = 0; l < 4; l++) {
								int nr = cur[0] + pos[l][0];
								int nc = cur[1] + pos[l][1];
								if(nr>=0 && nr< len && nc>=0 && nc<len && !visit[nr][nc]) {
									visit[nr][nc] = true;
									q.add(new int[] {nr,nc});
								}
							}
						}
					}
					answer = Math.max(answer, sum);
					q.clear();
			}
		}
		
		
		return answer;
	}
}
