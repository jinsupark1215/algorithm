package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18808 {

	/*
	 * 1. 스티커가 붙여진 칸의 합
	 * 
	 * 2. N, M<=40, K <=100
	 * 
	 * 3. 구현
	 */
	static int N,M,K,ans, R, C;
	static int[][] map, monun;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = 0;
		
		for (int i = 0; i < K; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			monun = new int[R][C];
			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < C; k++) {
					monun[j][k] = Integer.parseInt(st.nextToken());
					if(monun[j][k] ==1)cnt++;
				}
			}
			
			for (int j = 0; j < 4; j++) {

				if (solve()) {
					ans += cnt;
					break;
				} else {
					rotate();
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void rotate() {
		int tmp = R;
		R = C;
		C = tmp;
		int[][] tmpmap = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmpmap[i][j] = monun[C-1-j][i];
			}
		}
		
		monun = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				monun[i][j] = tmpmap[i][j];
			}
		}
	}

	private static boolean solve() {
		boolean flag = false;
		fin: 
		for (int k = 0; k <= N - R; k++) {
			for (int l = 0; l <= M - C; l++) {
				flag = true;

				for (int i = k; i < k + R; i++) {
					for (int j = l; j < l + C; j++) {
						if (map[i][j] == 1 && monun[i - k][j - l] == 1) {
							flag = false;
						}
					}
				}

				if (flag) {
					for (int i = k; i < k + R; i++) {
						for (int j = l; j < l + C; j++) {
							if (monun[i - k][j - l] == 1) {
								map[i][j] = monun[i - k][j - l];
							}
						}
					}
					break fin;
				}
			}
		}
	
		if(flag)return true;
		else return false;
	
	}

}
