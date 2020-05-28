package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3895 {

	/*
	 * [백준] 그리고 하나가 남았다
	 * 
	 * 1. 마지막에 남는 돌 하나를 출력
	 * 
	 * 2. n<=10000, k<=10000, m<n
	 * 
	 * 3. list로 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n, k, m;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && k == 0 && m == 0)
				break;

			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}
			int idx = m - 1;

			for (int i = 0; i < n - 1; i++) {
				list.remove(idx);
				idx = (idx + k - 1) % (n - i - 1);
			}
			System.out.println(list.get(0));
			list.remove(0);
		}
	}
}
