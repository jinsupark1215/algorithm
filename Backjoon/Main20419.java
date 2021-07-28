package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main20419 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R;
    static int C;
    static int[][] map;
    static boolean[][][] visited;
    static boolean flag = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new int[R][C];
        visited = new boolean[R][C][4];
        int k1 = 0;
        int k2 = 0;

        if(Integer.parseInt(input[2])==1) {
            k1 = 1;
            k2 = 1;
        }

        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                char c = str.charAt(j);

                if(c=='R')
                    map[i][j] = 1;
                else if(c=='L')
                    map[i][j] = 3;
                else if(c=='U')
                    map[i][j] = 0;
                else
                    map[i][j] = 2;
            }
        }

        dfs(0, 0 , k1, k2);

        if(flag)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void dfs(int x, int y, int k1, int k2) {
        if(x==R-1 && y==C-1) {
            flag = true;
            return ;
        }

        int next = map[x][y];
        int nx = x + dx[next];
        int ny = y + dy[next];

        if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[x][y][next]) {
            visited[x][y][next] = true;
            dfs(nx, ny, k1, k2);
        }

        if(k1==1) {
            int next2 = (next+1)%4;
            nx = x + dx[next2];
            ny = y + dy[next2];

            if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[x][y][next2]) {
                visited[x][y][next2] = true;
                map[x][y] = next2;
                dfs(nx, ny, 0, k2);
                map[x][y] = next;
            }
        }

        if(k2==1) {
            int next2 = (next-1)<0 ? 3 : (next-1);
            nx = x + dx[next2];
            ny = y + dy[next2];

            if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[x][y][next2]) {
                visited[x][y][next2] = true;
                map[x][y] = next2;
                dfs(nx, ny, k1, 0);
                map[x][y] = next;
            }
        }
    }
}
