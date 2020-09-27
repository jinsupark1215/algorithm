package Programs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_네3 {

	public static void main(String[] args) {
		int n = 19;
		int[][] edges = {{0,1},{0,2},{0,3},{1,4},{1,5},{2,6},{3,7},{3,8},{3,9},{4,10},{4,11},{5,12},{5,13},
				{6,14},{6,15},{6,16},{8,17},{8,18}};
		System.out.println(solution(n,edges));
	}

	static int[] num;
	static int[][] map;
	static boolean[] visit;
	private static int solution(int n, int[][] edges) {

		int ans = 0;
		
		num = new int[n];
		map = new int[n][n];
		for (int i = 0; i < edges.length; i++) {
			map[edges[i][0]][edges[i][1]] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			visit = new boolean[n];
			dfs(i,i, 0);
		}

		PriorityQueue[] list = new PriorityQueue[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = new PriorityQueue<int[]>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
		}
		for (int i = 0; i < edges.length; i++) {
			list[edges[i][0]].add(new int[] {edges[i][0], num[edges[i][1]]});
		}
		visit= new boolean[n];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			int cur = q.poll();
			int size = list[cur].size();
			for (int i = 0; i < size; i++) {
				int[] tmp =(int[]) list[cur].poll();
				if(!visit[tmp[0]]) {
					visit[tmp[0]] = true;
					q.add(tmp[0]);
					ans++;
				}
			}
		}
		return ans;
	}
	private static void dfs(int chk,int cur, int cnt) {
		num[chk]++;
		for (int i = 0; i < map.length; i++) {
			if(map[cur][i] ==1 && !visit[cur]) {
				dfs(chk,i,cnt+1);
			}
		}
	}
}
