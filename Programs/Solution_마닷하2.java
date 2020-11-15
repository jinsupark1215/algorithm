package Programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_마닷하2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{3,6,8},{1,4,7},{2,1,4}}));
	}

	static int[] order;
	static boolean[] visit;
	static int N;
	static int[][] map;
	static int ans;
	public static int solution(int[][] board) {
		ans =0;
		N = board.length;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]= board[i][j];
			}
		}
		order = new int[N];
		visit = new boolean[N];
		
		nCr(0,0);
		
		return ans;
    }
	private static void nCr(int idx, int cnt) {
		if(cnt == N) {
			int sum = 0;
			for (int i = 0; i < map.length; i++) {
				sum +=map[i][order[i]];
			}
			ans = Math.max(ans, sum);
		}
		
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[i] = idx;
				nCr(idx+1,cnt+1);
				order[i] = 0;
				visit[i] = false;
			}
		}
	}
}
