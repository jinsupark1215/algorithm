package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_카카오_괄호변환 {

	/*
	 * 1. 올바른 괄호 문자열 만들기?
	 * 
	 * 2. s <= 1000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String p = br.readLine();

		System.out.println(solution(p));
	}

	private static String solution(String p) {
		String answer = "";
		
		if(isRight(p) && isCnt(p))answer = p;
		else answer = go(p);

		return answer;
	}

	private static String go(String p) {
		String u = "";
		String v = "";
		
		for (int i = 2; i <= p.length(); i++) {
			if(isCnt(p.substring(0,i))) {
				if(isRight(p.substring(0, i))) {
					u = p.substring(0, i);					
					v = go(p.substring(i, p.length()));
				}else {
					u = p.substring(0,i);
					v = go(p.substring(i, p.length()));
					String ans = "(";
					ans += v + ")";
					for (int j = 1; j < u.length()-1; j++) {
						if(u.charAt(j) == '(')ans+=')';
						else ans += '(';
					}
					return ans;
				}
				break;
			}
		}
		
		return u + v;
	}

	private static boolean isCnt(String p) {
		int cnt1 = 0;
		int cnt2 = 0;
		
		for (int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(')cnt1++;
			else cnt2++;
		}
		
		if(cnt1 == cnt2)return true;
		
		return false;
	}

	private static boolean isRight(String p) {
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(')s.push(0);
			else {
				if(!s.isEmpty() && s.peek() == 0)s.pop();
				else s.push(1);
			}
		}
		
		if(s.isEmpty())return true;
		
		return false;
	}
}
