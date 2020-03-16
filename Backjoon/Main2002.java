package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2002 {

	/*
	 * 1. 추월한 차량이 몇대있는지?
	 * 
	 * 2. N <=1000
	 * 
	 * 3. 구현 
	 * 3-1 들어가는 리스트와 나오는 리스트
	 * 3-2 나오는 리스트가 들어간 순서와 맞는지 판단 후 다르면 ans 증가 후 빼주기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		ArrayList<String> start = new ArrayList<>();
		ArrayList<String> end = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			start.add(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			end.add(br.readLine());
		}
		
		int startidx = 0;
		for (int i = 0; i < N; i++) {
			if(end.get(i).equals(start.get(startidx))) {
				startidx++;
			}else {
				ans++;
				for (int j = startidx+1; j < N; j++) {
					if(end.get(i).equals(start.get(j))) {
						start.remove(j);
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
