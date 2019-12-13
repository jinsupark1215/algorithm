package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1063 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		String king = st.nextToken();
		char kr = king.charAt(0);
		int kc = king.charAt(1)-'0';
		String stone = st.nextToken();
		char sr = stone.charAt(0);
		int sc = stone.charAt(1)-'0';
		int n = Integer.parseInt(st.nextToken());
		
		
		/*
		 * 1. 문제 이해 : 킹과 돌의 마지막 위치 구하기
		 * 
		 * 2. 제약 조건 : 맵의 바깥으로 나갈 수 없음. 
		 * 			     킹이 가고가하는 방향에 돌이 있으면 돌도 킹의 이동방향으로 움직임.
		 * 			     돌이 맵의 바깥으로 나갔을 떄 그전 방향으로 다시 돌아오기.
		 * 
		 *  3. 로직 : 킹과 돌의 위치를 저장해두고 위치만 변경해가며 체크.조건 잘 확인하기.
		 *  
		 */
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			switch (input) {
			case "R":
				if(kr-'H'<0) {
					kr = (char) (kr+1);
					
					if(kr == sr && kc == sc) {
						sr = (char) (sr+1);
						if(sr - 'H' >0) {
							sr = (char) (sr-1);
							kr = (char) (kr-1);
							
						}
					}
				}
				break;
			case "L":
				if(kr-'A'>0) {
					kr = (char) (kr-1);
					if(kr == sr && kc == sc) {
						sr = (char) (sr-1);
						if(sr - 'A' <0) {
							sr = (char) (sr+1);
							kr = (char) (kr+1);
							
						}
					}
				}
				break;
			case "B":
				if(kc > 1) {
					kc = kc-1;
					if(kr == sr && kc == sc) {
						sc = sc-1;
						if(sc < 1) {
							sc = sc +1;
							kc = kc+1;
							
						}
					}
				}
				break;
			case "T":
				if(kc < 8) {
					kc = kc+1;
					if(kr == sr && kc == sc) {
						sc = sc+1;
						if(sc > 8) {
							sc = sc -1;
							kc = kc-1;
							
						}
					}
				}
				break;
			case "RT":
				if(kr-'H'<0 && kc < 8) {
					kr = (char) (kr+1);
					kc = kc+1;
					if(kr == sr && kc == sc) {
						sr = (char) (sr+1);
						sc = sc+1;
						if(sr - 'H' >0 || sc > 8) {
							sc = sc -1;
							kc = kc-1;
							sr = (char) (sr-1);
							kr = (char) (kr-1);
						}
					}
				}
				break;
			case "LT":
				if(kr-'A'>0 && kc < 8) {
					kr = (char) (kr-1);
					kc = kc+1;
					if(kr == sr && kc == sc) {
						sr = (char) (sr-1);
						sc = sc+1;
						if(sr - 'A' <0 || sc > 8) {
							sc = sc -1;
							kc = kc-1;
							sr = (char) (sr+1);
							kr = (char) (kr+1);
						}
					}
				}
				break;
			case "RB":
				if(kr-'H'<0 && kc > 1) {
					kr = (char) (kr+1);
					kc = kc-1;
					if(kr == sr && kc == sc) {
						sr = (char) (sr+1);
						sc = sc-1;
						if(sr - 'H' >0 ||sc < 1) {
							sc = sc +1;
							kc = kc+1;
							sr = (char) (sr-1);
							kr = (char) (kr-1);
						}
					}
				}
				break;
			case "LB":
				if(kr-'A'>0 && kc > 1) {
					kr = (char) (kr-1);
					kc = kc-1;
					if(kr == sr && kc == sc) {
						sr = (char) (sr-1);
						sc = sc-1;
						if(sr - 'A' <0 || sc < 1) {
							sc = sc +1;
							kc = kc+1;
							sr = (char) (sr+1);
							kr = (char) (kr+1);
						}
					}
				}
				break;

			}
		}
		
		System.out.print(kr);
		System.out.println(kc);
		System.out.print(sr);
		System.out.println(sc);
	}
}
