package Programmers;

import java.util.Arrays;

public class Solution_네웹1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{13000,88000,10000}, new int[]{30,20}));
        System.out.println(solution(new int[]{32000,18000,42500}, new int[]{50,20,65}));
    }

    private static int solution(int[] prices, int[] discounts) {
        int ans = 0;

        int idx = discounts.length-1;
        Arrays.sort(prices);
        Arrays.sort(discounts);

        for (int i = prices.length-1; i >=0 ; i--) {
            if(idx >=0){
                ans += prices[i] - ((prices[i] * discounts[idx])/100);
            }else{
                ans += prices[i];
            }
            idx--;
        }
        return ans;
    }
}
