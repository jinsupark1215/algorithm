package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10708 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] target = new int[m];
		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		int[][] game = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer[] = new int[n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(target[i] == game[i][j]) {
					answer[j]++;
				}else {
					answer[target[i]-1]++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(answer[i]);
		}
	}
}
