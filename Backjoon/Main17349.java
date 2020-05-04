package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17349 {

	/*
	 * [백준] 1루수가 누구야
	 * 
	 * 1. 1루수가 누구인지 판단
	 * 
	 * 2. A <= 9
	 * 
	 * 3. 각 한명마다 거짓말을 하고있다는 전제로 판단
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[9][2];
		int ans = -1;
		StringTokenizer st;
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] chk;
		
		fin:
		for (int i = 0; i < 9; i++) {
			chk = new boolean[10];
			
			arr[i][0] = 1-arr[i][0];
			int tmp = 0;
			
			
			for (int j = 0; j < 9; j++) {
				if(arr[j][0] == 1) {
					if((tmp ==0 || tmp == arr[j][1]) && !chk[arr[j][1]]) {
						tmp = arr[j][1];
					}else {
						tmp = -1;
					}
				}else {
					if(tmp == arr[j][1]) {
						tmp = -1;
					}
					chk[arr[j][1]] = true;
				}
			}
			
			if(tmp == 0) {
				for (int j = 1; j < 10; j++) {
					if(!chk[j]) {
						if(tmp == 0) {
							tmp = j;
						}else {
							ans = -1;
							break fin;
						}
					}
				}
			}
			if(tmp >0) {
				if(ans == -1) {
					ans = tmp;
				}else {
					ans = -1;
					break;
				}
			}
			arr[i][0] = 1-arr[i][0];
		}
		System.out.println(ans);
	}
}
