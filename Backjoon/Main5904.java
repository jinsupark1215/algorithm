package Backjoon;

import java.util.Scanner;

public class Main5904 {
    /*
    [백준] Moo 게임

    1. N번째 문자

    2.

    3. dp
     */
    static Scanner sc = new Scanner(System.in);
    static int[] dp = new int[30];

    public static void main(String[] args) {
        int N = sc.nextInt();

        dp[0] = 3;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (dp[i-1]*2) + (i + 3);
        }

        System.out.println(func(N));
    }

    static char func(int n) {
        if (n == 1) return 'm';
        if (n == 2 || n == 3) return 'o';

        int i = 0;
        while (dp[i] < n) i++;
        if (dp[i] == n) return 'o'; // 끝
        if (n - dp[i - 1] == 1) return 'm'; // 다음 칸
        if (n - dp[i - 1] <= i + 3) return 'o'; //  moo.... 에서 o 해당하는 칸

        return func((n - dp[i - 1] - (i + 3)));
    }
}
