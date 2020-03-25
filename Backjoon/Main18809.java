package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18809 {

	/*
	 * 1. 피울 수 있는 꽃의 최대 갯수
	 * 
	 * 2. N <= 50, M <=50, G, R <= 5
	 * 
	 * 3. 
	 * 3-1 배양액 넣을 수 있는 땅중 R+G만큼 선택하는 조합 
	 * 3-2 새로운 맵에 넣고 만날 때 ans 증가해 최댓값 리턴
	 */
	static int N, M, R, G, ans;
	static int[][] map;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<Point> list;
	static int[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Point(i,j,0,0));
				}
			}
		}

		chk = new int[list.size()];
		chk = new int[list.size()];

		Combi(R,G,0,0);
		
		System.out.println(ans);
	}

	private static void Combi(int red, int green,int idx, int cnt) {
		if (red ==0 && green ==0 &&cnt == R + G) {
			bfs();
//			System.out.println(Arrays.toString(chk));
			return;
		}

		if(red<0 || green<0) return;
		
		for (int i = idx; i < chk.length; i++) {
			if (chk[i] == 0) {
					chk[i] = 1;
					Combi(red-1,green,i+1,cnt+1);
					chk[i] = 0;
					chk[i] = 2;
					Combi(red,green-1,i+1,cnt+1);
					chk[i] = 0;
			}
		}
	}

	private static void bfs() {
		Point[][] tmpmap = new Point[N][M];
		boolean[][][] visit = new boolean[N][M][2];
		int cnt = 0;
		Queue<Point> red= new LinkedList<>();
		Queue<Point> green= new LinkedList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (chk[i] == 1) {
				red.add(new Point(list.get(i).r, list.get(i).c, 1, 0));
				tmpmap[list.get(i).r][list.get(i).c] = new Point(list.get(i).r, list.get(i).c, 1, 0);
				visit[list.get(i).r][list.get(i).c][0] = true;
			} else if (chk[i] == 2) {
				green.add(new Point(list.get(i).r, list.get(i).c, 1, 1));
				tmpmap[list.get(i).r][list.get(i).c] = new Point(list.get(i).r, list.get(i).c, 1, 1);
				visit[list.get(i).r][list.get(i).c][1] = true;
			}
		}
		
		while(!red.isEmpty() && !green.isEmpty()) {
			int redsize = red.size();
			int greensize = green.size();
			
			for (int i = 0; i < redsize; i++) {
				Point p = red.poll();

				for (int j = 0; j < 4; j++) {
					int nr = p.r + pos[j][0];
					int nc = p.c + pos[j][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !visit[nr][nc][0]&& !visit[nr][nc][1]) {
						visit[nr][nc][0] = true;
						tmpmap[nr][nc] = new Point(nr, nc, p.idx + 1,0);
						red.add(tmpmap[nr][nc]);
					}
				}
			}
			
			for (int i = 0; i < greensize; i++) {
				Point p = green.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = p.r + pos[j][0];
					int nc = p.c + pos[j][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !visit[nr][nc][1]) {
							visit[nr][nc][1] = true;
							if(visit[nr][nc][0] &&tmpmap[nr][nc].idx == p.idx+1) {
								cnt++;
								red.remove(tmpmap[nr][nc]);
							}else {
								tmpmap[nr][nc] = new Point(nr, nc, p.idx + 1,1);
								green.add(tmpmap[nr][nc]);
							}
					}
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
static class Point{
	int r,c,idx, who;

	public Point(int r, int c, int idx, int who) {
		super();
		this.r = r;
		this.c = c;
		this.idx = idx;
		this.who = who;
	}
}
}
