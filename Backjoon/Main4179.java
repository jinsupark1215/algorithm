package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main4179 {
    static int R,C;
    static int map[][];
    static LinkedList<int[]> queue = new LinkedList<>();
    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        result = 0;

        String tmp;
        int jihun[] = null;
        for(int i=0; i<R; i++) {
            tmp = buf.readLine();
            for(int j=0; j<C; j++) {
                switch(tmp.charAt(j) ) {
                    case '#':
                        map[i][j] = -1;
                        break;
                    case 'J':
                        map[i][j] = 1;
                        jihun = new int[] {i,j,1};
                        break;
                    case 'F':
                        map[i][j] = -2;
                        queue.add(new int[] {i,j,-2});
                        break;
                }
            }
        }
        queue.add(jihun);

        int cur[];
        int nr, nc;
        while(!queue.isEmpty()) {
            cur = queue.poll();

            for(int i=0; i<4; i++) {
                nr = cur[0] + dir[i][0];
                nc = cur[1] + dir[i][1];

                if(cur[2] == -2) { //불인경우
                    if(nr > -1 && nr < R && nc > -1 && nc < C && map[nr][nc] >= 0 ) {
                        map[nr][nc] = -2;
                        queue.add(new int[] {nr,nc,-2});
                    }
                }
                else {
                    if(nr <0 || nr > R-1 || nc < 0 || nc > C-1) {
                        result = cur[2];
                        queue.clear();
                        break;
                    }
                    else if(nr > -1 && nr < R && nc > -1 && nc < C && map[nr][nc] == 0) {
                        map[nr][nc] = cur[2] + 1;
                        queue.add(new int[] {nr,nc,cur[2]+1});
                    }
                }
            }
        }

        if(result == 0)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(result);

    }

}
