package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19235 {

	/*
	 * [백준] 모노미노도미노
	 * 
	 * 1. 터지는 행과 열의 갯수 (점수)와 남은 타일의 갯수를 구하여라
	 * 
	 * 2. N <= 10000
	 * 
	 * 3. 구현
	 */
	static int N, ans1, ans2;
	static int[][] green, blue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		green = new int[6][4];
		blue = new int[4][6];
		ans1 = 0;ans2 = 0;
		
		StringTokenizer st;
		int type,r,c;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			go(type,r,c);
		}
		
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if(green[i][j] !=0)ans2++;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 6; j++) {
				if(blue[i][j] !=0)ans2++;
			}
		}
		
		System.out.println(ans1);
		System.out.println(ans2);
	}
	private static void go(int type, int r, int c) {
		int idx = 0;
		
		if(type == 1) {
			//그린에 두기
			idx = 0;
			for (int i = 0; i < 6; i++) {
				if(green[i][c] !=0) {
					idx = i;
					break;
				}
			}
			if(idx == 0)green[5][c] = 1;
			else green[idx-1][c] = 1;
			
			//블루에 두기
			idx = 0;
			for (int i = 0; i < 6; i++) {
				if(blue[r][i] !=0) {
					idx = i;
					break;
				}
			}
			if(idx == 0)blue[r][5] = 1;
			else blue[r][idx-1] = 1;
			
		}else if(type == 2) {
			//그린에 두기
			idx = 0;
			for (int i = 0; i < 6; i++) {
				if(green[i][c] !=0 || green[i][c+1] !=0) {
					idx = i;
					break;
				}
			}
			if(idx == 0) {
				green[5][c] = 2;
				green[5][c+1] = 2;
			}else {
				green[idx-1][c] = 2;
				green[idx-1][c+1] = 2;
			}
			//블루에 두기
			idx = 0;
			for (int i = 0; i < 6; i++) {
				if(blue[r][i] !=0 ) {
					idx = i;
					break;
				}
			}
			if(idx == 0) {
				blue[r][5] = 2;
				blue[r][4] = 2;
			}else {
				blue[r][idx-1] = 2;
				blue[r][idx-2] = 2;
			}
			
		}else if(type == 3) {
			//그린에 두기
			idx = 0;
			for (int i = 0; i < 6; i++) {
				if(green[i][c] !=0) {
					idx = i;
					break;
				}
			}
			if(idx == 0) {
				green[5][c] = 3;
				green[4][c] = 3;
			}else {
				green[idx-1][c] = 3;
				green[idx-2][c] = 3;
			}
			//블루에 두기
			idx = 0;
			for (int i = 0; i < 6; i++) {
				if(blue[r][i] !=0 || blue[r+1][i] !=0 ) {
					idx = i;
					break;
				}
			}
			if(idx == 0) {
				blue[r][5] = 3;
				blue[r+1][5] = 3;
			}else {
				blue[r][idx-1] = 3;
				blue[r+1][idx-1] = 3;
			}
		}
		
		chkFullGreen();
		int tmp = chkZeroOneGreen();
		if(tmp ==1) {
			for (int i = 0; i < 4; i++) {
				green[5][i] = 0;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 5; j > 0; j--) {
					green[j][i] = green[j-1][i];
				}
				green[0][i] = 0;
			}
		}else if( tmp == 2) {
			for (int i = 0; i < 4; i++) {
				green[5][i] = 0;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 5; j > 0; j--) {
					green[j][i] = green[j-1][i];
				}
				green[0][i] = 0;
			}
			for (int i = 0; i < 4; i++) {
				green[5][i] = 0;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 5; j > 0; j--) {
					green[j][i] = green[j-1][i];
				}
				green[0][i] = 0;
			}
		}
		
		//블루
		chkFullBlue();
		tmp = chkZeroOneBlue();
		if(tmp ==1) {
			for (int i = 0; i < 4; i++) {
				blue[i][5] = 0;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 5; j > 0; j--) {
					blue[i][j] = blue[i][j-1];
				}
				blue[i][0] = 0;
			}
			
		}else if( tmp == 2) {
			for (int i = 0; i < 4; i++) {
				blue[i][5] = 0;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 5; j > 0; j--) {
					blue[i][j] = blue[i][j-1];
				}
				blue[i][0] = 0;
			}
			for (int i = 0; i < 4; i++) {
				blue[i][5] = 0;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 5; j > 0; j--) {
					blue[i][j] = blue[i][j-1];
				}
				blue[i][0] = 0;
			}
		}
	}
	private static void chkFullBlue() {
		int cnt;
		boolean flag = false;
		for (int i = 2; i < 6; i++) {
			cnt = 0;
			for (int j = 0; j < 4; j++) {
				if(blue[j][i] !=0)cnt++;
			}
			if(cnt== 4) {
				for (int j = 0; j < 4; j++) {
					blue[j][i] = 0;
				}
				ans1++;
				flag = true;
				
			}
		}
		
		if(flag) {
			//내리기
			int idx;
			for (int i = 4; i >= 0; i--) {
				for (int j = 0; j < 4; j++) {
					if(blue[j][i] ==1 || blue[j][i] == 2) {
						idx = 0;
						for (int k = i+1; k < 6; k++) {
							if(blue[j][k] !=0) {
								idx = k;
								break;
							}
						}
						if(idx == 0) {
							blue[j][5] = blue[j][i];
							blue[j][i] = 0;
						}
						else {
							if(idx -1 != i) {
							blue[j][idx-1] = blue[j][i];
							blue[j][i] = 0;
							}
						}
					}else if(blue[j][i] == 3) {
						idx = 0;
						for (int k = i+1; k < 6; k++) {
							if(blue[j][k] !=0 || blue[j+1][k] !=0 ) {
								idx = k;
								break;
							}
						}
						if(idx == 0) {
							blue[j][5] = 3;
							blue[j+1][5] = 3;
							blue[j][i] = 0;
							blue[j+1][i] = 0;
						}else {
							if(idx -1 != i) {
							blue[j][idx-1] = 3;
							blue[j+1][idx-1] = 3;
							blue[j][i] = 0;
							blue[j+1][i] = 0;
							}
						}
						j++;
					}
				}
			}
			chkFullBlue();
		}
	}
	private static int chkZeroOneBlue() {
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if(blue[j][i] !=0) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
	private static void chkFullGreen() {
		int cnt;
		boolean flag = false;
		for (int i = 2; i < 6; i++) {
			cnt = 0;
			for (int j = 0; j < 4; j++) {
				if(green[i][j] !=0)cnt++;
			}
			if(cnt== 4) {
				for (int j = 0; j < 4; j++) {
					green[i][j] = 0;
				}
				ans1++;
				flag = true;
				
			}
		}
		
		if(flag) {
			int idx;
			//내리기
			for (int i = 4; i >= 0; i--) {
				for (int j = 0; j < 4; j++) {
					if(green[i][j] ==1 || green[i][j] == 3) {
						idx = 0;
						for (int k = i+1; k < 6; k++) {
							if(green[k][j] !=0) {
								idx = k;
								break;
							}
						}
						if(idx == 0) {
							green[5][j] = green[i][j];
							green[i][j] = 0;
						}
						else {
							if(idx -1 != i) {
							green[idx-1][j] = green[i][j];
							green[i][j] = 0;
							}
						}
					}else if(green[i][j] == 2) {
						idx = 0;
						for (int k = i+1; k < 6; k++) {
							if(green[k][j] !=0 || green[k][j+1] !=0 ) {
								idx = k;
								break;
							}
						}
						if(idx == 0) {
							green[5][j] = 2;
							green[5][j+1] = 2;
							green[i][j] = 0;
							green[i][j+1] = 0;
						}else {
							if(idx -1 != i) {
							green[idx-1][j] = 2;
							green[idx-1][j+1] = 2;
							green[i][j] = 0;
							green[i][j+1] = 0;
							}
						}
						j++;
					}
				}
			}
			chkFullGreen();
		}
		
	}
	private static int chkZeroOneGreen() {
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if(green[i][j] !=0) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
}
