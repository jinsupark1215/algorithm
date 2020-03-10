package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1209 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testcase = 0; testcase < 10; testcase++) {
			int test = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				//행 가로
				for (int j = 0; j < 100; j++) {
					sum += map[i][j];
				}
				max = max<sum?sum:max;
				sum =0;
				//열 세로
				for (int j = 0; j < 100; j++) {
					sum += map[j][i];
				}
				
				max = max<sum?sum:max;
				sum =0;
				for (int j = 0; j < 100; j++) {
					if(i == j) {
						sum += map[j][i];
					}
				}
				max = max<sum?sum:max;
				sum=0;
				
				for (int j = 0; j < 100; j++) {
					if(i + j ==99) {
						sum += map[j][i];
					}
				}
				max = max<sum?sum:max;
				sum=0;
			}
			System.out.println("#" + test + " " + max);
		}
	}
}
