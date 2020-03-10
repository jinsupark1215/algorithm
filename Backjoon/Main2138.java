package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2138 {

	/*
	 * 1. 전구가 모두 꺼진 상태로 만드는데 필요한 최소횟수
	 * 
	 * 2. i번쨰 스위치를 누르면 i-1,i+1은 상태 바뀜
	 * 
	 * 3. 완전탐색 (dfs)로 눌렀을 경우 안눌렀을 경우
	 */
	
	static int size, count = 0;
	static boolean[] origin, target, copy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		origin = new boolean[size + 2];
		target = new boolean[size + 2];

		char[] input = br.readLine().toCharArray();
		for (int i = 1; i <= size; i++) {
			if (input[i - 1] == '1') {
				origin[i] = true;
			}
		}
		input = br.readLine().toCharArray();
		for (int i = 1; i <= size; i++) {
			if (input[i - 1] == '1') {
				target[i] = true;
			}
		}

		simulation();

	}

	private static void simulation() {
		count = 0;
		if (isPossible()) { // 원본 그대로일때
			System.out.println(count);
			return;
		}
		change(1, false);
		count = 1;
		if (isPossible()) { // 1번 스위치만 누름
			System.out.println(count);
			return;
		}
		System.out.println(-1);
	}

	private static boolean isPossible() {
		copy = origin.clone();

		for (int i = 2; i < size; i++) {
			if (copy[i - 1] != target[i - 1]) {
				count++;
				change(i, true);
			}
		}
		if (copy[size - 1] != target[size - 1]) { // N번째 스위치 눌러야되나?
			copy[size - 1] = target[size - 1];
			if (copy[size]) {
				copy[size] = false;
			} else {
				copy[size] = true;
			}
			count++;
		}

		for (int i = 1; i <= size; i++) {
			if (copy[i] != target[i]) {
				return false;
			}
		}
		return true;
	}

	private static void change(int index, boolean flag) {
		if (flag) {
			for (int i = 0; i < 3; i++) {
				if (copy[index - 1 + i]) {
					copy[index - 1 + i] = false;
				} else {
					copy[index - 1 + i] = true;
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				if (origin[index - 1 + i]) {
					origin[index - 1 + i] = false;
				} else {
					origin[index - 1 + i] = true;
				}
			}
		}
	}

	private static void print() {
		for (int i = 1; i <= size; i++) {
			System.out.print(copy[i] ? '1' : '0');
		}
		System.out.println();
	}
}

