package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9934 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = (int) Math.pow(2, N);
        int[][] tree = new int[N][max];
        int[] map = new int[max];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < max - 1; i++) {
            map[i] = Integer.parseInt(input[i]);
        }

        int level = N;
        int startIdx = 0;
        while (level-- > 0) {
            int start = (int) Math.pow(2, startIdx) - 1;
            int acc = (int) Math.pow(2, startIdx + 1);

            int len = (int) Math.pow(2, level);
            for (int i = 0; i < len; i++) {
                tree[level][i] = map[start];
                start += acc;
            }
            startIdx += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < N; l += 1) {
            int len = (int) Math.pow(2, l);
            for (int i = 0; i < len; i++) {
                sb.append(tree[l][i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
