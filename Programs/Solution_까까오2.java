package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_까까오2 {

	/*
	 * 1. *,+,-의 우선순위를 바꿔 절댓값이 가장 큰 값
	 * 
	 * 2. 숫자 <=999
	 * 
	 * 3. 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = "100-200*300-500+20";

		System.out.println(solution(expression));
	}

	private static long solution(String expression) {
		Stack<String>[] stacks = new Stack[6];
        for(int i = 0; i < 6; i++) {
            stacks[i] = new Stack<>();
        }
        String[] digit = expression.split("[+\\-*]");
        String[] operator = expression.split("[0-9]+");
        String[][] postfix = new String[6][digit.length + operator.length - 1];
        int[] index = new int[6];
        index[0] = index[1] = index[2] = index[3] = index[4] = index[5] = 1;
        postfix[0][0] = postfix[1][0] = postfix[2][0] = postfix[3][0] = postfix[4][0] = postfix[5][0] = digit[0];
        for(int i = 1; i < operator.length; i++) {
            if("-".equals(operator[i])) {
                while(!stacks[0].isEmpty()) {
                    postfix[0][index[0]++] = stacks[0].pop();
                }
                while (!stacks[1].isEmpty() && ("-".equals(stacks[1].peek()) || "*".equals(stacks[1].peek()))) {
                    postfix[1][index[1]++] = stacks[1].pop();
                }
                while(!stacks[2].isEmpty()) {
                    postfix[2][index[2]++] = stacks[2].pop();
                }
                while (!stacks[3].isEmpty() && ("-".equals(stacks[3].peek()) || "+".equals(stacks[3].peek()))) {
                    postfix[3][index[3]++] = stacks[3].pop();
                }
                while(!stacks[4].isEmpty() && "-".equals(stacks[4].peek())) {
                    postfix[4][index[4]++] = stacks[4].pop();
                }
                while(!stacks[5].isEmpty() && "-".equals(stacks[5].peek())) {
                    postfix[5][index[5]++] = stacks[5].pop();
                }
            } else if("+".equals(operator[i])) {
                while (!stacks[0].isEmpty() && ("+".equals(stacks[0].peek()) || "*".equals(stacks[0].peek()))) {
                    postfix[0][index[0]++] = stacks[0].pop();
                }
                while(!stacks[1].isEmpty()) {
                    postfix[1][index[1]++] = stacks[1].pop();
                }
                while(!stacks[2].isEmpty() && "+".equals(stacks[2].peek())) {
                    postfix[2][index[2]++] = stacks[2].pop();
                }
                while(!stacks[3].isEmpty() && "+".equals(stacks[3].peek())) {
                    postfix[3][index[3]++] = stacks[3].pop();
                }
                while(!stacks[4].isEmpty()) {
                    postfix[4][index[4]++] = stacks[4].pop();
                }
                while (!stacks[5].isEmpty() && ("-".equals(stacks[5].peek()) || "+".equals(stacks[5].peek()))) {
                    postfix[5][index[5]++] = stacks[5].pop();
                }
            } else if("*".equals(operator[i])) {
                while(!stacks[0].isEmpty() && "*".equals(stacks[0].peek())) {
                    postfix[0][index[0]++] = stacks[0].pop();
                }
                while(!stacks[1].isEmpty() && "*".equals(stacks[1].peek())) {
                    postfix[1][index[1]++] = stacks[1].pop();
                }
                while (!stacks[2].isEmpty() && ("+".equals(stacks[2].peek()) || "*".equals(stacks[2].peek()))) {
                    postfix[2][index[2]++] = stacks[2].pop();
                }
                while(!stacks[3].isEmpty()) {
                    postfix[3][index[3]++] = stacks[3].pop();
                }
                while (!stacks[4].isEmpty() && ("-".equals(stacks[4].peek()) || "*".equals(stacks[4].peek()))) {
                    postfix[4][index[4]++] = stacks[4].pop();
                }
                while(!stacks[5].isEmpty()) {
                    postfix[5][index[5]++] = stacks[5].pop();
                }
            }
            for(int j = 0; j < 6; j++) {
                stacks[j].push(operator[i]);
                postfix[j][index[j]++] = digit[i];
            }

        }
        long a, b;
        long max = Integer.MIN_VALUE;
        for(int j = 0; j < 6; j++) {
            while(!stacks[j].isEmpty()) {
                postfix[j][index[j]++] = stacks[j].pop();
            }
            for (int i = 0; i < digit.length + operator.length - 1; i++) {
                if (!("*".equals(postfix[j][i]) || "+".equals(postfix[j][i]) || "-".equals(postfix[j][i]))) {
                    stacks[j].push(postfix[j][i]);
                } else {
                    a = Long.parseLong(stacks[j].pop());
                    b = Long.parseLong(stacks[j].pop());
                    if ("*".equals(postfix[j][i])) {
                        stacks[j].push(b * a + "");
                    } else if ("+".equals(postfix[j][i])) {
                        stacks[j].push(b + a + "");
                    } else {
                        stacks[j].push(b - a + "");
                    }
                }
            }
            max = Math.max(max, Math.abs(Long.parseLong(stacks[j].peek())));
        }
        return max;
	}
}
