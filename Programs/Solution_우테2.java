package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution_우테2 {

	/*
	 * 1. 왼손과 오른손 중 어떤걸 누를지
	 * 
	 * 2. numbers <= 1000
	 * 
	 * 3. left, right 기억하고 차이, 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int[] arr = {1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3};
//		int[] arr = {1, 2,3};
		int[] arr = {112, 1814, 121, 1481, 1184};

		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer =0;
		
		
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> num = new ArrayList<Integer>();
			boolean flag = true;
			while(arr[i] !=0) {
				num.add(arr[i]%10);
				arr[i] /=10;
			}
			Collections.sort(num);
			String tmp = "";
					for (int j = 0; j < num.size(); j++) {
						tmp += num.get(j);
					}
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).equals(tmp)) {
					flag = false;
					break;
				}
			}
			if(flag)list.add(tmp);
			
		}
		answer =list.size();
		return answer;
	}
}
