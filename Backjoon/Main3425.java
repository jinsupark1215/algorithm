package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3425 {

	/*
	 * 1. 결과값 출력
	 * 
	 * 2. -1000000000<=n <=1,000,000,000, 0으로 나눌 때, 숫자가 부족할 때 에러
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		fin:
		while(true) {
			String input = br.readLine();
			if(input.equals(""))sb = new StringBuilder();
			if(input.equals("QUIT"))break;
			
				while(true) {
					if(!input.equals(" "))
					sb.append(input + " ");
					if(input.equals("END"))break;
					input = br.readLine();
					if(input.equals("QUIT"))break fin;
				}
			
			
			int n = Integer.parseInt(br.readLine());
			String err = null;
			Stack<Long> stack = null;
			
			for (int i = 0; i < n; i++) {
				stack = new Stack<>();
				StringTokenizer st = new StringTokenizer(sb.toString());
				err = "";
				
				stack.add(Long.parseLong(br.readLine()));
				while(st.hasMoreTokens()) {
					if(stack.size() > 1000)break;
					String order = st.nextToken();
					
					if(order.equals("NUM")){
						long a = Integer.parseInt(st.nextToken());
						if(a>1000000000 || a <0) {
							err = "ERROR";
							break;
						}
						else stack.add(a);
					}else if(order.equals("POP")){
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else stack.pop();
					}else if(order.equals("INV")){
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else {
						long a = stack.peek();
						stack.pop();
						a -= 2*a;
						stack.add(a);
						}
					}else if(order.equals("DUP")) {
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else stack.add(stack.peek());
					}else if(order.equals("SWP")) {
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else {
							long a = stack.peek();
							stack.pop();
							if(stack.isEmpty()) {
								err = "ERROR";
								break;
							}
							long b = stack.peek();
							stack.pop();
							stack.add(a);
							stack.add(b);
						}
					}else if(order.equals("ADD")) {
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else {
							long a = stack.peek();
							stack.pop();
							if(stack.isEmpty()) {
								err = "ERROR";
								break;
							}
							long b = stack.peek();
							stack.pop();
							long sum =a+b;
							if(Math.abs(sum) > 1000000000){
								err = "ERROR";
								break;
							}
							stack.add(sum);
						}
					}else if(order.equals("SUB")) {
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else {
							long a = stack.peek();
							stack.pop();
							if(stack.isEmpty()) {
								err = "ERROR";
								break;
							}
							long b = stack.peek();
							stack.pop();
							long sub = b-a;
							if(Math.abs(sub) > 1000000000){
								err = "ERROR";
								break;
							}
							stack.add(sub);
						}
					}else if(order.equals("MUL")) {
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else {
							long a = stack.peek();
							stack.pop();
							if(stack.isEmpty()) {
								err = "ERROR";
								break;
							}
							long b = stack.peek();
							stack.pop();
							long mul =a*b;
							if(Math.abs(mul) > 1000000000){
								err = "ERROR";
								break;
							}
							stack.add(mul);
						}
					}else if(order.equals("DIV")) {
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else {
							long a = stack.peek();
							stack.pop();
							if(a==0 || stack.isEmpty()) {
								err = "ERROR";
								break;
							}
							long b = stack.peek();
							stack.pop();
							long div = 0;
							if(a*b <0) {
								div = Math.abs(b)/Math.abs(a);
								div -= 2*div;
							}
							else div = b/a;
							stack.add(div);
						}
					}else if(order.equals("MOD")) {
						if(stack.isEmpty()) {
							err = "ERROR";
							break;
						}else {
							long a = stack.peek();
							stack.pop();
							if(a==0 || stack.isEmpty()) {
								err = "ERROR";
								break;
							}
							long b = stack.peek();
							stack.pop();
							long mod = b%a;
							if(b <0) {
								mod = Math.abs(b)%Math.abs(a);
								mod -= 2*mod;
							}
							else mod = b%a;
							stack.add(mod);
						}
					}
				}
				if(err.equals("ERROR") || stack.size() !=1)System.out.println("ERROR");
				else System.out.println(stack.peek());
			}
			System.out.println();
		}
	}
}

