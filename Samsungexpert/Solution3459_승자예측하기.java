package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3459_승자예측하기 {

	/*
	 * 1. Alice 와 Bob이 게임을 해서 누가 이기는지?
	 * 
	 * 2. 2x, 2x+1 중 선택 N < 10^18, 최선을 다해 게임한다.
	 * 
	 * 3. 4번 째 이후 규칙
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			long N = Long.parseLong(br.readLine());

			String answer = "Alice";
            while(N > 10) {
                N = (N/2) + 1;
                N = (N/2) - 1;
            }
            if( N == 1 || (N >= 6 && N <= 9)){
                answer = "Bob";
            }

			System.out.println("#"+ testcase + " " + answer);
		}
	}
}
