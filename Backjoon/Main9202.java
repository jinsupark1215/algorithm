package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9202 {

	/*
	 * [백준] Boggle
	 * 1. 얻을 수 있는 최대 점수, 가장 긴 단어, 찾은 단어의 갯수 출력
	 * 
	 * 2. 사전수 < 300,000 , b<30
	 * 
	 * 3. trie 사용 -> 트리같은 개념, 자료구조 확인
	 */

	static int[] table = { -1, 0, 0, 1, 1, 2, 3, 5, 11 };
	static int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
	static Trie root;
	static char[][] board;
	static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int W = Integer.parseInt(br.readLine());
		String[] word = new String[W];
		for (int i = 0; i < W; i++) {
			word[i] = br.readLine();
		}
		br.readLine();
		
		board = new char[4][];
		check = new boolean[4][4];
		int B = Integer.parseInt(br.readLine());
		while (B-- > 0) {
			for (int i = 0; i < 4; i++) {
				board[i] = br.readLine().toCharArray();
				for (int j = 0; j < 4; j++) {
					board[i][j] -= 65;
				}
			}
			if(B != 0)
			br.readLine();
			
			root = new Trie();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					root.insert(i, j);
				}
			}
			int score, cnt;
			score = cnt = 0;
			String longest = "";
			for (int i = 0; i < W; i++) {
				if (root.find(word[i], 0)) {
					score += table[word[i].length()];
					if (longest.length() < word[i].length()
							|| (longest.length() == word[i].length() && longest.compareTo(word[i]) > 0)) {
						longest = word[i];
					}
					cnt++;
				}
			}
			sb.append(score + " " + longest + " " + cnt + "\n");
		}

		System.out.print(sb);
	}
	static class Trie {
		Trie[] trie;

		Trie() {
			trie = new Trie[26];
		}

		void insert(int x, int y) {
			check[x][y] = true;
			if (trie[board[x][y]] == null) {
				trie[board[x][y]] = new Trie();
			}
			trie[board[x][y]].insert(x, y, 1);
			check[x][y] = false;
		}

		void insert(int x, int y, int depth) {
			if (depth == 8) {
				return;
			}
			for (int i = 0; i < 8; i++) {
				int nx = x + pos[i][0];
				int ny = y + pos[i][1];
				if (nx == -1 || nx == 4 || ny == -1 || ny == 4 || check[nx][ny]) {
					continue;
				}
				if (trie[board[nx][ny]] == null) {
					trie[board[nx][ny]] = new Trie();
				}
				check[nx][ny] = true;
				trie[board[nx][ny]].insert(nx, ny, depth + 1);
				check[nx][ny] = false;
			}
		}

		boolean find(String str, int idx) {
			if (idx == str.length()) {
				return true;
			} else if (trie[str.charAt(idx) - 65] == null) {
				return false;
			} else {
				return trie[str.charAt(idx) - 65].find(str, idx + 1);
			}
		}
	}
}
