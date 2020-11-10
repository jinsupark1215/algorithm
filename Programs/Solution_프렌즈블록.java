package Programs;

public class Solution_프렌즈블록 {
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		int cnt = 1;

		while (true) {
			cnt = 0;
			boolean[][] visit = new boolean[m][n];

			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] != ' ' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j]
							&& map[i][j] == map[i + 1][j + 1]) {
						if (!visit[i][j]) {
							visit[i][j] = true;
							cnt++;
						}
						if (!visit[i][j + 1]) {
							visit[i][j + 1] = true;
							cnt++;
						}
						if (!visit[i + 1][j]) {
							visit[i + 1][j] = true;
							cnt++;
						}
						if (!visit[i + 1][j + 1]) {
							visit[i + 1][j + 1] = true;
							cnt++;
						}
					}
				}
			}
			if (cnt == 0)
				break;

			answer += cnt;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j])
						map[i][j] = ' ';
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = m - 1; j > 0; j--) {
					if (map[j][i] == ' ') {
						for (int k = j - 1; k >= 0; k--) {
							if (map[k][i] != ' ') {
								map[j][i] = map[k][i];
								map[k][i] = ' ';
								break;
							}
						}
					}
				}
			}

		}
		return answer;
	}
}
