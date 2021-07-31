package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main11437 {
    static BufferedReader br;
    static StringTokenizer st;
    static int v, maxDepth;
    static List<Integer>[] map;
    static int[][] pArr;
    static int[] depth;
    static boolean[] isVisit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());

        maxDepth = (int) Math.ceil(Math.log(v)/Math.log(2));
        map = new ArrayList[v+1];
        for(int i = 1; i <= v; i ++) {
            map[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < v-1; i ++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s].add(e);
            map[e].add(s);
        }

        pArr = new int[maxDepth][v+1];
        depth = new int[v+1];
        isVisit = new boolean[v+1];

        dfs(1, 0, 0);

        for(int i = 0; i < maxDepth-1; i ++) {
            for(int j = 1; j <= v; j++) {
                int tempNode = pArr[i][j];
                pArr[i+1][j] = pArr[i][tempNode];
            }
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i ++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(lcs(s, e)).append("\n");
        }

        System.out.println(sb);
    }

    public static int lcs(int a, int b) {

        if(depth[a] < depth[b]) {
            int temp = b;
            b = a;
            a = temp;
        }


        for(int i = maxDepth-1; i >= 0; i--) {
            if(depth[a] - depth[b] >= (1 << i)) {
                a = pArr[i][a];
            }
        }

        if(a == b) return a;

        for(int i = maxDepth-1; i >=0 ; i--) {
            if(pArr[i][a] != pArr[i][b]) {
                a = pArr[i][a];
                b = pArr[i][b];
            }
        }

        return pArr[0][a];
    }


    public static void dfs(int n, int p, int d) {

        depth[n] = d;
        pArr[0][n] = p;
        isVisit[n] = true;

        for(int nextNode : map[n]) {
            if(isVisit[nextNode]) continue;

            dfs(nextNode, n, d+1);
        }
    }
}