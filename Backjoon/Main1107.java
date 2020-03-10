package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1107{

	/*
	 * 1. 채널이동 위해 최소 버튼수
	 * 
	 * 2. N <= 500,000
	 * 
	 * 3. 구현
	 */
	static String N;
	static int ans;
	static boolean[] btn;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		btn = new boolean[10];
		Arrays.fill(btn, true);
		int M = Integer.parseInt(br.readLine());

		// 초기값음 + or - 눌렀을 때의 값
		ans = Math.abs(100 - Integer.parseInt(N));

		// 0이면 진행 안함
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				btn[Integer.parseInt(st.nextToken())] = false;
			}

		}
			sb = new StringBuilder();

			// 버튼으로 누를 수 있는지 판단
			boolean flag = true;
			for (int i = 0; i < N.length(); i++) {
				if (!btn[N.charAt(i) - '0']) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans = Math.min(N.length(), ans);
			} else {
				dfs(0);
			}


		System.out.println(ans);
	}

	private static void dfs(int idx) {
		if (!sb.toString().equals(""))
			ans = Math.min(ans, idx + Math.abs(Integer.parseInt(N) - Integer.parseInt(sb.toString())));
		if (idx > N.length()) {
			return;
		}

		// 길이만큼
		for (int i = 0; i < 10; i++) {
			if (btn[i]) {
				sb.append(i);
				dfs(idx + 1);
				sb.deleteCharAt(idx);
			}
		}
	}
}

