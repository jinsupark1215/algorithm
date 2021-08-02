package Backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main2618 {
    public static int[][] list = new int[1002][2];
    public static int event_num, line_num;
    public static int[][] dp = new int[1002][1002];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line_num = Integer.parseInt(br.readLine());
        event_num = Integer.parseInt(br.readLine());
        for (int x = 1; x <= event_num; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[x][0] = Integer.parseInt(st.nextToken());
            list[x][1] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(police(1, 0, 0)) + "\n");
        int index_one = 0;
        int index_two = 0;
        for (int index = 1; index <= event_num; index++) {
            int one_remain = distance(1, index_one, index);
            if (dp[index_one][index_two] - one_remain == dp[index][index_two]) {
                index_one = index;
                bw.write("1\n");
            } else {
                index_two = index;
                bw.write("2\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int police(int index, int one, int two) {
        if (index > event_num) return 0;
        if (dp[one][two] != 0) return dp[one][two];
        int one_move = police(index + 1, index, two) + distance(1, one, index);
        int two_move = police(index + 1, one, index) + distance(2, two, index);
        dp[one][two] = Math.min(one_move, two_move);
        return dp[one][two];
    }

    public static int distance(int sep, int start, int end) {
        int x_start = list[start][0], y_start = list[start][1], x_end = list[end][0], y_end = list[end][1];
        if (start == 0) {
            if (sep == 1) {
                x_start = y_start = 1;
            } else {
                x_start = y_start = line_num;
            }
        }
        return Math.abs(x_start - x_end) + Math.abs(y_start - y_end);
    }
}

