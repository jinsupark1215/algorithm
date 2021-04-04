package Programmers;

import java.util.Arrays;

public class Solution_cumos2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,0},{1,1,0},{1,1,0},{1,0,1},{1,1,0},{0,1,1}}, 2));
    }

    static int answer;
    private static int solution(int[][] needs, int r) {
       answer = 0;

       int part = needs[0].length;

       int[] visit = new int[part];
       dfs(visit,0,0,r,needs);

       return answer;
    }

    private static void dfs(int[] visit, int idx,int cnt, int r, int[][] needs) {
        if(cnt == r){
            int finishedcnt = 0;
            boolean flag;
            for (int i = 0; i < needs.length; i++) {
                flag= true;
                for (int j = 0; j < visit.length; j++) {
                    if(visit[j] ==0 && needs[i][j] ==1){
                        flag = false;
                        break;
                    }
                }
                if(flag)finishedcnt++;
            }

            answer = answer<finishedcnt ? finishedcnt : answer;
        }

        for (int i = idx; i < visit.length; i++) {
            if(visit[i]==0){
                visit[i] = 1;
                dfs(visit,i+1,cnt+1,r,needs);
                visit[i] = 0;
            }
        }
    }
}
