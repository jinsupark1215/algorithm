package Programmers;

import java.util.*;

public class Solution_Line2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CaCbCgCdC888834A")));
    }

    private static int[] solution(String inp_str) {

        ArrayList<Integer> list = new ArrayList<>();
        int length = inp_str.length();
        if(length<8 || length>15){
            list.add(1);
        }

        for (int i = 0; i < length; i++) {

        }

        boolean flag5 = true, flag4 = true, flag2 = true;
        Map<Character, Integer> map = new HashMap<>();
        boolean[] chk = new boolean[4];
        for (int i = 0; i < length; i++) {
            if(inp_str.charAt(i)-'A'>=0&&inp_str.charAt(i)-'Z'<=0){
                chk[0] = true;
            }else if(inp_str.charAt(i)-'a'>=0&&inp_str.charAt(i)-'z'<=0){
                chk[1] = true;
            }else if(inp_str.charAt(i)-'0'>=0&&inp_str.charAt(i)-'9'<=0){
                chk[2] = true;
            }else if((inp_str.charAt(i) =='~') ||
                    (inp_str.charAt(i) =='!') ||
                    (inp_str.charAt(i) =='@') ||
                    (inp_str.charAt(i) =='#') ||
                    (inp_str.charAt(i) =='$') ||
                    (inp_str.charAt(i) =='%') ||
                    (inp_str.charAt(i) =='^') ||
                    (inp_str.charAt(i) =='&') ||
                    (inp_str.charAt(i) =='*')){
                chk[3] = true;
            }else if(flag2){
                list.add(2);
                flag2 = false;
            }

            if(flag5){

            if(!map.containsKey(inp_str.charAt(i))){
                map.put(inp_str.charAt(i), 1);
            }else{
                int value= map.get(inp_str.charAt(i))+1;
                if(value >= 5)flag5=  false;
                map.put(inp_str.charAt(i),value);
            }
            }
            if(i+4 < length && flag4){
            for (int j = i; j < i+4; j++) {
                if(inp_str.charAt(i) != inp_str.charAt(j)){
                    break;
                }
                if(j == i+3)flag4 = false;
            }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if(chk[i])cnt++;
        }
        if(cnt <3)list.add(3);
        if(!flag4)list.add(4);
        if(!flag5)list.add(5);

        int[] answer = new int[1];
        if(list.size() == 0){
            answer[0] = 0;
        }else{
         answer = new int[list.size()];

        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
