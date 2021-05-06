package Backjoon;

import java.io.*;
import java.util.*;

public class Main5014 {
    static int f, s, g, u, d;
    static boolean[] visited;
    // f:전체 , s:현재, g:목표. u:업, d:다운
    public static void main(String[] args) throws IOException {
        setting();
    }

    static void setting () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f+1];
        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        int push = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int floor = q.poll();

                if(floor==g) {
                    System.out.println(push); System.exit(0);
                } else if(g-floor>0 && u!=0 && (g-floor)%u==0) {
                    System.out.println(push+(g-floor)/u);
                    System.exit(0);
                } else if(g-floor<0 && d!=0 && (floor-g)%d==0) {
                    System.out.println(push+(floor-g)/d);
                    System.exit(0);
                }
                visited[floor] = true;

                if(floor+u<=f && !visited[floor+u]) {
                    q.add(floor+u);
                }
                if(floor-d>0 && !visited[floor-d]) {
                    q.add(floor-d);
                }
            }
            push++;
        }
        System.out.println("use the stairs");
    }
}