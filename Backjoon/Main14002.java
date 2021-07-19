package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14002 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n];
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];

        int[] order = new int[n];

        int max = 0;
        for(int i=0; i<n; i++) {
            int next = num[i];
            if(answer[max]<next) {
                answer[++max] = next;
                order[i] = max;
            }
            else if(answer[max]==next) {
                order[i] = max;
                continue;
            }
            else {
                int l = 1;
                int r = max;
                while(l<r) {
                    int mid = (l+r)/2;
                    if(next<=answer[mid]) r=mid;
                    else l=mid+1;
                }
                order[i] = l;
                answer[l] = next;
            }
        }
        Stack<Integer> s = new Stack<Integer>();
        int count = max;

        for(int i=n-1; i>=0; i--)
            if(order[i]==count) {
                s.push(num[i]);
                count--;
            }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append(System.lineSeparator());
        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.print(sb);
    }

}
