package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2805 {

	/*
	 * 1. 정사각형의 다이아 부분의 합을 구하라
	 * 
	 * 2.  N은 49 이하 홀수
	 * 
	 * 3. 모든값을 더하고 선택되지 않은 부분을 인덱스처리를 통해 뺴기
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					int num =input.charAt(j)-'0';
					map[i][j] = num;
					sum += num;
				}
			}
			
			int idx = 0;
			//왼쪽위
			idx = (N/2)-1;
			for (int i = 0; i < N/2; i++) {
				for (int j = idx; j >=0; j--) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx--;
			}
			
			//오른쪽위
			idx = (N/2)+1;
			for (int i = 0; i < N/2; i++) {
				for (int j = idx; j <N; j++) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx++;
			}
			
			//왼쪽아래
			idx = (N/2)-1;
			for (int i = N-1; i > (N/2); i--) {
				for (int j = idx; j >=0; j--) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx--;
			}
			
			//오른쪽아래
			idx = (N/2)+1;
			for (int i = N-1; i > (N/2); i--) {
				for (int j = idx; j <N; j++) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx++;
			}
			
			System.out.println("#" + testcase + " " + sum);
		}
	}
}

