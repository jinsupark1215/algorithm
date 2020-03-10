package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3023 {

	/*
	 * 1. 카드의 디자인을 완성
	 * 
	 * 2. 왼쪽 1/4 주어짐. 오른쪽,아래,대각선 대칭
	 * 
	 * 3. 구현
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R*2][C*2];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int errorr = Integer.parseInt(st.nextToken());
		int errorc = Integer.parseInt(st.nextToken());
		
		//오른쪽 복사
		for (int i = 0; i < R; i++) {
			int idx=1;
			for (int j = C-1; j >=0; j--) {
				map[i][j+idx] = map[i][j];
				idx+=2;
			}
		}
		
		//아래쪽 복사
		for (int i = 0; i < C; i++) {
			int idx=1;
			for (int j = R-1; j >=0; j--) {
				map[j+idx][i] = map[j][i];
				idx+=2;
			}
		}
		
		//대각선 복사
		for (int i = R; i < R*2; i++) {
			int idx=1;
			for (int j = C-1; j >=0; j--) {
				map[i][j+idx] = map[i][j];
				idx+=2;
			}
		}
		if(map[errorr-1][errorc-1] == '.') {
			map[errorr-1][errorc-1] = '#';
		}else {
			map[errorr-1][errorc-1]='.';
		}
		
		for (int i = 0; i < R*2; i++) {
			for (int j = 0; j < C*2; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}

