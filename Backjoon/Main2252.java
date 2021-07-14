package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;



public class Main2252{
    static int N, M;
    static Node[] adjList;
    static int[] inDegree;
    public static class Node {
        int vertex;
        Node next;

        public Node(int vertex , Node next) {
            super();
            this.vertex = vertex;
            this.next = next;
        }
        @Override
        public String toString() {
            return "Node [vertex=" + vertex + ", next=" + next + "]";
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        adjList = new Node[N+1];
        inDegree = new int[N+1];

        int from, to;
        for(int i = 0; i < M; ++i) {
            str = new StringTokenizer(br.readLine());
            from = Integer.parseInt(str.nextToken());
            to = Integer.parseInt(str.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++;
        }
        System.out.println(go());
    }
    private static String go() {
        Queue<Integer> queue = new LinkedList<Integer>();


        for(int i = 1; i <= N; ++i) {
            if(inDegree[i] == 0) queue.add(i);
        }

        int visitCnt = 0, current;
        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            current = queue.poll();
            visitCnt++;
            builder.append(current).append(" ");

            Node temp = adjList[current];
            while(temp != null) {
                if(--inDegree[temp.vertex] == 0) {
                    queue.add(temp.vertex);
                }
                temp = temp.next;
            }
        }
        return visitCnt == N ? builder.toString() : null;
    }
}
