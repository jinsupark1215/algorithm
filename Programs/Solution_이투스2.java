package Programs;

import java.util.Stack;

public class Solution_이투스2 {

	public static void main(String[] args) {
		String[] ledgers = {"01/01 4 50000", "01/11 6 3555", "02/01 0 -23555", "02/25 5 5000", "03/25 0 -15000", "06/09 8 43951", "12/30 9 99999"};
		System.out.println(solution(ledgers));
	}

	public static int solution(String[] ledgers) {
		int answer = 0;
		int[] months = {0,31,59,90,120,151,181,212,243,273,304,334};
		
		Stack<Ledger> stack = new Stack<>();
		for (int i = 0; i < ledgers.length; i++) {
			String[] input = ledgers[i].split(" ");
			int m = months[Integer.parseInt(input[0].substring(0, 2))-1];
			int d = Integer.parseInt(input[0].substring(3, 5));
			int R = Integer.parseInt(input[1]);
			int money = Integer.parseInt(input[2]);
			
			if(money >=0) {
				stack.add(new Ledger(m+d,R,money));
			}else {
				while(money !=0) {
					Ledger ledger = stack.pop();
					
					if(ledger.money >= Math.abs(money)) {
						answer += Math.abs(money) * ledger.plus/100 * ((m+d)-ledger.day) / 365;
						if(ledger.money !=Math.abs(money)) {
							stack.add(new Ledger(ledger.day, ledger.plus, ledger.money + money));
						}
						money = 0;
					}else {
						money = money + ledger.money;
						answer += ledger.money * ledger.plus/100 * ((m+d)-ledger.day) / 365;
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			Ledger ledger = stack.pop();
			answer += ledger.money * ledger.plus/100 * (365 -ledger.day) / 365;
		}
		
		return answer;
	}
	static class Ledger{
		int day, plus,money;

		public Ledger(int day, int plus, int money) {
			super();
			this.day = day;
			this.plus = plus;
			this.money = money;
		}
	}
}
