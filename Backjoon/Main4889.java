package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4889 {
    /*
    [백준] 안정적인 문자열

    1. 필요한 최소 연산수
    
    2. 
    
    3. 구현
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        int T = 1;
        while ((str = br.readLine()).charAt(0) != '-') {
            char[] stack = str.toCharArray();
            int answer = 0, top = 0;
            for (int i = 0; i < stack.length; i++) {
                if (stack[i] == '{') stack[top++] = stack[i];
                else if (top == 0) {
                    stack[top++] = '{';
                    answer++;
                } else top--;
            }
            answer += top / 2;
            sb.append(T++ + ". " + answer + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}
