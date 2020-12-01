package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12094 {

	/*
	 * [백준] 2048(hard)
	 */
	    static int n, answer, map[][];
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        n = Integer.parseInt(br.readLine());
	        answer = 0;
	        map = new int[n][n];
	        StringTokenizer st;
	        for(int i = 0; i < n; i++) {
	            st = new StringTokenizer(br.readLine());
	            for(int j = 0; j < n; j++)
	                map[i][j] = Integer.parseInt(st.nextToken());
	        }
	        
	        game(0);
	        System.out.println(answer);
	    }
	    
	    public static void game(int count) {
	        if(count == 10) {
	            findMax();
	            return;
	        }
	        int copy[][] = new int[n][n];
	        for(int i = 0; i < n; i++)
	            copy[i] = map[i].clone();
	        
	        for(int i = 0; i < 4; i++) {
	            move(i);
	            game(count+1);
	            for(int a = 0; a < n; a++)
	                map[a] = copy[a].clone();
	        }
	    }
	    
	    public static void move(int dir) {
	        switch(dir) {
	            case 0:
	                for(int i = 0; i < n; i++) {
	                    int index = 0;
	                    int block = 0;
	                    for(int j = 0; j < n; j++) {
	                        if(map[j][i] != 0) {
	                            if(block == map[j][i]) {
	                                map[index - 1][i] = block * 2;
	                                block = 0;
	                                map[j][i] = 0;
	                            }
	                            else {
	                                block = map[j][i];
	                                map[j][i] = 0;
	                                map[index][i] = block;
	                                index++;
	                            }
	                        }
	                    }
	                }
	                break;
	            case 1:
	                for(int i = 0; i < n; i++) {
	                    int index = n - 1;
	                    int block = 0;
	                    for(int j = n - 1; j >= 0; j--) {
	                        if(map[j][i] != 0) {
	                            if(block == map[j][i]) {
	                                map[index + 1][i] = block * 2;
	                                block = 0;
	                                map[j][i] = 0;
	                            }
	                            else {
	                                block = map[j][i];
	                                map[j][i] = 0;
	                                map[index][i] = block;
	                                index--;
	                            }
	                        }
	                    }
	                }
	                break;
	            case 2:
	                for(int i = 0; i < n; i++) {
	                    int index = 0;
	                    int block = 0;
	                    for(int j = 0; j < n; j++) {
	                        if(map[i][j] != 0) {
	                            if(block == map[i][j]) {
	                                map[i][index - 1] = block * 2;
	                                block = 0;
	                                map[i][j] = 0;
	                            }
	                            else {
	                                block = map[i][j];
	                                map[i][j] = 0;
	                                map[i][index] = block;
	                                index++;
	                            }
	                        }
	                    }
	                }
	                break;
	            case 3:
	                for(int i = 0; i < n; i++) {
	                    int index = n - 1;
	                    int block = 0;
	                    for(int j = n - 1; j >= 0; j--) {
	                        if(map[i][j] != 0) {
	                            if(block == map[i][j]) {
	                                map[i][index + 1] = block * 2;
	                                block = 0;
	                                map[i][j] = 0;
	                            }
	                            else {
	                                block = map[i][j];
	                                map[i][j] = 0;
	                                map[i][index] = block;
	                                index--;
	                            }
	                        }
	                    }
	                }
	                break;
	        }
	    }
	    
	    public static void findMax() {
	        for(int i = 0; i < n; i++)
	            for(int j = 0; j < n; j++)
	                answer = Math.max(answer, map[i][j]);
	}
}
