package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18242 {

	/*
	 * 1. 정사각형의 색칠하지 않은 한 변이 어디인지 찾기
	 * 
	 * 2. N,M <= 100
	 * 
	 * 3. 맨 위 왼쪽과 맨 아래 오른쪽의 좌표를 구해서 판단 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int sr =0, sc =0, er=0, ec =0, idx =0;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char tmp = input.charAt(j);
				map[i][j] = tmp;
				if(tmp == '#') {
					if(idx == 0) {
						sr = i;
						sc = j;
					}else {
						er = i;
						ec = j;
					}
					idx++;
				}
			}
		}
		
		
		//위에 갯수세기
		int upcnt= 0;
		for (int i = sc; i <= ec; i++) {
			if(map[sr][i] == '#')upcnt++;
		}
		//아래에 갯수세기
		int downcnt= 0;
		for (int i = sc; i <= ec; i++) {
			if(map[er][i] == '#')downcnt++;
		}
		//왼쪽에 갯수세기
		int leftcnt= 0;
		for (int i = sr; i <= er; i++) {
			if(map[i][sc] == '#')leftcnt++;
		}
		//오른에 갯수세기
		int rightcnt= 0;
		for (int i = sr; i <= er; i++) {
			if(map[i][ec] == '#')rightcnt++;
		}
		if(upcnt == downcnt) {
			if(leftcnt < rightcnt)System.out.println("LEFT");
			else System.out.println("RIGHT");
		}else if(leftcnt == rightcnt) {
			if(upcnt < downcnt)System.out.println("UP");
			else System.out.println("DOWN");
		}
	}
}

