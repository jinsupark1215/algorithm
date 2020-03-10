package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17143 {

	/*
	 * 1. 낚시왕이 잡은 상어 크기의 합?
	 * 
	 * 2. R,C <= 100, 0 <= M <= RxC,(1,1)시작
	 * 
	 * 3. 
	 */
	static int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
	static int R,C,M, ans;
	static Shark[][] map;
	static Queue<Shark> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		
		map = new Shark[R][C];
		q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			int s =Integer.parseInt(st.nextToken());
			int d =Integer.parseInt(st.nextToken());
			int z =Integer.parseInt(st.nextToken());
			if(d-1 ==0 || d-1 == 1)
				map[r-1][c-1] = new Shark(r-1,c-1,s%((R-1)*2),d-1,z);
			else
				map[r-1][c-1] = new Shark(r-1,c-1,s%((C-1)*2),d-1,z);
			q.add(map[r-1][c-1]);				
		}
		
		//낚시 시작
		for (int fishing = 0; fishing < C; fishing++) {
			// 낚시
			for (int i = 0; i < R; i++) {
				if(map[i][fishing] != null) {
					ans+= map[i][fishing].z;
					q.remove(map[i][fishing]);
					map[i][fishing] = null;
					break;
				}
			}
			map = new Shark[R][C];
			// 상어 이동
			move();
		}
		System.out.println(ans);
	}
	private static void move() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Shark s = q.poll();
			
			int cnt = s.s;
			//마지막 자리 찾기
			while(cnt > 0) {
				s.r += pos[s.d][0];
				s.c += pos[s.d][1];
				
				if(s.r < 0 || s.c <0 || s.r==R || s.c==C) {
					s.r-=pos[s.d][0];
					s.c-=pos[s.d][1];
					
					if(s.d == 0) {
						s.d = 1;
					}else if(s.d == 1) {
						s.d = 0;
					}else if(s.d == 2) {
						s.d = 3;
					}else if(s.d == 3) {
						s.d = 2;
					}
					continue;
				}
				cnt--;
			}
			
			//크기가 크면 잡아먹기
			if(map[s.r][s.c] == null) {
				map[s.r][s.c] = s;				
				q.add(map[s.r][s.c]);
			}else {
				if(map[s.r][s.c].z <= s.z) {
					q.remove(map[s.r][s.c]);
					map[s.r][s.c] = s;
					q.add(map[s.r][s.c]);
				}
			}
		}
	}
	static class Shark{
		int r,c,s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}


	}
}

