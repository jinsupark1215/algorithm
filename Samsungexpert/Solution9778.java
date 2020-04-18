package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9778 {

	/*
	 * [삼성] 카드게임
	 * 
	 * 1. 21보다 크게 만드는 카드의 갯수와 21이하인 경우 판단
	 * 
	 * 2. 
	 * 
	 * 3. 구현
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] card = {0,0,4,4,4,4,4,4,4,4,16,4};
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				card[num]--;
				sum += num;
			}
			int win = 0, lose = 0;
			
			for (int i = 0; i < 52-N; i++) {
				for (int j = 2; j < 12; j++) {
					if(card[j] != 0) {
						if(sum + j > 21)win++;
						else lose++;
						card[j]--;
						break;
					}
				}
			}
			if(win <= lose)System.out.println("#"+ tc + " GAZUA");
			else System.out.println("#"+ tc + " STOP");
		}
	}
}
