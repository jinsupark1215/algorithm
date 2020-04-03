package Programs;

import java.util.Arrays;

public class Solution_땅따먹기 {

	/*
	 * [프로그래머스] 땅따먹기
	 * 
	 * 1. 최고점 ?
	 * 
	 * 2. N <= 100,000
	 * 
	 * 3. 완탐 -> 시간초과
	 * dp
	 */
	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));
	}

	private static int solution(int[][] land) {
		for(int i=1; i<land.length; i++) {
			land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
			land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
			land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
			land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
		}
        
        for(int i=0; i<land.length; i++){
            Arrays.sort(land[i]);
        }
        return land[land.length-1][3];
	}

}
