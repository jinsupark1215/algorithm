package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_dev3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
        ,new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
        ,new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10})));

        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
                ,new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
                ,new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4})));
    }

    private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        int length = amount.length;
        Map<String, Integer> idxKey = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            idxKey.put(enroll[i], i);
        }
        int money, idx;
        for (int i = 0; i < length; i++) {
            money = amount[i] * 100;
            idx = idxKey.get(seller[i]);
            while(true){
                if(money*0.1 == 0){
                    answer[idx] += money;
                }else{
                    answer[idx] += money - (money/10);
                }
                money /= 10;
                if(referral[idx].equals("-")){
                    break;
                }
                idx = idxKey.get(referral[idx]);
            }
        }
        return answer;
    }


}
