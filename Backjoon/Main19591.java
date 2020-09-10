package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main19591 {

	/*
	 * [백준] 독특한 계산기
	 * 
	 * 1. 주어진 식을 계산한 결과값
	 * 
	 * 2. 10^6 이하의 수식, 숫자는 long 타입
	 * 
	 * 3. 3-1. 숫자와 연산자로 리스트로 나눈다(맨 앞자리 음수인 경우 아닌경우)
	 * 
	 * 3-2. 계산
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		ArrayList<Long> number = new ArrayList<>();
		ArrayList<Character> operater = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i)-'0' >=0 && input.charAt(i)-'0' <=9) {
				sb.append(input.charAt(i));
			}else {
				if(i==0 && input.charAt(0) =='-') {
					sb.append('-');
					continue;
				}
				number.add(Long.parseLong(sb.toString()));
				operater.add(input.charAt(i));
				sb = new StringBuilder();
			}
			
			if(i == input.length()-1){
				number.add(Long.parseLong(sb.toString()));
			}
			
		}
		long[] num = new long[number.size()];
		char[] oper = new char[operater.size()];
		for (int i = 0; i < num.length; i++) {
			num[i] = number.get(i);
		}
		for (int i = 0; i < oper.length; i++) {
			oper[i] = operater.get(i);
		}
		
		int start = 0, end = num.length-1;
		
		while(start != end) {
			int first = prior(oper[start]);
			int last = prior(oper[end-1]);
			
			if(first < last) {
				long tmp = num[end-1];
				if(oper[end-1] =='*')tmp *= num[end];
				else if(oper[end-1] =='/')tmp /= num[end];
				
				end--;
				num[end] = tmp;
				
			}else if(first > last) {
				long tmp = num[start];
				if(oper[start] =='*')tmp *= num[start+1];
				else if(oper[start] =='/')tmp /= num[start+1];
				
				start++;
				num[start] = tmp;
				
			}else {
				long tmp1 = num[start];
				long tmp2 = num[end-1];
				
				if(first == 1) {
					if(oper[start] =='+')tmp1 += num[start+1];
					else if(oper[start] =='-')tmp1 -= num[start+1];
					
					if(oper[end-1] =='+')tmp2 += num[end];
					else if(oper[end-1] =='-')tmp2 -= num[end];
					
					if(tmp1 < tmp2) {
						end--;
						num[end] = tmp2;
					}else {
						start++;
						num[start] = tmp1;
					}
				}else {
					if(oper[start] =='*')tmp1 *= num[start+1];
					else if(oper[start] =='/')tmp1 /= num[start+1];
					
					if(oper[end-1] =='*')tmp2 *= num[end];
					else if(oper[end-1] =='/')tmp2 /= num[end];
					
					if(tmp1 < tmp2) {
						end--;
						num[end] = tmp2;
					}else {
						start++;
						num[start] = tmp1;
					}
				}
			}
		}
		
		
		
		System.out.println(num[start]);
	}

	private static int prior(char a) {
		if(a == '+' || a == '-')return 1;
		return 2;
	}
}
