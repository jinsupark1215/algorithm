package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1541 {

	/*
	 * [백준] 잃어버린 괄호
	 * 1. 최소로 만들 수 있는 숫자
	 * 
	 * 2. 최대 50자
	 * 
	 * 3. +먼저 연산 후 - 연산
	 */
	 static int min = 0;

	    public static void main(String[] args) throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = br.readLine();

	        // 맨 처음 나오는 - 앞에 있는 것들 더하기
	        String[] str = input.split("-");
	        min += sum(str[0].split("[+]"));

	        // 그 뒤로 나오는 -까지 덩어리들의 합
	        for (int i = 1; i < str.length; i++) {
	            min -= sum(str[i].split("[+]"));
	        }

	        System.out.println(min);
	    }

	    static int sum(String[] input) {
	        int result = 0;
	        for (String num : input) {
	            result += Integer.parseInt(num);
	        }
	        return result;
	    }
}
