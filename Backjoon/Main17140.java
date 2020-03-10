package Backjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main17140 {

	/*
	 * 1. A[r][c] 들어있는 값이 k가 되기 위한 최소 연산수
	 * 
	 * 2. r,c,k <= 100, A[r][c] 가 100 이 넘어가면 -1
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt()-1;
		int c = sc.nextInt() -1;
		int k = sc.nextInt();
		int[][] A = new int[100][100];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		int ans = -1;
		int row = 3;
		int col = 3;
		int cnt = 0;
		while(true) {
			int maxrow = 0;
			int maxcol = 0;
			if(A[r][c] == k) {
				ans = cnt;
				break;
			}
			if(cnt > 100) {
				break;
			}
			
			int[][] tmp = new int[100][100];
			//R연산
			if(row >= col) {
				for (int i = 0; i < row; i++) {
					PriorityQueue<Point> q = new PriorityQueue<>();
					int[] arr= new int[101];
					for (int j = 0; j < col; j++) {
						arr[A[i][j]]++;
					}
					for (int j = 1; j <= 100; j++) {
						if(arr[j] != 0) {
							q.add(new Point(j,arr[j]));
						}
					}
					if(maxcol < (q.size() * 2))maxcol = (q.size() * 2);
					
					//100 넘어가면 안됨
					int size =0;
					if(q.size()>50) {
						size = 50;
					}else {
						size = q.size();						
					}
					
					//순서대로
					for (int j = 0; j < size; j++) {
						Point p = q.poll();
						tmp[i][(j*2)] = p.num;
						tmp[i][(j*2)+1] = p.cnt;
					}
				}
				
				if(maxcol > 100) {
					col = 100;
				}else {
					col = maxcol;
				}
				
			//C연산
			}else {
				for (int i = 0; i < col; i++) {
					PriorityQueue<Point> q = new PriorityQueue<>();
					int[] arr= new int[101];
					for (int j = 0; j < row; j++) {
						arr[A[j][i]]++;
					}
					for (int j = 1; j <= 100; j++) {
						if(arr[j] != 0) {
							q.add(new Point(j,arr[j]));
						}
					}
					if(maxrow < (q.size() * 2))maxrow = (q.size() * 2);
					
					//100 넘어가면 안됨
					int size =0;
					if(q.size()>50) {
						size = 50;
					}else {
						size = q.size();						
					}
					
					//순서대로
					for (int j = 0; j < size; j++) {
						Point p = q.poll();
						tmp[(j*2)][i] = p.num;
						tmp[(j*2)+1][i] = p.cnt;
					}
				}
				
				if(maxrow > 100) {
					row = 100;
				}else {
					row = maxrow;
				}
			}
			
			//다시 복사
			A = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					A[i][j] = tmp[i][j];
				}
			}
			
			cnt++;
		}
		System.out.println(ans);
	}
	static class Point implements Comparable<Point>{
		int num, cnt;

		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if(this.cnt == o.cnt) {
				return this.num - o.num; 
			}else	return this.cnt-o.cnt;
		}
	}
}

