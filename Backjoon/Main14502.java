package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {

	/*
	 * [백준] 연구소
	 * 
	 * 1. 안전영역 최대 구하기
	 * 
	 * 2. N <= 8
	 * 
	 * 3. 안전영역 세군데에 조합으로 벽을 세우고 바이러스 돌린 후 안전영역 검사
	 */
	static int N,M,ans,cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static ArrayList<int[]> Virus, Safe;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Virus = new ArrayList<int[]>();
		Safe = new ArrayList<int[]>();
		ans=0; cnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					Safe.add(new int[] {i,j});
					cnt++;
				}
				else if(map[i][j] == 2)Virus.add(new int[] {i,j});
			}
		}
		
		//3개 벽세우니까 빼줌
		cnt-=3;
		//벽세우고 진행
		int size = Safe.size();
		for (int i = 0; i < size-2; i++) {
			for (int j = i+1; j < size-1; j++) {
				for (int k = j+1; k < size; k++) {
					map[Safe.get(i)[0]][Safe.get(i)[1]] = 1;
					map[Safe.get(j)[0]][Safe.get(j)[1]] = 1;
					map[Safe.get(k)[0]][Safe.get(k)[1]] = 1;
					go();
					map[Safe.get(i)[0]][Safe.get(i)[1]] = 0;
					map[Safe.get(j)[0]][Safe.get(j)[1]] = 0;
					map[Safe.get(k)[0]][Safe.get(k)[1]] = 0;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void go() {
		Queue<int[]> q=  new LinkedList<>();
		int chk = 0;
		visit = new boolean[N][M];
		for (int[] tmp : Virus) {
			q.add(new int[] {tmp[0], tmp[1]});
			visit[tmp[0]][tmp[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + pos[i][0];
				int nc = cur[1] + pos[i][1];
				if(nr>=0 && nr< N && nc>=0 && nc< M && !visit[nr][nc] && map[nr][nc] == 0) {
					q.add(new int[] {nr,nc});
					visit[nr][nc] = true;
					chk++;
				}
			}
		}
		ans = Math.max(ans, cnt-chk);
	}
}
