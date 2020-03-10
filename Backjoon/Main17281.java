package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17281 {

	/*
	 * 1. 순서를 정해서 쳤을 때 얻을 수 있는 최대 점수
	 * 
	 * 2. 1번선수는 4번타자로 미리 정해놈 2<=N<=50
	 * 
	 * 3. 
	 * 조합을 통해 순서 정하기
	 * 점수를 체크하고 4가 되면 +1로 점수얻기
	 * 
	 */
	static int n, ans;
	static int[][] score;
	static int[] order;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = 0;
		score = new int[n][9];
		//이닝 수 저장
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//순서 배열
			order = new int[9];
			visit = new boolean[9];
			order[3] = 0;
			visit[3] = true;
			nCr(1);
			
			System.out.println(ans);
	}

	//순서짜는 조합
	private static void nCr(int idx) {
		if(idx == 9) {
			ans = Math.max(ans, cal());
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[i] = idx;
				nCr(idx+1);
				visit[i] = false;
			}
		}
	}

	private static int cal() {
		int start = 0;	 // 시작점
		int sum = 0; 	// 총점 
		for (int i = 0; i < n; i++) {
			int[] base = new int[5];
			while(base[0] <3) {
				// 
				for (int j = 0; j < score[i][order[start]]; j++) {
					base[4] += base[3];
					base[3] = base[2];
					base[2] = base[1];
					base[1] = 0;
				}
				base[score[i][order[start]]]++;
				
				if(start == 8) {
					start = 0;
				}else {
					start++;
				}
			}
			sum += base[4];
		}
		return sum;
	}
}

