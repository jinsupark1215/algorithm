package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4613 {

	/*
	 * 1. 러시아 국기같은 깃발을 만들기 위해 칠해야 하는 최소칸수
	 * 
	 * 2. N,M <=50 m 
	 * 
	 * 3. 완탐
	 */
	static int n, m, ans;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			map = new char[n][m];

			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = input.charAt(j);
				}
			}

			solve(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void solve(int r, int idx, int sum) {
		if(r == n|| idx >2)return;
		
		int W=0, B=0, R=0;
		for (int i = 0; i < m; i++) {
		if(map[r][i] == 'W')W++;
		else if(map[r][i] == 'B')B++;
		else if(map[r][i] == 'R')R++;
		}
		
			// 변경해야할 수 담기
			if(idx == 0) {
				sum += B;
				sum += R;
			}else if(idx == 1) {
				sum += W;
				sum += R;
			}else if(idx == 2) {
				sum += W;
				sum += B;
			}
			
			//종료조건
			if (idx == 2 && r == n - 1) {
				ans = Math.min(ans, sum);
				return;
			}
			
			//다른색으로 진행하거나 같은색으로 진행하거나
			solve(r+1,idx,sum);
			solve(r+1,idx+1,sum);
		
	}
}

