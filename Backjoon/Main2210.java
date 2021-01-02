package Backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main2210 {

	/*
	 * [백준] 숫자판 점프
	 * 
	 * 1. 만들 수 있는 수의 갯수
	 * 
	 * 2. 5X5
	 * 
	 * 3. dfs 백트래킹
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N;
	static int[][] map;
	static Set<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        
        set = new HashSet<String>();
        map = new int[N][N];
        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                
            }
        }
        String s = new String();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dfs(i,j,0,s);        
            }
        }
        System.out.println(set.size());
	}
	public static void dfs(int r, int c,int depth,String s) {
        if(depth==6){
            set.add(s);
            return;
        }
        for(int i=0; i<4; i++){
            int nr = pos[i][0]+r;
            int nc = pos[i][1]+c;
            
            if(nr<0 ||nc<0||nr>=N||nc>=N){
                continue;
            }
            
            dfs(nr,nc,depth+1,s+map[r][c]);
 
        }
        
    }
}
