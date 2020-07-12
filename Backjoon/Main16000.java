package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16000 {

	static int N, M, cnt, sum;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
	static boolean[][] visit;
	static char[][] map;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		arr = new int[N][M];
		sum = 0;
		
		for (int i = 0; i < N; i++) {
			char[] a = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = a[j];
			}
		}
		
		outcheck();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j] &&map[i][j] == '#') {
					map[i][j] = 'X';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
				System.out.println(map[i]);
		}
	}
	private static void isisland(int r, int c) {
		Queue<Integer> q = new LinkedList<>();
		q.add(r);q.add(c);
		sum++;
		visit[r][c] = true;
		arr[r][c] = sum;
		map[r][c] =  'O';
		while(!q.isEmpty()) {
			int isr =q.poll();
			int isc = q.poll();
		int nr = 0, nc= 0;

		for (int i = 0; i < 4; i++) {
			nr = isr + pos[i][0];
			nc = isc + pos[i][1];
			if(nr>=0 && nc>=0 && nr<N && nc < M && map[nr][nc] == '#' && !visit[nr][nc]) {
				visit[nr][nc] = true;
				arr[nr][nc] = sum;
				map[nr][nc] = 'O';
				q.add(nr);q.add(nc);
			}
		}
		}
	}
	
	private static void outcheck() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);q.add(0);
		visit[0][0] = true;
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			int nr = 0, nc= 0;
			for (int i = 0; i < 4; i++) {
				nr = r + pos[i][0];
				nc = c + pos[i][1];
				if(nr>=0 && nc>=0 && nr<N && nc < M && map[nr][nc] == '.' && !visit[nr][nc]) {
					visit[nr][nc]= true;
					q.add(nr);q.add(nc);
				}
				if(nr>=0 && nc>=0 && nr <N && nc < M && map[nr][nc] =='#' && !visit[nr][nc]) {
					isisland(nr,nc);
				}
			}
			
			for (int i = 4; i < 8; i++) {
				nr = r + pos[i][0];
				nc = c + pos[i][1];
				if(nr>=0 && nc>=0 && nr<N && nc < M && map[nr][nc] == '.'  && arr[nr][c] != arr[r][nc] && !visit[nr][nc]) {
					visit[nr][nc]= true;
					q.add(nr);q.add(nc);
				}
			}
			
		}
		
		
	}
}
