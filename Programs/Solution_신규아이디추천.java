package Programmers;

import java.util.Locale;

public class Solution_신규아이디추천 {
    public static void main(String[] args) {
        System.out.println(Solution("123_.def"));
    }

    private static String Solution(String new_id) {

        String answer ="";
//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        answer = new_id.toLowerCase();
//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        int length = answer.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(answer.charAt(i) =='_' || answer.charAt(i) =='.' || answer.charAt(i) =='-' ||
                    (answer.charAt(i)>='a' && answer.charAt(i) <='z') ||
                    (answer.charAt(i)-'0' >=0 && answer.charAt(i)-'0'<=9)){
                sb.append(answer.charAt(i));
            }
        }
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        length = sb.length();
        for (int i = 0; i < length-1; i++) {
            if(sb.toString().charAt(i) =='.' && sb.toString().charAt(i+1) =='.'){
                sb.delete(i,i+1);
                i--;
                length--;
            }
        }
//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(sb.length()!= 0){
        while(sb.length() !=0 &&sb.toString().charAt(0)=='.')sb.delete(0,1);
        while(sb.length() !=0 &&sb.toString().charAt(sb.length()-1)=='.')sb.delete(sb.length()-1,sb.length());
        }
        if(sb.length() ==0){
            sb.append('a');
        }

//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(sb.length()>15)sb.delete(15,sb.length());
        while(sb.toString().charAt(sb.length()-1)=='.')sb.delete(sb.length()-1,sb.length());

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(sb.length()<=2){
            while(sb.length()<3)sb.append(sb.toString().charAt(sb.length()-1));
        }

        return sb.toString();
    }
}
