package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3663 {

	/*
	 * 1. 최소 움직임 횟수
	 * 
	 * 2. 이름의 최대길이 1000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String input = br.readLine();
			int ans = 0;
	        int len = input.length();
	        int moveCount = input.length() - 1;

	        for(int i=0; i<len; i++){
	            char target = input.charAt(i);
	            if(target < 'N') 
	                ans += target - 'A';
	            else
	                ans += 91 - target;
	            //여기까지 위아래로 움직이는거 알페벳 N을 기준으로 잡고 진행

	            int next = i + 1;
	            while(next<len && input.charAt(next) == 'A')
	            	next++;
	            //오른쪽으로 가면서 A면 그냥 넘어가면서 이동하는 경우
	            
	            int b = i + len - next + Math.min(i, len - next);
	            // i 만큼 좌측으로 움직이고, len-right = 맨 끝부터 가야하는 숫자, 좌측과 우측 중 짧은 거리
	            moveCount = Math.min(moveCount, b);
	            
	        }
	        ans += moveCount;
			System.out.println(ans);
		}
	}
}

