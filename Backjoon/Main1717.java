package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1717 {
    static int N;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        p = new int[N+1];
        Arrays.fill(p, -1);

        StringBuilder sb = new StringBuilder();
        int c;
        int a, pa;
        int b, pb;
        for (int comm = 0; comm < M; comm++) {
            st = new StringTokenizer(br.readLine()," ");
            c = stoi(st.nextToken());
            a = stoi(st.nextToken());
            b = stoi(st.nextToken());
            if(c == 0) {
                pa = find(a);
                pb = find(b);
                if(pa==pb) continue;
                p[pb] = pa;
            }
            else {
                pa = find(a);
                pb = find(b);
                sb.append( (pa==pb)?"YES":"NO" ).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static int find(int a) {
        if(p[a]==-1)
            return a;
        return p[a]=find(p[a]);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
