package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_dev1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44,1,0,0,31,25},new int[]{31,10,45,1,6,19})));
        System.out.println(Arrays.toString(solution(new int[]{0,0,0,0,0,0},new int[]{38,19,20,40,15,25})));
        System.out.println(Arrays.toString(solution(new int[]{45,4,35,20,3,9},new int[]{20,9,3,45,4,35})));
    }

    private static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int zero=0, chk= 0;
        for (int i = 0; i < 6; i++) {
            if(lottos[i]==0){
                zero++;
                continue;
            }
            for (int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j]){
                    chk++;
                    break;
                }
            }
        }
        answer[1] = chk >=2 ? 7-chk : 6;
        answer[0] = answer[1] -zero ==0? 1 : answer[1]-zero;

        return answer;
    }
}
