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
	static int[] route0 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 };
    static int[] route1 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40 };
    static int[] route2 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40 };
    static int[] route3 = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40 };
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
			 int sum = move();
	            if (ans < sum)
	                ans = sum;
	            return;
		}
		
		for (int i = 0; i < 4; i++) {
				order[idx] = i;
				dfs(idx+1);
			}
	}
	private static int move() {
		 int[][] horse = new int[4][2]; // 말의 위치, 가는 길, 움직인 횟수
	        int sum = 0;

	        for (int i = 0; i < 10; i++) {
	            int cur = order[i]; // 현재움직일 말의 번호.
	            horse[cur][0] += dice[i]; // 움직였을때의 위치.
	            int tmp = horse[cur][1];

	            // ================길 변경================
	            if (horse[cur][1] == 0) {
	                if (horse[cur][0] == 5)
	                    horse[cur][1] = 3;
	                else if (horse[cur][0] == 10)
	                    horse[cur][1] = 2;
	                else if (horse[cur][0] == 15)
	                    horse[cur][1] = 1;
	            }

	            // ================중복체크================
	            boolean flag = false;
	            int j = 0;
	            for (; j < horse.length; j++) {
	                if (cur != j) {
	                    if (horse[cur][0] == horse[j][0] && horse[cur][1] == horse[j][1]) {
	                        flag = true;
	                        break;
	                    } else if ((horse[cur][1] == 1 && horse[cur][0] == 19) || (horse[cur][1] == 2 && horse[cur][0] == 13)
	                            || (horse[cur][1] == 3 && horse[cur][0] == 9)) {
	                        // 25번에 도착했을때
	                        if (horse[j][1] == 1 && horse[j][0] == 19) {// 1번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 2 && horse[j][0] == 13) {// 2번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 3 && horse[j][0] == 9) {// 3번길에 같은위치
	                            flag = true;
	                            break;
	                        }
	                    } else if ((horse[cur][1] == 1 && horse[cur][0] == 20) || (horse[cur][1] == 2 && horse[cur][0] == 14)
	                            || (horse[cur][1] == 3 && horse[cur][0] == 10)) {
	                        // 30번에 도착했을때
	                        if (horse[j][1] == 1 && horse[j][0] == 20) {// 1번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 2 && horse[j][0] == 14) {// 2번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 3 && horse[j][0] == 10) {// 3번길에 같은위치
	                            flag = true;
	                            break;
	                        }
	                    }

	                    else if ((horse[cur][1] == 1 && horse[cur][0] == 21) || (horse[cur][1] == 2 && horse[cur][0] == 15)
	                            || (horse[cur][1] == 3 && horse[cur][0] == 11)) {
	                        // 35번에 도착했을때
	                        if (horse[j][1] == 1 && horse[j][0] == 21) {// 1번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 2 && horse[j][0] == 15) {// 2번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 3 && horse[j][0] == 11) {// 3번길에 같은위치
	                            flag = true;
	                            break;
	                        }
	                    } else if ((horse[cur][1] == 0 && horse[cur][0] == 20) || (horse[cur][1] == 1 && horse[cur][0] == 22)
	                            || (horse[cur][1] == 2 && horse[cur][0] == 16) || (horse[cur][1] == 3 && horse[cur][0] == 12)) {
	                        // 40번에 도착했을때
	                        if (horse[j][1] == 0 && horse[j][0] == 20) {// 0번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 1 && horse[j][0] == 22) {// 1번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 2 && horse[j][0] == 16) {// 2번길에 같은위치
	                            flag = true;
	                            break;
	                        } else if (horse[j][1] == 3 && horse[j][0] == 12) {// 3번길에 같은위치
	                            flag = true;
	                            break;
	                        }
	                    }
	                }
	            }
	            if (flag) {
	                return Integer.MIN_VALUE;
	            }

	            // ================더하기================
	            if (horse[cur][1] == 0 && horse[cur][0] < route0.length)
	                sum += route0[horse[cur][0]];
	            else if (horse[cur][1] == 1 && horse[cur][0] < route1.length)
	                sum += route1[horse[cur][0]];
	            else if (horse[cur][1] == 2 && horse[cur][0] < route2.length)
	                sum += route2[horse[cur][0]];
	            else if (horse[cur][1] == 3 && horse[cur][0] < route3.length)
	                sum += route3[horse[cur][0]];
	        }
	        return sum;
	    }
}
