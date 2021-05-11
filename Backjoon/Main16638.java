package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main16638 {
    static int N;
    static int[] num;
    static char[] sign;
    static int[] selected;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        num = new int[N/2+1];
        selected = new int[N/2+1];
        sign = new char[N/2];
        for(int i=0; i<str.length(); i++) {
            if(i%2==0) {
                num[i/2] = str.charAt(i) - '0';
            }else {
                sign[i/2] = str.charAt(i);
            }
        }
        solve(0);
        System.out.println(max);
    }
    private static void solve(int cnt) {
        if(cnt == N/2) {
            ArrayDeque<String> queue = new ArrayDeque<>();
            for(int i=0; i<=N/2; i++) {
                if(selected[i] == 1) {
                    String temp = math(Integer.toString(num[i]),Character.toString(sign[i]),Integer.toString(num[i+1]));
                    queue.offer(temp);

                }else if(selected[i] == -1 && i<N/2) {
                    queue.offer(Character.toString(sign[i]));
                }
                else if(selected[i] == 0) {
                    queue.offer(Integer.toString(num[i]));
                    if(i<N/2)
                        queue.offer(Character.toString(sign[i]));
                }
            }
            ArrayDeque<String> queue2 = new ArrayDeque<>();
            for(int i=0, size = queue.size(); i<size; i++) {
                if(!queue.peek().equals("*")) {
                    queue2.offer(queue.pop());
                }
                else {
                    queue2.offer(math(queue2.pollLast(),queue.poll(),queue.poll()));
                    size--;
                }
            }
            String start = queue2.poll();
            while(!queue2.isEmpty()) {
                start = math(start, queue2.poll(), queue2.poll());
            }
            max = Math.max(max, Integer.parseInt(start));
            return;
        }
        if(sign[cnt] == '*') {
            solve(cnt+1);
        }
        else {
            if(selected[cnt] == 0) {
                selected[cnt] = 1; selected[cnt+1] = -1;
                solve(cnt+1);
                selected[cnt] = 0; selected[cnt+1] = 0;
            }
            solve(cnt+1);
        }

    }
    private static String math(String a, String csign, String b) {
        int result = 0;
        int numa = Integer.parseInt(a);
        int numb = Integer.parseInt(b);
        switch(csign){
            case "+": result = numa + numb;
                break;
            case "-": result = numa - numb;
                break;
            case "*": result = numa * numb;
                break;
        }
        return Integer.toString(result);
    }

}
