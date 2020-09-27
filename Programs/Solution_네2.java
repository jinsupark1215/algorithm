package Programs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_네2 {

	public static void main(String[] args) {
		int[][] blocks = {{0,50},{0,22},{2,10},{1,4},{4,-13}};
		System.out.println(Arrays.toString(solution(blocks)));
	}

	static int[][] map;
	static int len;
	private static int[] solution(int[][] blocks) {

		int[] ans = {};
		
		len = blocks.length;
		map = new int[len][len];
		for (int i = 0; i < len; i++) {
			map[i][blocks[i][0]] = blocks[i][1];
		}
		int c = 0;
		
		for (int i = 1; i < len; i++) {
			c = blocks[i][0];
			for (int j = c-1; j >=0; j--) {
				map[i][j] = map[i-1][j] - map[i][j+1];
			}
			for (int j = c+1; j <= i; j++) {
				map[i][j] = map[i-1][j-1] - map[i][j-1];
			}
		}
		int sum = 0;
		for (int i = 1; i <= len; i++) {
			sum += i;
		}
		ans = new int[sum];
		
		int cnt = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		return ans;
	}
}
