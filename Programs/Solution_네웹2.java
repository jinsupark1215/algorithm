package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_네웹2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abcxyasdfasdfxyabc")));
        System.out.println(Arrays.toString(solution("abcxyqwertyxyabc")));
        System.out.println(Arrays.toString(solution("abcabcabcabc")));
        System.out.println(Arrays.toString(solution("llttaattll")));
        System.out.println(Arrays.toString(solution("zzzzzz")));
        System.out.println(Arrays.toString(solution("abcdef")));
    }

    private static String[] solution(String s) {
        String[] ans = {};

        ArrayList<String> list = new ArrayList<>();

        int leftStart = 0;
        int leftEnd = 1;
        int rightStart = s.length()-1;
        int rightEnd = s.length();
        while(leftEnd < rightStart){
            if(s.substring(leftStart, leftEnd).equals(s.substring(rightStart, rightEnd))){
                list.add(s.substring(leftStart,leftEnd));
                leftStart = leftEnd;
                leftEnd++;
                rightEnd = rightStart;
                rightStart--;
            }else{
                leftEnd++;
                rightStart--;
            }
        }
        if(s.substring(leftStart, leftEnd).equals(s.substring(rightStart, rightEnd))){
            list.add(s.substring(leftStart, leftEnd));
            for (int i = list.size()-1; i >=0 ; i--) {
                list.add(list.get(i));
            }
        }else{
            list.add(s.substring(leftStart, rightEnd));
            for (int i = list.size()-2; i >=0; i--) {
                list.add(list.get(i));
            }
        }

        ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
