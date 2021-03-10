package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14620 {
    static int N, ans = 987654321;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(1, 0, 0);

        System.out.println(ans);
    }

    public static void combi(int i_start, int count, int sum) {
        if(count == 3) {
            ans = Math.min(ans, sum);
            return;
        }

        if(ans < sum)
            return;

        for (int i = i_start; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(isPossible(i, j)) {
                    int temp = 0;
                    for (int k = 0; k < 5; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        check[nx][ny] = true;
                        temp += map[nx][ny];
                    }
                    combi(i, count+1, sum+temp);
                    for (int k = 0; k < 5; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        check[nx][ny] = false;
                    }
                }
            }
        }
    }

    public static boolean isPossible(int i, int j) {
        for (int k = 0; k < 5; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(check[nx][ny]) {
                return false;
            }
        }
        return true;
    }
}
