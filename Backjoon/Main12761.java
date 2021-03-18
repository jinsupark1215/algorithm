package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12761 {

    static int A, B, N, M, res;
    static boolean[] flag= new boolean[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bfs();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(N, 0));
        flag[N] = true;

        int[] dis= {B, A, B, A, 1, -B, -A, -1};
        Node point;
        int next;
        while (!queue.isEmpty()) {
            point = queue.poll();

            if(point.num == M) {
                System.out.println(point.count);
                return;
            }


            for(int i=0; i<8; i++) {
                if(i<2) {
                    next = point.num*+ dis[i];
                }else {
                    next = point.num + dis[i];
                }

                if(next<0 || next>100000)	continue;
                if(flag[next])	continue;

                queue.offer(new Node(next, point.count+1));
                flag[next]=true;

            }
        }
    }

    static class Node{
        int num;
        int count;

        Node(int num, int count){
            this.num=num;
            this.count=count;
        }
    }
}
