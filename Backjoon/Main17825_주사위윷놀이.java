package Backjoon;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main17825_주사위윷놀이 {

	/*
	 * 1. 얻을 수 있는 점수의 최댓값
	 * 
	 * 2. 
	 * 
	 * 3. 윷놀이판 구현 ( 원래대로가면 20, 5번째 번 밟으면  7개, 10번째 밟으면 6개, 15번째 밟으면 7개)
	 * 말 4개
	 * 조합으로 순서 정하기
	 * 구현
	 */
	static int[] order, dice;
	static int[] map = {0, 2, 4, 6, 8, 0, 12, 14, 16, 18, 0, 22, 24, 26, 28, 0, 32, 34, 36, 38, 40};
	static int[] five = {10, 13, 16, 19, 25, 30, 35, 40,0,0,0,0,0};
	static int[] ten = {20, 22, 24, 25, 30, 35, 40,0,0,0,0,0};
	static int[] fifteen = {30, 28, 27, 26, 25, 30, 35, 40,0,0,0,0,0};
	static int cnt, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		order = new int[10];
		ans = 0;
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(ans);
	}
	private static void dfs(int idx) {
		if(idx == 10) {
			move();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
				order[idx] = i;
				dfs(idx+1);
			}
	}
	private static void move() {
		boolean[] visit1 = new boolean[26];
		boolean[] visit2 = new boolean[13];
		boolean[] visit3 = new boolean[12];
		boolean[] visit4 = new boolean[13];
		int[] horse = new int[4];
		boolean[][] chk = new boolean[4][3];
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			horse[order[i]] += dice[i];

			if(horse[order[i]] == 5) {
				chk[order[i]][0] = true;
				visit1[horse[order[i]] - dice[i]] = false;
			}else if(horse[order[i]] == 10) {
				chk[order[i]][1] = true;				
				visit1[horse[order[i]] - dice[i]] = false;
			}else if(horse[order[i]] == 15) {			
				chk[order[i]][2] = true;				
				visit1[horse[order[i]] - dice[i]] = false;
			}
			
			if(chk[order[i]][0] && horse[order[i]] < 12 + 5 && !visit2[horse[order[i]] -5]) {
				if( horse[order[i]] < 12) {
				sum += five[horse[order[i]] - 5];
				visit2[horse[order[i]] - 5] = true;
				if(horse[order[i]] - 5 > 3) {
					visit3[horse[order[i]] - 4 -1] = true;
					visit4[horse[order[i]] - 4] = true;
				}
				}
				if(horse[order[i]] - 5  -dice[i]>=0) {
					visit2[horse[order[i]] - 5 - dice[i]] = false;
					if(horse[order[i]] - 5 > 3) {
						visit3[horse[order[i]] - 4 -1- dice[i]] = false;
						visit4[horse[order[i]] - 4- dice[i]] = false;
					}
				}
			}else if(chk[order[i]][1] && horse[order[i]] < 16 + 5 && !visit3[horse[order[i]] - 10]) {
				if(horse[order[i]] < 16) {
				sum += ten[horse[order[i]] - 10];
				visit3[horse[order[i]] - 10] = true;
				if(horse[order[i]] - 10 > 2) {
					visit2[horse[order[i]] - 9] = true;
					visit4[horse[order[i]] - 9] = true;
				}
				}
				if(horse[order[i]] - 10 -dice[i] >=0) {
					visit3[horse[order[i]] - 10 - dice[i]] = false;
					if(horse[order[i]] - 10 > 3) {
						visit2[horse[order[i]] - 9- dice[i]] = false;
						visit4[horse[order[i]] - 9- dice[i]] = false;
					}
				}
			}else if(chk[order[i]][2] && horse[order[i]] < 22 + 5 && !visit4[horse[order[i]] - 15]) {
				if(horse[order[i]] < 22) {
				sum += fifteen[horse[order[i]] - 15];
				visit4[horse[order[i]] - 15] = true;
				if(horse[order[i]] - 15 > 3) {
					visit2[horse[order[i]] - 14] = true;
					visit3[horse[order[i]] - 14 -1] = true;
				}
				}
				if(horse[order[i]] - 15 -dice[i] >=0) {
					visit4[horse[order[i]] - 15 - dice[i]] = false;
					if(horse[order[i]] - 15 > 3) {
						visit2[horse[order[i]] - 14- dice[i]] = false;
						visit3[horse[order[i]] - 14-1- dice[i]] = false;
					}
				}
				
			}else if(!chk[order[i]][0] && !chk[order[i]][1] && !chk[order[i]][2]
					&& horse[order[i]] < 21+5 && !visit1[horse[order[i]]]){
				if(horse[order[i]] < 21) {
				sum += map[horse[order[i]]];					
				visit1[horse[order[i]]] = true;
				}
					visit1[horse[order[i]] - dice[i]] = false;
			}
		}
		ans = Math.max(ans, sum);
	}
}
