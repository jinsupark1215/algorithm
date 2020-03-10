package Backjoon;

import java.util.Scanner;

public class Main3085 {

	/*
	 * 1. 사탕의 최대 갯수
	 * 
	 * 2. N <= 50
	 * 
	 * 3. 구현. 직접 바꾸기
	 */
	static int n, ans;
	static char map[][];
	
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        map = new char[n][n];
        
        for(int i=0;i<n;i++){
            map[i] = sc.next().toCharArray();
        }
        
        ans = 0;
        
        //내려가면서 오른쪽과 바꾸기
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                char tmp = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = tmp;
                
                solve();
                
                tmp = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = tmp;
            }
        }
        
        //옆으로가면서 아래랑 바꾸기
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                char tmp = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = tmp;
                
                solve();
                
                tmp = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = tmp;
            }
        }
        
        System.out.println(ans);
    }
	
	public static void solve() {
		
		for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=0; j<n-1; j++){
                if(map[i][j] == map[i][j+1])
                    cnt++;
                else cnt=1;
                if(ans < cnt)
                    ans = cnt;
            }
        }
        
        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=0; j<n-1; j++){
                if(map[j][i] == map[j+1][i])
                    cnt++;
                else cnt=1;
                if(ans < cnt)
                    ans = cnt;
            }
        }
	}

}

