package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236 {

	/*
	 * [백준] 아기상어
	 * 
	 * 1. 먹을때까지먹을수 있는 시간
	 * 
	 * 2. N<=20
	 * 
	 * 3. 자기위치에서 bfs 돌아서 턴마다 먹을 수 있는 물고기 체크 -> 체크하다가 먹을수 있는 물고기발견하면(우선순위큐)
	 * -> 다돌았는데 없으면 끝
	 * -> 물고기로 이동하고 이동거리만큼 ++ -> 먹은 갯수 체크하면서 크기 같아지면 크기 ++ -> 반복
	 */
	static int N,ans,curr,curc,Sharksize, eat;
	static int[][] map;
	static int[][] pos = {{1,0},{-1,0,},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Sharksize = 2;
		ans = 0;
		eat = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					curr = i;curc = j;
				}
			}
		}
		
		while(true) {
			// 먹을수 있는 곳 체크
			Queue<int[]> q = new LinkedList<>();
			// 먹을 수 있는 놈 (왼쪽에 있는애니까 2번쨰항으로 오름차순 정렬)
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[2] == o2[2]) {
						if(o1[0] == o2[0]) {
							return o1[1] - o2[1];
						}
						return o1[0] - o2[0];
					}
					return o1[2] - o2[2];
				}
			});
			boolean[][] visit= new boolean[N][N];
			visit[curr][curc] = true;
			q.add(new int[] {curr, curc, 0});
			
			//주변 확인
			while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					for (int i = 0; i < 4; i++) {
						int nr = cur[0] + pos[i][0];
						int nc = cur[1] + pos[i][1];
						if(nr>=0 && nr<N && nc>=0 && nc< N && !visit[nr][nc] && Sharksize>=map[nr][nc]) {
							visit[nr][nc] = true;
							q.add(new int[] {nr,nc, cur[2]+1});
							if(map[nr][nc] !=0 &&Sharksize > map[nr][nc]) {
								pq.add(new int[] {nr,nc, cur[2]+1});
							}
						}
					}
				
			}
			if(pq.isEmpty())break;
			else if(pq.size() > 0) {
				int[] cur = pq.peek();
				ans+= cur[2];
				map[cur[0]][cur[1]] = 0;
				eat++;
				curr = cur[0];
				curc = cur[1];
				if(eat == Sharksize) {
					Sharksize++;
					eat = 0;
				}
			}
			
		}
		System.out.println(ans);
	}
}
