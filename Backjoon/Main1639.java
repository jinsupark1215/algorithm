package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1639 {

	/*
	 * [백준] 행운의 티켓
	 * 
	 * 1. 부분 문자열의 최대길이
	 * 
	 * 2. 문자열이 100이하
	 * 
	 * 3. 이분 탐색개념
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] arr = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(S.charAt(i)));
        }

        int start, mid, end; 
        int s, e;
        int left, right; 

        end = S.length() % 2 == 0 ? S.length() : S.length() - 1;

        end += 2;

        while (end > 2) { 
            start = 0;
            end -= 2;
            e = end;
            s = start;

            while (e <= S.length()) {

                mid = (s + e) / 2;
                left = 0;
                right = 0;
                for (int l = s; l < mid; l++) { 
                    left += arr[l];
                }

                for (int r = mid; r < e; r++) {
                    right += arr[r];
                }

                if (left == right) {
                    System.out.println(end);
                    return;
                }
                s++;
                e++;
            }
        }
        System.out.println(0);
	}
}
