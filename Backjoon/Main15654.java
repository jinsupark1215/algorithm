package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654 {
    public static int N, M, w[], a[];
    public static boolean v[];
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        w = new int[M];
        v = new boolean[N];
        nPr(0);
        System.out.print(sb);
    }

    public static void nPr(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(w[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                w[cnt] = a[i];
                nPr( cnt + 1);
                v[i] = false;
            }
        }
    }

}