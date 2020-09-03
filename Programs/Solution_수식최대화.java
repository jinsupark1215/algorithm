package Programs;

import java.util.ArrayList;

public class Solution_수식최대화 {

	public static void main(String[] args) {
		String expression = "50*6-3*2";
		
		System.out.println(solution(expression));
	}

	static int[] order;
	static boolean[] v;
	static ArrayList<Long> num;
	static long max;
	
	private static long solution(String expression) {
		long ans = 0;
		
		int cnt = 3;
		max = 0;
		StringBuilder sb = new StringBuilder();
		num = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) -'0'>=0 && expression.charAt(i) -'0' <=9) {
				sb.append(expression.charAt(i));
			}else {
				num.add(Long.parseLong(sb.toString()));
				if(expression.charAt(i) =='-')num.add((long) -1);
				else if(expression.charAt(i) =='+')num.add((long) -2);
				else if(expression.charAt(i) =='*')num.add((long) -3);
				sb = new StringBuilder();
			}
			
			if(i == expression.length()-1)num.add(Long.parseLong(sb.toString()));
		}
		order = new int[cnt];
		v = new boolean[cnt];
		
		dfs(0,cnt);
		ans = max;
		return ans;
	}

	private static void dfs(int idx, int cnt) {
		if(idx == cnt) {
			solve();
			return;
		}
		
		for (int i = 0; i < cnt; i++) {
			if(!v[i]) {
				v[i] = true;
				order[idx] = i;
				dfs(idx+1,cnt);
				v[i] = false;
			}
		}
	}

	private static void solve() {
		ArrayList<Long> tmp = new ArrayList<>();
		for (int i = 0; i < num.size(); i++) {
			tmp.add(num.get(i));
		}
		for (int i = 0; i < 3; i++) {
			if(order[i] == 0) {
				for (int j = 0; j < tmp.size(); j++) {
					if(tmp.get(j) == -1) {
						long num1 = tmp.get(j-1);
						long num2 = tmp.get(j+1);
						tmp.remove(j-1);
						tmp.remove(j-1);
						tmp.remove(j-1);
						tmp.add(j-1, num1-num2);
						j =j-2;
					}
				}
			}else if(order[i] == 1) {
				for (int j = 0; j < tmp.size(); j++) {
					if(tmp.get(j) == -2) {
						long num1 = tmp.get(j-1);
						long num2 = tmp.get(j+1);
						tmp.remove(j-1);tmp.remove(j-1);tmp.remove(j-1);
						tmp.add(j-1, num1+num2);
						j =j-2;
					}
				}
			}else if(order[i] == 2) {
				for (int j = 0; j < tmp.size(); j++) {
					if(tmp.get(j) == -3) {
						long num1 = tmp.get(j-1);
						long num2 = tmp.get(j+1);
						tmp.remove(j-1);tmp.remove(j-1);tmp.remove(j-1);
						tmp.add(j-1, num1*num2);
						j =j-2;
					}
				}
			}
		}
		max = Math.max(max, Math.abs(tmp.get(0)));
	}
}
