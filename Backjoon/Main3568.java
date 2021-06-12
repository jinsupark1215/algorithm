package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String variable = br.readLine();
        String[] variables = variable.split(" ");
        int length = variables.length;
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < length; i++) {
            answer.append(variables[0]);
            int tmp_len = variables[i].length();
            int index = tmp_len - 2;

            for (; index >= 0; index--) {
                char tmp = variables[i].charAt(index);
                if (tmp == '*' || tmp == '&') answer.append(tmp);
                else if (tmp == '[') answer.append("[]");
                else if (tmp != ']') break;
            }
            answer.append(" " + variables[i].substring(0, index + 1)).append(";\n");
        }
        System.out.println(answer);
    }

}