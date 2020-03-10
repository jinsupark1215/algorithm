package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13459{

	/*
	 * 1. 최소 몇번만에 R이 구멍을 통해 탈출하는가
	 * 
	 * 2. N,M <=10, 10번 이하로 못움직이면 -1, 같이 빠지면 -1
	 * 
	 * 3. 완탐, 조건을 통해 시간 감소
	 */
	static int N, M, ans;
	static char[][] arr;
	static Boolean red,blue;
	static int[][] pos = {{1,0},{-1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		arr = new char[N][M];
		red = false;blue = false;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			dfs(1,i,arr);
		}
		
		System.out.println(ans);
	}

	private static void dfs(int cnt, int dir, char[][] tmp) {
		if(cnt > 10) return;
		red = false;blue = false;
		
		
		//배열 복사
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[i][j];
			}
		}
		
		// 옮기기
		if (dir == 0) {
			for (int i = 0; i < M; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] == 'R' || map[j][i] == 'B') {
						for (int k = 1; k < N; k++) {
							int nr = j + pos[dir][0] * k;
							int nc = i + pos[dir][1] * k;
							if (nr < N) {
								if (map[nr][nc] == '.') {
									map[nr][nc] = map[nr-1][nc];
									map[nr-1][nc] = '.';
								} else if (map[nr][nc] == 'O') {
									if (map[nr-1][nc] == 'R') {
										red = true;
										map[nr-1][nc] = '.';
										break;
									} else if (map[nr-1][nc] == 'B'){
										blue = true;
										map[nr-1][nc] = '.';
										break;
									}else break;
								}else break;
							} else
								break;
						}
					}
				}
			}
		}else if( dir ==1) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 'R' || map[j][i] == 'B') {
						for (int k = 1; k < N; k++) {
							int nr = j + pos[dir][0] * k;
							int nc = i + pos[dir][1] * k;
							if (nr >= 0) {
								if (map[nr][nc] == '.') {
									map[nr][nc] = map[nr+1][nc];
									map[nr+1][nc] = '.';
								} else if (map[nr][nc] == 'O') {
									if (map[nr+1][nc] == 'R') {
										red = true;
										map[nr+1][nc] = '.';
										break;
									} else if (map[nr+1][nc] == 'B'){
										blue = true;
										map[nr+1][nc] = '.';
										break;
									}else break;
								}else break;
							} else
								break;
						}
					}
				}
			}
		}else if( dir ==2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'R' || map[i][j] == 'B') {
						for (int k = 1; k < M; k++) {
							int nr = i + pos[dir][0] * k;
							int nc = j + pos[dir][1] * k;
							if (nc >=0) {
								if (map[nr][nc] == '.') {
									map[nr][nc] = map[nr][nc+1];
									map[nr][nc+1] = '.';
								} else if (map[nr][nc] == 'O') {
									if (map[nr][nc+1] == 'R') {
										red = true;
										map[nr][nc+1] = '.';
										break;
									} else if (map[nr][nc+1] == 'B'){
										blue = true;
										map[nr][nc+1] = '.';
										break;
									}else break;
								}else break;
							} else
								break;
						}
					}
				}
			}
		}else if( dir ==3) {
			for (int i = 0; i < N; i++) {
				for (int j = M-1; j >=0; j--) {
					if (map[i][j] == 'R' || map[i][j] == 'B') {
						for (int k = 1; k < M; k++) {
							int nr = i + pos[dir][0] * k;
							int nc = j + pos[dir][1] * k;
							if (nc < M) {
								if (map[nr][nc] == '.') {
									map[nr][nc] = map[nr][nc-1];
									map[nr][nc-1] = '.';
								} else if (map[nr][nc] == 'O') {
									if (map[nr][nc-1] == 'R') {
										red = true;
										map[nr][nc-1] = '.';
										break;
									} else if (map[nr][nc-1] == 'B'){
										blue = true;
										map[nr][nc-1] = '.';
										break;
									}else break;
								}else break;
							} else
								break;
						}
					}
				}
			}
		}
		
		if(red && !blue) {
			ans = 1;
			return;
		}
		else if(red && blue ||!red && blue) {
			return;
		}
		//진행
		for (int i = 0; i < 4; i++) {
			dfs(cnt+1,i,map);
		}
	}
}

