package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11438{
    static int N, M;
    static int[] visited, dist;
    static int[][] parent;
    static List<Integer>[] adjList;

    static long ans;
    final static int MAX = 16;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        visited = new int[N+1];
        parent = new int[MAX+1][N+1];
        adjList = new ArrayList[N+1];

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(adjList[a] == null) {
                adjList[a] = new ArrayList<Integer>();
            }
            adjList[a].add(b);

            if(adjList[b] == null) {
                adjList[b] = new ArrayList<Integer>();
            }
            adjList[b].add(a);
        }
        bfs(1);
        for(int k = 0; k < MAX; k++) {
            for(int i=1; i <= N; i++) {
                parent[k+1][i] = parent[k][parent[k][i]];
            }
        }
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for(int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(String.valueOf(lca(a, b))).append("\n");
        }
        System.out.println(sb.toString());

    }
    private static void bfs(int a) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(a);
        visited[a] = 1;
        dist[a] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(adjList[cur] != null) {

                for(int next : adjList[cur]) {
                    if(visited[next] == 0) {
                        q.add(next);
                        visited[next] = 1;
                        dist[next] = dist[cur] + 1;
                        parent[0][next] = cur;
                    }

                }
            }
        }
    }

    private static int lca(int a, int b) {
        if(dist[a] < dist[b]) {
            return lca(b,a);
        }

        int diff = dist[a] - dist[b];
        int k = 0 ;
        while(diff > 0) {
            if(diff % 2 == 1) {
                a = parent[k][a];
            }
            diff /=2;
            k++;
        }
        if(a == b) {
            return a;
        }

        for (k = MAX; k>=0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        a = parent[0][a];
        return a;
    }
}

