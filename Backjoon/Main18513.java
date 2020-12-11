package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18513 {

	/*
	 * [백준] 샘터
	 * 1. 최솟값
	 * 
	 * 2. 
	 * 
	 * 3. bfs
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 
		Queue<int[]> que = new LinkedList<>(); 
		st = new StringTokenizer(br.readLine()); 
		boolean visit[] = new boolean[150000000];
		boolean mvisit[] = new boolean[150000000];
		
		for (int i = 0; i < N; i++) {
			int loc = Integer.parseInt(st.nextToken());
			que.add(new int[] {loc, 0});
			if (loc < 0) 
				mvisit[-loc] = true;
			else if (loc >= 0)
				visit[loc] = true;
		}

		int pos[] = { -1, 1 };
		int cnt = 0;
		long ans = 0;
		fin: while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int i = 0; i < 2; i++) { 
				int nextL = now[0] + pos[i];
				int nextD = now[1] + 1;
				if (nextL >= 0 && visit[nextL])
					continue;
				if (nextL < 0 && mvisit[-nextL])
					continue;
				ans += (long)nextD;
				cnt++;
				if (cnt == K)
					break fin;
				if (nextL >= 0)
					visit[nextL] = true;
				if (nextL < 0)
					mvisit[-nextL] = true;
				que.offer(new int[] {nextL, nextD});
			}
		}
		System.out.println(ans);
	}
}
