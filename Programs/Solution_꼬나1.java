package Programs;

public class Solution_꼬나1 {

	public static void main(String[] args) {
		String[][] board = {{"A","B","T","T","T"},{"T","C","D","E","T"},{"T","T","T","F","T"},{"B","A","H","G","F"},{"C","D","E","F","G"}};
		System.out.println(solution(board));
	}

	static boolean[][] visit;
	static int max, N;
	static int[][] pos= {{1,0},{-1,0},{0,1},{0,-1}};
	private static int solution(String[][] board) {
		int answer = 0;
		N = 5;
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit = new boolean[N][N];
				dfs(i,j,1,false,board);
			}
		}
		answer = max;
		return answer;
	}
	private static void dfs(int r, int c, int cnt, boolean use, String[][] board) {
		max = max<cnt? cnt : max;
		
		visit[r][c] = true;
		int nr=0,nc=0;
		
		for (int i = 0; i < 4; i++) {
			nr = r + pos[i][0];
			nc = c + pos[i][1];
			if(nr>=0 && nr< N && nc>=0 && nc < N && !visit[nr][nc]) {
				if(board[nr][nc].charAt(0) > board[r][c].charAt(0)) {
					dfs(nr,nc,cnt+1,use,board);
				}
				if(!use && board[nr][nc].charAt(0) < board[r][c].charAt(0)) {
					dfs(nr,nc,cnt+1,true,board);
				}
				visit[nr][nc] = false;
			}
		}
	}
}
