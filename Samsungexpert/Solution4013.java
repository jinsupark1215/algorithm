package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4013 {

	/*
	 * 1. 회전이 끝난 후 획득하는 점수
	 * 
	 * 2. 1<= K <= 20
	 * 
	 * 3. 하나의 자석이 1칸 회전할 때, 붙어있는 자석이  다를 경우 반대방향 회전
	 * 
	 * 몇번째 자석인지 판단 후 넘겨주기
	 */
	static int k, ans;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			k = Integer.parseInt(br.readLine());
			map = new int[4][8];
			ans = 0;
			StringTokenizer st;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				go(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			ans = map[0][0] + (map[1][0]*2) + (map[2][0]*4) + (map[3][0]*8);
			System.out.println("#"+ tc + " " + ans);
		}
	}
	private static void go(int num, int dir) {
		int[] flag = new int[4];
		switch (num) {
		case 1:
			flag[0] = dir;
			if (dir == 1) {
				if (map[0][2] != map[1][6]) {
					flag[1] = -1;
					if (map[1][2] != map[2][6]) {
						flag[2] = 1;
						if (map[2][2] != map[3][6]) {
							flag[3] = -1;
						}
					}
				}
			}else {
				if (map[0][2] != map[1][6]) {
					flag[1] = 1;
					if (map[1][2] != map[2][6]) {
						flag[2] = -1;
						if (map[2][2] != map[3][6]) {
							flag[3] = 1;
						}
					}
				}
			}
			
			break;
		case 2:
			flag[1] = dir;
			if (dir == 1) {
				if (map[0][2] != map[1][6]) {
					flag[0] = -1;
				}
				if (map[1][2] != map[2][6]) {
					flag[2] = -1;
					if (map[2][2] != map[3][6]) {
						flag[3] = 1;
					}
				}
			}else {
				if (map[0][2] != map[1][6]) {
					flag[0] = 1;
				}
				if (map[1][2] != map[2][6]) {
					flag[2] = 1;
					if (map[2][2] != map[3][6]) {
						flag[3] = -1;
					}
				}
			}
			break;
		case 3:
			flag[2] = dir;
			if (dir == 1) {
				if (map[1][2] != map[2][6]) {
					flag[1] = -1;
					if (map[0][2] != map[1][6]) {
						flag[0] = 1;
					}
				}
				if (map[2][2] != map[3][6]) {
					flag[3] = -1;
				}
			}else {
				if (map[1][2] != map[2][6]) {
					flag[1] = 1;
					if (map[0][2] != map[1][6]) {
						flag[0] = -1;
					}
				}
				if (map[2][2] != map[3][6]) {
					flag[3] = 1;
				}
			}
			break;
		case 4:
			flag[3] = dir;
			if (dir == 1) {
				if (map[2][2] != map[3][6]) {
					flag[2] = -1;
					if (map[1][2] != map[2][6]) {
						flag[1] = 1;
						if (map[0][2] != map[1][6]) {
							flag[0] = -1;
						}
					}
				}
			}else {
				if (map[2][2] != map[3][6]) {
					flag[2] = 1;
					if (map[1][2] != map[2][6]) {
						flag[1] = -1;
						if (map[0][2] != map[1][6]) {
							flag[0] = 1;
						}
					}
				}
			}
			break;
		

		default:
			break;
		}
		for (int i = 0; i < 4; i++) {
			rotate(i,flag[i]);
		}
	}
	private static void rotate(int num, int dir) {
		if(dir == 1) {
			int tmp = map[num][7];
			for (int i = 7; i >0; i--) {
				map[num][i] = map[num][i-1]; 
			}
			map[num][0] = tmp;
		}else if(dir == -1){
			int tmp = map[num][0];
			for (int i = 0; i <7; i++) {
				map[num][i] = map[num][i+1]; 
			}
			map[num][7] = tmp;
		}else return;
		
	}
}

