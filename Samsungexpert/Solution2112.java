package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2112 {

	/*
	 * [삼성] 보호필름
	 * 1. 최소 약품 투여를 통해서 모두 통과하는 경우
	 * 
	 * 2. D <= 13 W <=20
	 * 
	 * 3. DFS
	 * 조건에 충족하는지 판단하는 함수 - 어떤행을 선택할지 A, B중 다넣기 -> 완탐
	 */
	static int D, W, K, ans;
	static int[][] map, tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			
			map = new int[D][W];
			tmp = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j]  = tmp[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			if(chk()) {
				ans = 0;
			}else {
				go(0,0);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void go(int cnt, int layer) {
		
		//종료조건
		if(cnt >= ans) return;
		
		if(layer == D) {
			if(chk())ans = ans> cnt? cnt : ans;
			return;
		}
		
		// X
		go(cnt,layer+1);
		
		//A
		for (int i = 0; i < W; i++) {
			tmp[layer][i] = 0;
		}
		go(cnt+1, layer+1);

		//B
		for (int i = 0; i < W; i++) {
			tmp[layer][i] = 1;
		}
		go(cnt+1, layer+1);
		
		// 돌아가기
		for (int i = 0; i < W; i++) {
			tmp[layer][i] = map[layer][i];
		}
	}
	private static boolean chk() {
		for (int i = 0; i < W; i++) {
			int cnt =1;
			int num = tmp[0][i];
			boolean flag = false;
			
			for (int j = 1; j < D; j++) {
				if(num == tmp[j][i]) {
					cnt++;
				}else {
					num = tmp[j][i];
					cnt = 1;
				}
				
				if(cnt == K) {
					flag = true;
					break;
				}
			}
			if(!flag) return false;
		}
		return true;
	}
}
