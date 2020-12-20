package Backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1021 {

	/*
	 * [백준] 회전하는 큐
	 * 
	 * 1. 정답출력
	 * 
	 * 2.
	 * 
	 * 3.
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		boolean flag;
		int n = scan.nextInt(), m = scan.nextInt(), num, answer = 0;
		
		for(int i = 1; i <= n; i++) list.add(i);
		for(int i = 0; i < m; i++) {
			num = scan.nextInt(); flag = false;
			while(!flag) {
				if(list.get(0) == num) {
					list.remove(0); flag = true;
				}
				else {
					if(list.indexOf(num) <= list.size()/2)
						list.add(list.size()-1, list.remove(0));
					else
						list.add(0, list.remove(list.size()-1));
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
