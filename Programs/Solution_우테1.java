package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_우테1 {

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
		int[] arr = {2};

		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer =0;
		
		int cnt=0;
		int num = arr[0];
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		while(true) {
			num = list.get(0);
			cnt=0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) == num) {
				cnt++;
			}else {
				num = list.get(i);
				ans.add(cnt);
				cnt=1;
			}
		}
		ans.add(cnt);
		
		answer++;
		if(ans.size()==1 && ans.get(0) ==1)break;
		list = new ArrayList<Integer>();
		for (int i = 0; i < ans.size(); i++) {
			list.add(ans.get(i));
		}
		ans = new ArrayList<Integer>();
		}
		return answer;
	}
}
