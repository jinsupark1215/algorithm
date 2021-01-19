package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6087 {

	/*
	 * [백준] 레이저 통신
	 * 
	 * 1. 설치해야되는 거울 최소갯수
	 * 
	 * 2.
	 * 
	 * 3. bfs
	 */
	static char[][] map;
    static int[][] visited;
    static ArrayList<Point> laser;
    static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
    static int W;
    static int H;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new int[H][W];
        laser = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                visited[i][j] = Integer.MAX_VALUE;

                char val = input[j].charAt(0);
                map[i][j] = val;

                if (val == 'C') {
                    laser.add(new Point(i, j, -1, 0));
                }
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();

        Point c1 = laser.get(0);
        Point c2 = laser.get(1); 

        q.add(c1);
        visited[c1.x][c1.y] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            int x = p.x;
            int y = p.y;
            int dir = p.dir;
            int count = p.count;

            if (x == c2.x && y == c2.y) {
                answer = Math.min(count, answer);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];
                int nd = i;

                if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*') {
                    continue;
                }


                int temp = count;
                if (dir != nd && dir != -1) {
                    temp++;
                }

                if (visited[nx][ny] < temp) {
                    continue;
                }

                visited[nx][ny] = temp;
                q.add(new Point(nx, ny, nd, temp));
            }
        }
        System.out.println(answer);
    }

    static class Point {
        int x;
        int y;
        int dir;
        int count;

        public Point(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }
}
