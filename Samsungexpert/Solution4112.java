package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4112 {

	/*
	 * [삼성] 이상한 피라미드
	 * 
	 * 1. 보물을 찾을때까지 걸리는 최소시간
	 * 
	 * 2. a,b <=10000
	 * 
	 * 3. 각 인접리스트 구해놓고 bfs해서 시간 찾기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] sero = new int[10001];
		int[] garo = new int[10001];
		int cnt = 1;
		int height = 1;
		int idx = 1;
		
		while(height <= 10000) {
			for (int i = 0; i < cnt; i++) {
				sero[height] = cnt;
				garo[height] = i;
				height++;
				if(height > 10000)break;
			}
			cnt++;
		}
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			if(start > end) {
				int tmp = start;
				start = end;
				end = tmp;
			}
			
			if(sero[start] == sero[end]) {
				ans = Math.abs(end - start);
			}else {
				ans = Math.abs(sero[start]-sero[end]);
				
				int maxgaro = garo[start] + ans;
				if(garo[start] > garo[end]) {
					ans += Math.abs(garo[end] - garo[start]);
				}
				if(garo[end] > maxgaro) {
					ans += Math.abs(garo[end] - maxgaro);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
