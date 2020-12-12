package Programs;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_현카1 {

	public static void main(String[] args) {
		int rows = 4;
		int columns = 3;
		int[][] swipes = {{1,1,2,4,3},{3,2,1,2,3},{4,1,1,4,3},{2,2,1,3,3}};
		System.out.println(Arrays.toString(solution(rows,columns,swipes)));
	}

	private static int[] solution(int rows, int columns, int[][] swipes) {
		int[][] map = new int[rows][columns];
		int idx = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = idx++;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < swipes.length; i++) {
			int sum = 0;
			int tmp =0;
			switch (swipes[i][0]) {
			case 1:
				for (int j = swipes[i][2]-1; j < swipes[i][4]; j++) {
					sum += map[swipes[i][3]-1][j];
				}
				list.add(sum);
				for (int j = swipes[i][2]-1; j < swipes[i][4]; j++) {
					tmp = map[swipes[i][3]-1][j];
					for (int k = swipes[i][3]-1; k > swipes[i][1]-1; k--) {
						map[k][j] = map[k-1][j];
					}
					map[swipes[i][1]-1][j] = tmp;
				}
				break;

			case 2:
				for (int j = swipes[i][2]-1; j < swipes[i][4]; j++) {
					sum += map[swipes[i][1]-1][j];
				}
				list.add(sum);
				for (int j = swipes[i][2]-1; j < swipes[i][4]; j++) {
					tmp = map[swipes[i][1]-1][j];
					for (int k = swipes[i][1]-1; k < swipes[i][3]-1; k++) {
						map[k][j] = map[k+1][j];
					}
					map[swipes[i][3]-1][j] = tmp;
				}
				break;
			case 3:
				for (int j = swipes[i][1]-1; j < swipes[i][3]; j++) {
					sum += map[j][swipes[i][4]-1];
				}
				list.add(sum);
				for (int j = swipes[i][1]-1; j < swipes[i][3]; j++) {
					tmp = map[j][swipes[i][4]-1];
					for (int k = swipes[i][4]-1; k > swipes[i][2]-1; k--) {
						map[j][k] = map[j][k-1];
					}
					map[j][swipes[i][2]-1] = tmp;
				}
				break;
			case 4:
				for (int j = swipes[i][1]-1; j < swipes[i][3]; j++) {
					sum += map[j][swipes[i][2]-1];
				}
				list.add(sum);
				for (int j = swipes[i][1]-1; j < swipes[i][3]; j++) {
					tmp = map[j][swipes[i][2]-1];
					for (int k = swipes[i][2]-1; k < swipes[i][4]-1; k++) {
						map[j][k] = map[j][k+1];
					}
					map[j][swipes[i][4]-1] = tmp;
				}
				break;
			}
		}
		int[] ans = new int[list.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

}
