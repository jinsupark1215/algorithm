package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100];
			
			for (int i = 0; i < 100; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < tmp; j++) {
					box[j]++;
				}
			}
			
			/*
			 * 1. 문제이해 : 덤프 후 최고점과 최저점의 차이를 반환
			 * 
			 * 2. 가로 100, 상자높이 1~100, 덤프횟수 1000
			 * 
			 * 3. 상자를 옆으로 눞혀서 봤을 때, 100이 아닌 것을 찾아서 맨뒤부터 하나씩 체크
			 */
			int max = 0;
			int min = 0;
			while(dump >=0) {
				
				fin:
				for (int i = 0; i < 100; i++) {
					if(box[i] != 100) {
						for (int j = 99; j >=0; j--) {
							if(box[j] !=0) {
								box[j]--;
								box[i]++;
								max = j;
								min = i;
								break fin;
							}
						}
					}
				}
				dump--;
			}
			System.out.println("#" + testcase +  " " + (max-min+1));
		}
	}
}
