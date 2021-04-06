package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_cumos3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6,new int[]{1,1,1,1,1,1}, new int[][]{{1,2},{1,3},{1,4},{3,5},{3,6}})));
        System.out.println(Arrays.toString(solution(4,new int[]{2,1,2,2}, new int[][]{{1,2},{1,3}, {2,4}})));
        System.out.println(Arrays.toString(solution(5,new int[]{1,1,2,3,4}, new int[][]{{1,2},{1,3},{1,4},{1,5}})));
    }

    private static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];

        boolean[][] map = new boolean[n][n];
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n-1; i++) {
            map[train[i][0]-1][train[i][1]-1] = true;
            map[train[i][1]-1][train[i][0]-1] = true;
        }

        visit[0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,passenger[0]});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(answer[1] <= cur[1]){
                answer[0] = cur[0]+1;
                answer[1] = cur[1];
            }

            for (int i = 0; i < n; i++) {
                if(map[cur[0]][i] && !visit[i]){
                    visit[i] = true;
                    queue.add(new int[]{i,cur[1]+passenger[i]});
                }
            }
        }

        return answer;
    }
}
