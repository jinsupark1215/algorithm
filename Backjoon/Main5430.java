package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main5430 {

	/*
	 * [백준] AC
	 * 
	 * 1. 정수 배열 결과
	 * 
	 * 2.
	 * 
	 * 3. 데크 이용
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		for (int i=0; i<T; i++){
			boolean error = false, 
					cursor = false; 

			String[] fn = br.readLine().split("");
			br.readLine(); 
			String input = br.readLine();
			ArrayList<String> list = new ArrayList<>(Arrays.asList(input.substring(1, input.length()-1).split(","))); 
			
			if (list.get(0).equals("")) 
				list.remove(0);
			
			for (String f : fn){
				switch (f){ 
				case "R":
					cursor = !cursor;
					break; 
					case "D":
						if (list.size()==0) { 
							error = true; 
							break; 
							} else if (cursor)
								list.remove(list.size()-1);
							else list.remove(0);
						} 
				}
			
			if (cursor) Collections.reverse(list);
			sb.append(error ? "error\n" : "["+String.join(",", list)+"]\n");
			} 
		System.out.print(sb);
   }
}
