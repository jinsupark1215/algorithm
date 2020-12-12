package Programs;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_현카4 {

	public static void main(String[] args) {
		String S1 = "ppwwwbpbbwwbw";
		String S2 = "pwbwpwwbw";
		
		System.out.println(solution(S1,S2));
	}

	private static int solution(String S1, String S2) {
		
		boolean[][] map = new boolean[4][4];
		int ans = 0;
		int idx = 0;
		if(S1.charAt(0) == 'p') {
			//1사분면
			if(S1.charAt(1) == 'p') {
				if(S1.charAt(2) == 'b') {
					map[0][2] = true;
				}
				if(S1.charAt(3) == 'b') {
					map[0][3] = true;
				}
				if(S1.charAt(4) == 'b') {
					map[1][2] = true;
				}
				if(S1.charAt(5) == 'b') {
					map[1][3] = true;
				}
				idx = 6;
			}else if(S1.charAt(2) == 'b') {
				map[0][2] = true;
				map[0][3] = true;
				map[1][2] = true;
				map[1][3] = true;
				idx = 3;
			}
			//2사분면
			if(S1.charAt(idx) == 'p') {
				if(S1.charAt(7) == 'b') {
					map[0][0] = true;
				}
				if(S1.charAt(8) == 'b') {
					map[0][1] = true;
				}
				if(S1.charAt(9) == 'b') {
					map[1][0] = true;
				}
				if(S1.charAt(10) == 'b') {
					map[1][1] = true;
				}
				idx = idx+5;
			}else if(S1.charAt(idx) == 'b') {
				map[0][0] = true;
				map[0][1] = true;
				map[1][0] = true;
				map[1][1] = true;
				idx = idx+1;
			}
			
			//3사분면
			if(S1.charAt(idx) == 'p') {
				if(S1.charAt(12) == 'b') {
					map[2][0] = true;
				}
				if(S1.charAt(13) == 'b') {
					map[2][1] = true;
				}
				if(S1.charAt(14) == 'b') {
					map[3][0] = true;
				}
				if(S1.charAt(15) == 'b') {
					map[3][1] = true;
				}
				idx = idx+5;
			}else if(S1.charAt(idx) == 'b') {
				map[2][0] = true;
				map[2][1] = true;
				map[3][0] = true;
				map[3][1] = true;
				idx = idx+1;
			}
			//4사분면
			if(S1.charAt(idx) == 'p') {
				if(S1.charAt(17) == 'b') {
					map[2][2] = true;
				}
				if(S1.charAt(18) == 'b') {
					map[2][3] = true;
				}
				if(S1.charAt(19) == 'b') {
					map[3][2] = true;
				}
				if(S1.charAt(20) == 'b') {
					map[3][3] = true;
				}
			}else if(S1.charAt(idx) == 'b') {
				map[2][2] = true;
				map[2][3] = true;
				map[3][2] = true;
				map[3][3] = true;
			}
		}else if(S1.charAt(0) =='b') {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = true;
				}
			}
		}
		idx= 0;
		if(S2.charAt(0) == 'p') {
			//1사분면
			if(S2.charAt(1) == 'p') {
				if(S2.charAt(2) == 'b') {
					map[0][2] = true;
				}
				if(S2.charAt(3) == 'b') {
					map[0][3] = true;
				}
				if(S2.charAt(4) == 'b') {
					map[1][2] = true;
				}
				if(S2.charAt(5) == 'b') {
					map[1][3] = true;
				}
				idx = 6;
			}else if(S2.charAt(2) == 'b') {
				map[0][2] = true;
				map[0][3] = true;
				map[1][2] = true;
				map[1][3] = true;
				idx = 3;
			}
			//2사분면
			if(S2.charAt(idx) == 'p') {
				if(S2.charAt(7) == 'b') {
					map[0][0] = true;
				}
				if(S2.charAt(8) == 'b') {
					map[0][1] = true;
				}
				if(S2.charAt(9) == 'b') {
					map[1][0] = true;
				}
				if(S2.charAt(10) == 'b') {
					map[1][1] = true;
				}
				idx = idx+5;
			}else if(S2.charAt(idx) == 'b') {
				map[0][0] = true;
				map[0][1] = true;
				map[1][0] = true;
				map[1][1] = true;
				idx = idx+1;
			}
			
			//3사분면
			if(S2.charAt(idx) == 'p') {
				if(S2.charAt(12) == 'b') {
					map[2][0] = true;
				}
				if(S2.charAt(13) == 'b') {
					map[2][1] = true;
				}
				if(S2.charAt(14) == 'b') {
					map[3][0] = true;
				}
				if(S2.charAt(15) == 'b') {
					map[3][1] = true;
				}
				idx = idx+5;
			}else if(S2.charAt(idx) == 'b') {
				map[2][0] = true;
				map[2][1] = true;
				map[2][0] = true;
				map[2][1] = true;
				idx = idx+1;
			}
			//4사분면
			if(S2.charAt(idx) == 'p') {
				if(S2.charAt(17) == 'b') {
					map[2][2] = true;
				}
				if(S2.charAt(18) == 'b') {
					map[2][3] = true;
				}
				if(S2.charAt(19) == 'b') {
					map[3][2] = true;
				}
				if(S2.charAt(20) == 'b') {
					map[3][3] = true;
				}
			}else if(S2.charAt(idx) == 'b') {
				map[2][2] = true;
				map[2][3] = true;
				map[3][2] = true;
				map[3][3] = true;
			}
		}else if(S2.charAt(0) =='b') {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(map[i][j])ans+=64;
			}
		}
		return ans;
	}


}
