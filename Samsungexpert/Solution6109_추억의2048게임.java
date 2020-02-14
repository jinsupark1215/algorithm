package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution6109_추억의2048게임 {

	/*
	 * 1. 위,아래,오른쪽,왼쪽 한 후 맵을 표시
	 * 
	 * 2. 정수들은 2의 제곱수, N <=20
	 * 
	 * 3. Queue 이용해서 계산후 뿌려주기
	 */
	static int n;
	static String input;
	static int[][] map, ans;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			input = st.nextToken();
			
			map = new int[n][n];
			ans = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			
			if(input.equals("up")) {
				for (int i = 0; i < n; i++) {
					q = new LinkedList<>();
					for (int j = 0; j < n; j++) {
						if(map[j][i] != 0)
						q.add(map[j][i]);
					}
					
					int idx = 0;
					while(!q.isEmpty()) {
						int num = q.poll();
						
						if(!q.isEmpty() && num == q.peek()) {
							q.poll();
							ans[idx][i] = num*2;
						}else {
							ans[idx][i] = num;
						}
						idx++;
					}
				}
			}else if(input.equals("down")) {
				for (int i = 0; i < n; i++) {
					q = new LinkedList<>();
					for (int j = n-1; j >=0; j--) {
						if(map[j][i] != 0)
						q.add(map[j][i]);
					}
					int idx = n-1;
					while(!q.isEmpty()) {
						int num = q.poll();
						
						if(!q.isEmpty() && num == q.peek()) {
							q.poll();
							ans[idx][i] = num*2;
						}else {
							ans[idx][i] = num;
						}
						idx--;
					}
				}
			}else if(input.equals("left")) {
				for (int i = 0; i < n; i++) {
					q = new LinkedList<>();
					for (int j = 0; j < n; j++) {
						if(map[i][j] != 0)
						q.add(map[i][j]);
					}
					int idx = 0;
					while(!q.isEmpty()) {
						int num = q.poll();
						
						if(!q.isEmpty() && num == q.peek()) {
							q.poll();
							ans[i][idx] = num*2;
						}else {
							ans[i][idx] = num;
						}
						idx++;
					}
				}
			}else if(input.equals("right")) {
				for (int i = 0; i < n; i++) {
					q = new LinkedList<>();
					for (int j = n-1; j >=0; j--) {
						if(map[i][j] != 0)
						q.add(map[i][j]);
					}
					int idx = n-1;
					while(!q.isEmpty()) {
						int num = q.poll();
						
						if(!q.isEmpty() && num == q.peek()) {
							q.poll();
							ans[i][idx] = num*2;
						}else {
							ans[i][idx] = num;
						}
						idx--;
					}
				}
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
