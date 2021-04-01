package Backjoon;

import java.io.*;
import java.util.Stack;

public class Main12789 {
    public static void main(String argc[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int expected = 1;
        Stack<Integer> stack = new Stack<Integer>();
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(line[i]);
            if(value != expected){
                if(!stack.isEmpty() && expected == stack.peek()){
                    stack.pop();
                    expected++;
                    i--;
                }
                else {
                    stack.push(value);
                }
            } else {
                expected++;
            }
        }
        while(!stack.isEmpty()){
            if(expected == stack.peek()) {
                stack.pop();
                expected++;
            } else {
                bw.write("Sad\n");
                bw.flush();
                return;
            }
        }
        bw.write("Nice\n");
        bw.flush();
    }
}
