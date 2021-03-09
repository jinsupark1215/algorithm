package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main14606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;

        q.add(N);
        while(!q.isEmpty()) {
            int cur = q.poll();
            int A = cur / 2 ;
            int B = cur - A ;
            count += A*B;

            if(A > 1) q.add(A);
            if(B > 1) q.add(B);
        }
        System.out.println(count);
    }
}
