package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution7194 {

	/*
	 * 1. 화섭이가 미생물 s 개를 t개 까지 만드는 최소 수
	 * 
	 * 2. s,t,a,b <=1000000000, 만드는 것이 불가능하면 -1
	 * 
	 * 3. b가 1인 예외 정리 나머지는 b부터 곱해보고 a로 빼면서 맞는지 체크
	 */
	static int s, t, a, b, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = 0;

			// 예외 : b가 1인 경우가 있는것 같음
			if (b == 1) {
				if ((t - s) % a == 0)
					ans = (t - s) / a;
				else
					ans = -1;

				System.out.println("#" + tc + " " + ans);
			} else {

				// 나머지는 일단 b부터하고 a를 나중으로 해서 돌려보자
				while (s < t) {
					if (t % b == 0) {
						if (t / b < s)
							t -= a;
						else
							t /= b;
					} else {
						t -= a;
					}
					ans++;
				}

				if (s > t)
					System.out.println("#" + tc + " -1");
				else
					System.out.println("#" + tc + " " + ans);
			}
		}
	}
}
