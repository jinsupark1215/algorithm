package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main8979 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
			map[i][3] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < n; i++) {
			int idx = 1;
			for (int j = 0; j < n; j++) {
				if(i==j)continue;
				if(map[i][1] < map[j][1]) {
					idx++;
				}else if(map[i][1] == map[j][1]) {
					if(map[i][2] < map[j][2]) {
						idx++;
					}else if(map[i][2] == map[j][2]) {
						if(map[i][3] <map[j][3]) {
							idx++;
						}
					}
				}
			}
			map[i][4] = idx;
		}
		for (int i = 0; i < n; i++) {
			if(map[i][0] == k) {
				System.out.println(map[i][4]);
			}
		}
	}
}

