package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_까까오1 {

	/*
	 * 1. 왼손과 오른손 중 어떤걸 누를지
	 * 
	 * 2. numbers <= 1000
	 * 
	 * 3. left, right 기억하고 차이, 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";

		System.out.println(solution(numbers, hand));
	}

	private static String solution(int[] numbers, String hand) {

		int left = 10;
		int right = 11;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]== 1 || numbers[i] == 4 || numbers[i] == 7) {
				sb.append("L");
				left = numbers[i];
			}else if(numbers[i] == 3 || numbers[i] == 6 ||numbers[i] == 9 ) {
				sb.append("R");
				right = numbers[i];
			}else {
				int leftcnt = 0;
				int rightcnt = 0;
				if(left == 1) {
					if(numbers[i] == 2)leftcnt = 1;
					else if(numbers[i] == 5)leftcnt = 2;
					else if(numbers[i] == 8)leftcnt = 3;
					else if(numbers[i] == 0)leftcnt = 4;
				}else if(left == 4) {
					if(numbers[i] == 2)leftcnt = 2;
					else if(numbers[i] == 5)leftcnt = 1;
					else if(numbers[i] == 8)leftcnt = 2;
					else if(numbers[i] == 0)leftcnt = 3;
				}else if(left == 7) {
					if(numbers[i] == 2)leftcnt = 3;
					else if(numbers[i] == 5)leftcnt = 2;
					else if(numbers[i] == 8)leftcnt = 1;
					else if(numbers[i] == 0)leftcnt = 2;
				}else if(left == 10) {
					if(numbers[i] == 2)leftcnt = 4;
					else if(numbers[i] == 5)leftcnt = 3;
					else if(numbers[i] == 8)leftcnt = 2;
					else if(numbers[i] == 0)leftcnt = 1;
				}else if(left == 2) {
					if(numbers[i] == 2)leftcnt = 0;
					else if(numbers[i] == 5)leftcnt = 1;
					else if(numbers[i] == 8)leftcnt = 2;
					else if(numbers[i] == 0)leftcnt = 3;
				}else if(left == 5) {
					if(numbers[i] == 2)leftcnt = 1;
					else if(numbers[i] == 5)leftcnt = 0;
					else if(numbers[i] == 8)leftcnt = 1;
					else if(numbers[i] == 0)leftcnt = 2;
				}else if(left == 8) {
					if(numbers[i] == 2)leftcnt = 2;
					else if(numbers[i] == 5)leftcnt = 1;
					else if(numbers[i] == 8)leftcnt = 0;
					else if(numbers[i] == 0)leftcnt = 1;
				}else if(left == 0) {
					if(numbers[i] == 2)leftcnt = 3;
					else if(numbers[i] == 5)leftcnt = 2;
					else if(numbers[i] == 8)leftcnt = 1;
					else if(numbers[i] == 0)leftcnt = 0;
				}
				
				if(right == 3) {
					if(numbers[i] == 2)rightcnt = 1;
					else if(numbers[i] == 5)rightcnt = 2;
					else if(numbers[i] == 8)rightcnt = 3;
					else if(numbers[i] == 0)rightcnt = 4;
				}else if(right == 6) {
					if(numbers[i] == 2)rightcnt = 2;
					else if(numbers[i] == 5)rightcnt = 1;
					else if(numbers[i] == 8)rightcnt = 2;
					else if(numbers[i] == 0)rightcnt = 3;
				}else if(right == 9) {
					if(numbers[i] == 2)rightcnt = 3;
					else if(numbers[i] == 5)rightcnt = 2;
					else if(numbers[i] == 8)rightcnt = 1;
					else if(numbers[i] == 0)rightcnt = 2;
				}else if(right == 11) {
					if(numbers[i] == 2)rightcnt = 4;
					else if(numbers[i] == 5)rightcnt = 3;
					else if(numbers[i] == 8)rightcnt = 2;
					else if(numbers[i] == 0)rightcnt = 1;
				}else if(right == 2) {
					if(numbers[i] == 2)rightcnt = 0;
					else if(numbers[i] == 5)rightcnt = 1;
					else if(numbers[i] == 8)rightcnt = 2;
					else if(numbers[i] == 0)rightcnt = 3;
				}else if(right == 5) {
					if(numbers[i] == 2)rightcnt = 1;
					else if(numbers[i] == 5)rightcnt = 0;
					else if(numbers[i] == 8)rightcnt = 1;
					else if(numbers[i] == 0)rightcnt = 2;
				}else if(right == 8) {
					if(numbers[i] == 2)rightcnt = 2;
					else if(numbers[i] == 5)rightcnt = 1;
					else if(numbers[i] == 8)rightcnt = 0;
					else if(numbers[i] == 0)rightcnt = 1;
				}else if(right == 0) {
					if(numbers[i] == 2)rightcnt = 3;
					else if(numbers[i] == 5)rightcnt = 2;
					else if(numbers[i] == 8)rightcnt = 1;
					else if(numbers[i] == 0)rightcnt = 0;
				}
				
				if(leftcnt > rightcnt) {
					sb.append("R");
					right = numbers[i];
				}else if(leftcnt < rightcnt) {
					sb.append("L");
					left = numbers[i];
				}else if(leftcnt == rightcnt) {
					if(hand.equals("right")) {
						sb.append("R");
						right = numbers[i];
					}else {
						left = numbers[i];
						sb.append("L");
					}
				}
			}
		}

		return sb.toString();
	}
}
