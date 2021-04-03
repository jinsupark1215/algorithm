package Programmers;

public class Solution_cumos1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,5,3,2,1}, new int[]{2,4,4,5,1}));
        System.out.println(solution(new int[]{5,4,5,4,5}, new int[]{1,2,3,5,4}));
    }

    private static int solution(int[] gift_cards, int[] wants) {
        int[] count = new int[100001];

        int answer =0;
        int length = gift_cards.length;
        for (int i = 0; i < length; i++) {
            count[gift_cards[i]]++;
        }

        for (int i = 0; i < length; i++) {
            if(count[wants[i]]> 0){
                count[wants[i]]--;
            }else{
                answer++;
            }
        }
        return answer;
    }
}
