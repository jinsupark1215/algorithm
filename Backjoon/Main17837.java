package Backjoon;

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main17837 {
    static int N, K;
    static int[][] map;
    static ArrayList<Integer>[][] horsemap;
    static horse[] horses;
    static class horse{
        int y, x, dir;
        horse(int y, int x, int dir){
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
    static int[][] delta = {
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
    };
    
    static int[] change = {1,0,3,2}; // 방향 전환 배열, ex 0이 들어오면 1로 방향이 바뀐다. 
    static boolean isRange(int y, int x) {
        return y >= 0 && y<N && x >=0 && x <N;
    }
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];             // 보드 색상 
        horsemap = new ArrayList[N][N]; // 보드 위에 쌓인 말들의 번호  
        horses = new horse[K+1];             // 1번 ~ K번 말타입 배열 
        
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                horsemap[i][j] = new ArrayList<Integer>();
            }
        }
        
        int iy, ix, idir;
        for(int i = 1 ; i <= K ; i++) {
            st = new StringTokenizer(br.readLine());
            iy = Integer.parseInt(st.nextToken())-1;
            ix = Integer.parseInt(st.nextToken())-1;
            idir = Integer.parseInt(st.nextToken())-1;
            horses[i] = new horse(iy, ix, idir);
            horsemap[iy][ix].add(i);
        }
        int turn = 1, ny, nx, dir, rm;
        horse cur;
        ArrayList<Integer> templist = new ArrayList<Integer>();
        
        for(; turn <= 1000 ;turn++) {
            for(int h = 1 ; h <= K ; h++) {
                cur = horses[h];
                dir = cur.dir;
                ny = cur.y + delta[dir][0];
                nx = cur.x + delta[dir][1];
                
                if( !isRange(ny, nx) || map[ny][nx] == 2) { // 다음이 보드 밖 또는 파란 칸 
                    // 범위 바꾸고 다음칸 새로 설정
                    dir = change[dir];
                    horses[h].dir = dir;
                    ny = horses[h].y + delta[dir][0];
                    nx = horses[h].x + delta[dir][1];
                    
                }
                
                if(isRange(ny, nx) && map[ny][nx] != 2) { // 다음이 보드 안이고 파란 칸 아닐때 
                    if(map[ny][nx] == 0) { // 다음이 흰색 
                        // top부터 h까지 제거하고 templist에 추가 
                        rm = horsemap[cur.y][cur.x].remove(horsemap[cur.y][cur.x].size()-1);
                        while(rm != h) {
                            templist.add( rm );
                            rm =   horsemap[cur.y][cur.x].remove(horsemap[cur.y][cur.x].size()-1);
                        }
                        templist.add(rm);
                        
                        while(!templist.isEmpty()) {
                            rm= templist.remove(templist.size()-1);
                            // 말 위치 변경 
                            horses[rm].y = ny;
                            horses[rm].x = nx;
                            // 지도에 말 쌓기 
                            horsemap[ny][nx].add(rm);
                        }
                    }else { // 다음이 빨강
                        
                        rm = horsemap[cur.y][cur.x].remove(horsemap[cur.y][cur.x].size()-1);
                        while(rm != h) {
                            horses[rm].y = ny;
                            horses[rm].x = nx;
                            horsemap[ny][nx].add( rm );
                            rm =   horsemap[cur.y][cur.x].remove(horsemap[cur.y][cur.x].size()-1);
                        }
                        horses[rm].y = ny;
                        horses[rm].x = nx;
                        horsemap[ny][nx].add(rm);
                    }
                    
                    // 말이 이동하게 되면 (ny, nx)만 길이가 변하므로 (ny, nx)만 검사 후 바로 종료 
                    if(horsemap[ny][nx].size() >= 4) {
                        System.out.println(turn);
                        return;
                    }
                }
            }
        }
        
        // 1000 넘김 
        System.out.println(-1);
    }
}