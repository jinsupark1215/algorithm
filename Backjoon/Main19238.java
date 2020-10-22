package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main19238 {

	/*
	 * [백준] 스타트 택시
	 * 
	 * 1. 남은 연료를 출력해라
	 * 
	 * 2. N<=20
	 * 
	 * 3. bfs 이용
	 */
	static int[][] map, person;
	static boolean[][] visit;
	static int N,P,ans,fuel,carr,carc;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		ans = fuel;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		carr = Integer.parseInt(st.nextToken())-1;
		carc = Integer.parseInt(st.nextToken())-1;
		
		person = new int[P][5];
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 5; j++) {
				person[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		fin:
		for (int test = 0; test < P; test++) {
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) {
						if(person[o1[0]][1] == person[o2[0]][1]) {
							return person[o1[0]][2] - person[o2[0]][2];
						}
						return person[o1[0]][1] - person[o2[0]][1];
					}
					return o1[1] - o2[1];
				}
			});
			//거리 측정
			visit = new boolean[N][N];
			Queue<Car> q = new LinkedList<>();
			visit[carr][carc] = true;
			q.add(new Car(carr,carc,fuel,0));
			//거리 저장
			while(!q.isEmpty()) {
				Car c = q.poll();
				
					
				if(c.f >=0) {
				for (int i = 0; i < P; i++) {
					if(person[i][0] == 0 &&person[i][1] == c.r && person[i][2] == c.c) {
						pq.add(new int[] {i,c.cnt});
					}
					
				}
				}
				
				if(c.f >0) {
				for (int i = 0; i < 4; i++) {
					int nr = c.r + pos[i][0];
					int nc = c.c + pos[i][1];
					if(nr>=0 && nr < N && nc>=0 && nc<N && map[nr][nc] == 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new Car(nr,nc,c.f-1,c.cnt+1));
					}
				}
				}
			}
			
			//갈 수 있는게 없으면
			if(pq.isEmpty()) {
				ans = -1;
				break;
			}
			int[] target = pq.poll();
			//차이동 - 사람한테
			carr = person[target[0]][1];
			carc = person[target[0]][2];
			fuel = fuel - target[1];
			person[target[0]][0] = 1;
			if(fuel <0) {
				ans = -1;
				break;
			}
			
			//차이동 - 목적지한테
			q = new LinkedList<>();
			visit = new boolean[N][N];
			visit[carr][carc] = true;
			q.add(new Car(carr,carc,fuel,0));
			boolean flag = false;
			while(!q.isEmpty()) {
				Car c = q.poll();
				
				
				if(person[target[0]][3] == c.r && person[target[0]][4] == c.c) {
					carr = c.r; carc = c.c;
					fuel = fuel - c.cnt;
					flag = true;
					if(c.f < 0) {
						ans = -1;
						break fin;
					}
					if(fuel < 0) {
						ans = -1;
						break fin;
					}else {
						fuel += (c.cnt*2);
					}
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = c.r + pos[i][0];
					int nc = c.c + pos[i][1];
					if(nr>=0 && nr < N && nc>=0 && nc<N && map[nr][nc] == 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new Car(nr,nc,c.f-1,c.cnt+1));
					}
				}
			}
			if(!flag) {
				ans = -1;
				break;
			}
		}
		
		if(ans !=-1)ans = fuel;
		System.out.println(ans);
	}
	static class Car{
		int r,c,f,cnt;

		public Car(int r, int c, int f, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.f = f;
			this.cnt = cnt;
		}

	}
}
