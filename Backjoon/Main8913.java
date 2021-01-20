package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8913 {
	/*
	 * [백준] 문자열 뽑기
	 * 
	 * 1. 빈문자열 바꿀수있나없나
	 * 
	 * 2. 25이하
	 * 
	 * 3. dfs
	 */
	 public static int ans;
	   public static void main(String[] args) throws NumberFormatException, IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int T = Integer.parseInt(br.readLine());
	      StringBuilder sb = new StringBuilder();
	      char board[];
	      for(int i = 0; i<T; i++) {
	         board = br.readLine().toCharArray();
	         ans = 0;
	         dfs(board, board.length, 0);
	         sb.append(ans).append("\n");
	      }
	      System.out.println(sb.toString());
	   }
	   
	   

	   private static void dfs(char[] str, int length, int curIdx) {
	      if(str.length == 0 && curIdx >= length) ans = 1;
	      if(ans == 1) return;
	      if(curIdx >= length) return;
	      
	      char c = str[curIdx];
	      int cnt = 0;
	      
	      
	      while(true) {
	         cnt++;
	         if(curIdx + cnt < length && c == str[curIdx + cnt]) continue;
	         else break;
	      }
	      
	      
	      if(cnt >= 2) {
	         char board2[] = new char[str.length - cnt];
	         
	         for(int i = 0; i<curIdx; i++) {
	            board2[i] = str[i];
	         }
	         for(int i = curIdx; i < board2.length; i++) {
	            board2[i] = str[i + cnt];
	         }
	         dfs(board2, board2.length, 0);

	         dfs(str, length, curIdx + cnt);
	      }
	      else {
	         dfs(str, length, curIdx + 1);
	      }
	   }
}
