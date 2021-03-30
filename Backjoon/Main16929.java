package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> circle = new LinkedList<Integer>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int i,j,n,m,cycle,rot,tmp;
        int[][] arr = new int[N+1][M+1];
        for(i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(j = 1 ; j <= M ; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        cycle = Math.min(N, M)/2;
        n = N;
        m = M;
        for(i = 1 ; i <= cycle ; i++) {
            rot = R;
            for(j = i ; j < M ; j++) circle.add(arr[i][j]);
            for(j = i ; j < N ; j++) circle.add(arr[j][M]);
            for(j = M ; j > i ; j--) circle.add(arr[N][j]);
            for(j = N ; j > i ; j--) circle.add(arr[j][i]);
            rot %= circle.size();
            while(rot-- > 0) {
                tmp = circle.peek();
                circle.poll();
                circle.offer(tmp);
            }
            for(j = i ; j < M ; j++) arr[i][j] = circle.poll();
            for(j = i ; j < N ; j++) arr[j][M] = circle.poll();
            for(j = M ; j > i ; j--) arr[N][j] = circle.poll();
            for(j = N ; j > i ; j--) arr[j][i] = circle.poll();
            N--;
            M--;
        }

        for(i = 1 ; i <= n ; i++) {
            for(j = 1 ; j <= m ; j++) sb.append(arr[i][j]).append(" ");
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
