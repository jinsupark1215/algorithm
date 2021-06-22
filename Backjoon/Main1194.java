package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1194 {

    private static int pX[] = {-1, 0, 1, 0};
    private static int pY[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());


        char arr[][] = new char[N][M];
        int visit[][][] = new int[N][M][1 << 6];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int start[] = {startX, startY, 0, 0};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(start);

        int Ans = -1;
        for_while:
        while (!queue.isEmpty()) {

            int target[] = queue.poll();
            int targetX = target[0];
            int targetY = target[1];


            for (int i = 0; i < pX.length; i++) {
                int moveX = targetX + pX[i];
                int moveY = targetY + pY[i];
                int key = target[2];

                if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) continue;
                if (arr[moveX][moveY] == '#') continue;

                if (arr[moveX][moveY] == '1') {
                    Ans = target[3] + 1;
                    break for_while;
                }
                if ('a' <= arr[moveX][moveY] && arr[moveX][moveY] <= 'f') {
                    key |= (1 << 'f' - arr[moveX][moveY]);
                }

                if ('A' <= arr[moveX][moveY] && arr[moveX][moveY] <= 'F') {
                    if ((key & (1 << 'F' - arr[moveX][moveY])) == 0) continue;
                }

                if (visit[moveX][moveY][key] == 1) continue;
                visit[moveX][moveY][key] = 1;
                int temp[] = {moveX, moveY, key, target[3] + 1};
                queue.add(temp);
            }
        }
        System.out.println(Ans);
    }
}
