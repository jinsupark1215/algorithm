package Programmers;

public class Solution_네웹3 {
    public static void main(String[] args) {
        System.out.println(solution("aabcbcd", "abc"));
        System.out.println(solution("aaaaabbbbb", "ab"));
    }

    private static int solution(String s, String t) {
        int ans = 0;

        while(s.contains(t)){
            s = s.replaceFirst(t,"");
            ans++;
        }

        return ans;
    }
}
