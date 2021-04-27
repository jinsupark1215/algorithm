package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1707 {
    static int K, N, M;
    static List<Integer> list[];
    static int vt[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new List[N + 1];
            vt = new int[N + 1];
            for (int i = 1 ; i <= N ; i++) {
                list[i] = new ArrayList<Integer>();
            }
            for (int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            boolean res = true;
            for (int i = 1 ; i <= N ; i++) {
                if (vt[i] == 0) {
                    if (!dfs(i, 1)) {
                        res = false;
                        break;
                    }
                }
            }
            System.out.println(res ? "YES" : "NO");
        }
    }
    public static boolean dfs(int k, int c) {
        if (vt[k] != 0) {
            return vt[k] == c;
        }
        vt[k] = c;
        if (c == 1) c = 2;
        else c = 1;
        for (int i = 0 ; i < list[k].size() ; i++) {
            if (!dfs(list[k].get(i), c)) {
                return false;
            }
        }
        return true;
    }
}