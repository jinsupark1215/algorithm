package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2115_벌꿀채취 {

	/*
	 * 1. 벌꿀 채취했을 때 최대 이득
	 * 
	 * 2. M <=N <=10, C는 10~30
	 * 
	 * 3.
	 * 3-1 꿀통을 선택하고
	 * 3-2 선택한 꿀통에서 얻을 수 있는 최대 이익
	 */
	static int N,M,C,ans;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			dfs(0,0,0,0,list);
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void dfs(int r, int c, int cnt, int sum, ArrayList<Integer> list) {
		if(r >= N)return;
		
		ArrayList<Integer> tmp = new ArrayList<>(list);
		tmp.add(r);
		tmp.add(c);
		
		if (cnt < 2) {
			// 선택가능
			if (c + M - 1 < N) {
				int tmpsum = sum+benefit(r,c);
				if (tmpsum > ans) {
					ans = tmpsum;
				}
                //col이 N보다 커지면 다음 low로 넘어가야한다.
				dfs((r + (c + M) / N), ((c + M) % N), cnt + 1, sum + benefit(r, c), tmp);
			}

			// 선택하지 않음
			dfs(r + (c + 1) / N, (c + 1) % N, cnt, sum, tmp);
		}
	}

	//r,c에서 M개의 꿀통을 선택하여 얻을 수 있는 최대의 이익을 리턴한다.
	static int benefit(int r, int c) {

		//M개의 꿀통중에 선택 할 수 있는 경우의 수는 2의 M승이다. 비트마스크 구현
		int num = 1 << M;
		int max = 0;
		
		//M개의 꿀통 중에 모든 선택에 대해서
		for (int i = 0; i < num; i++) {
			int bit = i;
			int sum = 0;
			int benefit = 0;
			for (int j = 0; j < M; j++, bit >>= 1) {
				//선택된 꿀통의 합과 가격 각각 구한다.
				if ((bit & 1) == 1) {
					sum += map[r][c + j];
					benefit += (map[r][c + j] * map[r][c + j]);
				}
			}
			//선택된 꿀의 양은 K값을 넘지지 않고 이윤이 최대라면 갱신한다
			if (sum <= C && benefit >= max)
				max = benefit;
		}
		return max;
	}
}
