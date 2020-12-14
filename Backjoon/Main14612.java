package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main14612 {

	/*
	 * [백준] 김식당
	 * 1. 포스트잇 번호 출력
	 * 
	 * 2. 
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			if(input[0].equals("order")) {
				int[] arr = new int[2];
				arr[0] = Integer.parseInt(input[1]);
				arr[1] = Integer.parseInt(input[2]);
				list.add(arr);
			}else if(input[0].equals("complete")) {
				int num = Integer.parseInt(input[1]);
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j)[0] == num) {
						list.remove(j);
						break;
					}
				}
			}else {
				Collections.sort(list, new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[1] - o2[1];
					}
				});
			}
			if(list.size() ==0) {
				System.out.println("sleep");
			}else {
				for (int j = 0; j < list.size(); j++) {
					System.out.print(list.get(j)[0] + " ");
				}
				System.out.println();
			}
		}
	}
}
