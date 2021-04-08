package Programmers;

import java.util.Arrays;

public class Solution_dev2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
        System.out.println(Arrays.toString(solution(3,3,new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2}, {2,2,3,3}})));
        System.out.println(Arrays.toString(solution(100,97,new int[][]{{1,1,100,97}})));
    }

    private static int[] solution(int rows, int columns, int[][] queries) {
        int length = queries.length;
        int[] answer = new int[length];

        int idx = 1;
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = idx++;
            }
        }

        int min,x1,y1,x2,y2,tmp;
        for (int i = 0; i < length; i++) {
            min = Integer.MAX_VALUE;
            x1 = queries[i][0]-1;
            y1 = queries[i][1]-1;
            x2 = queries[i][2]-1;
            y2 = queries[i][3]-1;

            tmp = map[x1][y1];
            min = min > tmp ? tmp : min;
            for (int j = x1; j < x2; j++) {
                map[j][y1] = map[j+1][y1];
                min = min > map[j][y1] ? map[j][y1] : min;
            }
            for (int j = y1; j < y2; j++) {
                map[x2][j] = map[x2][j+1];
                min = min > map[x2][j] ? map[x2][j] : min;
            }
            for (int j = x2; j > x1; j--) {
                map[j][y2] = map[j-1][y2];
                min = min > map[j][y2] ? map[j][y2] : min;
            }
            for (int j = y2; j > y1; j--) {
                map[x1][j] = map[x1][j-1];
                min = min > map[x1][j] ? map[x1][j] : min;
            }
            map[x1][y1+1] = tmp;

            answer[i] = min;
        }


        return answer;
    }

}
