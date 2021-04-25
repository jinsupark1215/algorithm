package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int size = 0;
        int[] LIS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (LIS[size] == num) continue;
            if (LIS[size] < num) LIS[++size] = num;
            else {
                int left = 1;
                int right = size;
                int mid = 0;
                int idx = 0;
                while (left <= right) {
                    mid = (left + right) >> 1;
                    if (LIS[mid] == num) {
                        idx = mid;
                        break;
                    } else if (LIS[mid] < num) {
                        left = mid + 1;
                    } else {
                        idx = mid;
                        right = mid - 1;
                    }
                }
                LIS[idx] = num;
            }
        }
        System.out.println(size);
    }
}
