package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10275 {
    /*
    [백준] 골드러시

    1. 최대한 빨리 떠났을 때

    2. n <=62

    3. 구현
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n;
        long a, b;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            System.out.println(gold(n, a, b));
        }
        return;
    }

    public static int gold(int n, long a, long b) {
        int i = 0;
        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
            i++;
        }
        return n - i;
    }
}
