package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18188_다오의_데이트 {

	/*
	 * 1. 다오가 디지니가 만날수 있는가?
	 * 
	 * 2. 마리드가 제시한 번째의 움직임을 택해서 가봐야한다. 맨 왼쪽위가 1,1 오른쪽아래가 H,W
	 * 
	 * 3. DFS를 이용해서 갈수 있는 방향을 다 판단
	 */
	static int[][] pos = {{-1,0},{0,-1},{1,0},{0,1}};
	static String answer, dir;
	static StringBuilder sb;
	static int N,sr,sc,er,ec, H, W;
	static char[][] map, order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		sr =0;sc=0;er=0;ec=0;
		answer = "NO";
		sb = new StringBuilder();
		
		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			for (int j = 0; j < W; j++) {
				char tmp = input.charAt(j);
				map[i][j] = tmp;
				if(tmp == 'D') {
					sr = i;
					sc = j;
				}else if(tmp == 'Z') {
					er = i;
					ec = j;
				}
			}
		}
		N = Integer.parseInt(br.readLine());
		order = new char[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = st.nextToken().charAt(0);
			order[i][1] = st.nextToken().charAt(0);
		}
		dfs(sr,sc,0);
		
		if(answer.equals("NO")) {
		System.out.println(answer);
		}else {
			System.out.println(answer);
			System.out.println(dir);
		}
	}
	private static void dfs(int r, int c, int idx) {
		
		if(r ==er && c == ec) {
			answer = "YES";
			dir = sb.toString();
			return;
		}
		
		if(idx == N) return;
		
		for (int i = 0; i < 2; i++) {
			int nr=0;int nc=0;
			switch (order[idx][i]) {
			case 'W':
				nr = r + pos[0][0];
				nc = c + pos[0][1];
				sb.append('W');
				break;
			case 'A':
				nr = r + pos[1][0];
				nc = c + pos[1][1];
				sb.append('A');
				break;
			case 'S':
				nr = r + pos[2][0];
				nc = c + pos[2][1];
				sb.append('S');
				break;
			case 'D':
				nr = r + pos[3][0];
				nc = c + pos[3][1];
				sb.append('D');
				break;

			}
			if(nr>=0 && nc>=0 && nr< H && nc < W && map[nr][nc] != '@') {
			dfs(nr,nc,idx+1);
			sb.delete(sb.length()-1, sb.length());
			}else {
				sb.delete(sb.length()-1, sb.length());
			}
		}
		
	}
}
