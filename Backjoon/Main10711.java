package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main10711 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '.') {
                    q.add(new Point(i, j));
                } else {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
        }

        int round = 0;
        while (!q.isEmpty()) {

            int check = 0;
            int size = q.size();
            while (size != 0) {
                Point point = q.poll();
                size--;
                for (int i = 0; i < 8; i++) {
                    int px = point.x + dx[i];
                    int py = point.y + dy[i];
                    if (px >= 0 && px < N - 1 && py >= 0 && py < M - 1 && map[px][py] != 9) {
                        map[px][py]--;
                        if (map[px][py] == 0) {
                            check++;
                            q.add(new Point(px, py));
                        }
                    }
                }

            }
            if (check != 0) {
                round++;
            }

        }
        System.out.println(round);
    }

}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
