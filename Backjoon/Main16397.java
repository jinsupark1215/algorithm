package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16397 {

	/*
	 * [백준] 탈출
	 * 
	 * 1. 최소 버튼 횟수
	 * 
	 * 2. N<= 99999, T<=99999,G<=99999
	 * 
	 * 3. bfs
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<>();
		boolean[] visit = new boolean[100000];
		q.add(new int[] {N,0});
		int ans= 0;
		boolean flag = false;
		visit[N] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == G) {
				flag = true;
				ans = cur[1];
				break;
			}
			if (cur[1] < T) {

				// A
				if(cur[0] + 1 < 100000 &&!visit[cur[0] + 1]) {
					q.add(new int[] { cur[0] + 1, cur[1] + 1 });
					visit[cur[0] + 1] = true;
				}
				// B
				if (cur[0] !=0 &&cur[0] * 2 < 100000) {
					int tmp = cur[0] * 2;
					int cnt = 1;
					while (true) {
						if (tmp / 10 == 0)
							break;
						tmp /= 10;
						cnt *= 10;
					}
					
					if(!visit[(cur[0] * 2) - cnt]) {
					q.add(new int[] { (cur[0] * 2) - cnt, cur[1] + 1 });
					visit[(cur[0] * 2) - cnt] = true;
					}
				}
			}
		}
		if(flag)System.out.println(ans);
		else System.out.println("ANG");
	}
}
