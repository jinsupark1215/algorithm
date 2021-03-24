package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20937 {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[50002];
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i=0;i<n;i++) {
            int x = Integer.parseInt(st.nextToken());
            cnt[x]++;
            ans = Math.max(ans, cnt[x]);
        }
        System.out.println(ans);
    }
}
