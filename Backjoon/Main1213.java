package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1213 {

	/*
	 * 1. 문자열로 바꾸는 법
	 * 
	 * 2. 최대 50글자
	 * 
	 * 3. 배열 사용
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] arr = new int[26];

				for (int i = 0; i < input.length(); i++)
					arr[input.charAt(i) - 'A']++;

				int cnt = 0;
				String first = "";
				String second = "";
				String third = "";

				for (int i = 0; i < 26; i++) {
					if (arr[i] != 0) {
						if (arr[i] % 2 == 0) {
							while (arr[i] > 0) {
								first += (char) (i + 'A');
								arr[i] -= 2;
							}
						} else {
							while (arr[i] > 1) {
								first += (char) (i + 'A');
								arr[i] -= 2;
							}
						}
					}

					if (arr[i] % 2 != 0)
						cnt++;
					
					if (cnt <= 1 && arr[i] > 0)
						second += (char) (i + 'A');
				}

				for (int i = first.length() - 1; i >= 0; i--)
					third += first.charAt(i);

				if (cnt <= 1)
					System.out.println(first + second + third);
				else
					System.out.println("I'm Sorry Hansoo");
	}
}
