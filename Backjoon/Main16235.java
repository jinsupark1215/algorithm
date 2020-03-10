package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16235 {

	/*
	 * 1. K년 후의 나무의 갯수
	 * 
	 * 2. N<=10, K<=1000
	 * 
	 * 3. PriorQueue에 나무의 위치와  수명순으로 정렬
	 * map에는 양분만 처리
	 * 봄, 여름, 가을, 겨울 구현 후 K년이 됬을 때 멈춘 후
	 * 답 :  큐의 사이즈 
	 */
	static int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] plus = new int[N][N];
		PriorityQueue<Tree> q = new PriorityQueue<>(new Comparator<Tree>() {

			@Override
			public int compare(Tree o1, Tree o2) {
				return o1.age-o2.age;
			}
		});
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				plus[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Tree(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < K; i++) {
			ArrayList<Tree> del = new ArrayList<>();
			ArrayList<Tree> ins = new ArrayList<>();
			ArrayList<Tree> tmp = new ArrayList<>();
			
			//봄
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Tree t = q.poll();
				if (map[t.r][t.c] >= t.age) {
					map[t.r][t.c] -= t.age;
					if ((t.age + 1) % 5 == 0) {
						ins.add(new Tree(t.r, t.c, t.age + 1));
					}
					tmp.add(new Tree(t.r, t.c, t.age + 1));

				}else {
					del.add(t);
				}
			}
			
			//여름
			for (int j =0; j < del.size(); j++) {
				map[del.get(j).r][del.get(j).c] += del.get(j).age/2;
			}
			del.clear();
			
			//가을
			for (int j =0; j < ins.size(); j++) {
				for (int l = 0; l < 8; l++) {
					int nr = ins.get(j).r + pos[l][0];
					int nc = ins.get(j).c + pos[l][1];
					if(nr>=0 && nr<N && nc >=0 && nc < N) {
							q.add(new Tree(nr,nc,1));
					}
				}
			}
			ins.clear();
			
			//겨울
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					map[j][k] += plus[j][k];
				}
			}
			
			//임시로 넣어 논 것 
			for (int j = 0; j < tmp.size(); j++) {
				q.add(tmp.get(j));
			}
		}
		
		System.out.println(q.size());
	}
	static class Tree{
		int r,c,age;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

	}
}

