package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2866 {

	/*
	 * [백준] 문자열 잘라내기
	 * 
	 * 1. 새로로 만들었을 때 중복되는 최댓값
	 * 
	 * 2. R,C <=1000
	 * 
	 * 3. 중간값이 중복이 되는 수가 있다면 위의 중간 없다면 아래의 중간으로
	 */
	static int R,C;
	static StringBuilder[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new StringBuilder[C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				if(map[j] == null)map[j] = new StringBuilder();
				map[j].append(s.charAt(j));
			}
		}
		
		int up =0, down = R-1, mid = 0;
		boolean flag = true;
		
		while(up <= down) {
			mid = (up + down) / 2;
			
			if(flag = chk(mid)) up = mid+1;
			else down = mid -1;
		}
		if(!flag)mid--;
		
		System.out.println(mid);
	}

	private static boolean chk(int mid) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < C; i++) {
			String s = map[i].substring(mid);
			if(list.contains(s))return false;
			
			list.add(s);
		}
		return true;
	}
}
