package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16947 {

	/*
	 * [백준] 서울 지하철 2호선
	 * 
	 * 1. 순환선에 가장 가까운 최소거리
	 * 
	 * 2. N <= 3000
	 * 
	 * 3. 순환하는 노드들을 찾기 -> dfs
	 *  bfs를 통해서 각 노드들 가까운 순환점 찾기
	 */
	static int N;
	static boolean[] cycle;
	static ArrayList<Integer>[] map;
	static int[] ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		cycle = new boolean[N+1];
		ans = new int[N+1];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 양방향
			map[start].add(end);
			map[end].add(start);
		}
		
		for (int i = 1; i <= N; i++) {
			if(isCycle(i,i,i)) {
				break;
			}else {
				cycle = new boolean[N+1];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			//순환이면 넘어감
			if(cycle[i]) continue;
			
			int cnt = bfs(i);
			ans[i] = cnt;
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i] + " ");
		}
		
	}

	private static int bfs(int v) {
		Queue<int[]> q= new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		// 노드, 갯수
		q.add(new int[] {v,0});
		visit[v] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cycle[cur[0]])return cur[1];
			
			for (int i = 0; i < map[cur[0]].size(); i++) {
				int e = map[cur[0]].get(i);
				if(!visit[e]) {
					visit[e] = true;
					q.add(new int[] {e, cur[1]+1});
				}
			}
		}
		return 0;
	}

	private static boolean isCycle(int before, int v, int start) {
		cycle[v] = true;
		
		for (int i = 0; i < map[v].size(); i++) {
			int e = map[v].get(i);
			
			//다음 간선이 아니면 순환이 아니면
			if(!cycle[e]) {
				//dfs 타면서 사이클 찾기
				if(isCycle(v,e,start))return true;
				//다음 간선 true면 순환
			}else if(e != before && e == start)return true;
		}
		
		cycle[v] = false;
		
		return false;
	}
}
