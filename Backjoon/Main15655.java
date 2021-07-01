package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15655 {
    static int N, R;
    static int[] nums;
    static int[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        nums = new int[R];
        input = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        go(0, -1);
        System.out.print(sb);
    }

    static void go(int idx, int before) {
        if (idx == R) {
            for (int i = 0; i < R; i++)
                sb.append(nums[i] + " ");
            sb.append("\n");

            return;
        }

        for (int i = before + 1; i < N; i++) {
            nums[idx] = input[i];
            go(idx + 1, i);
        }
    }

}
