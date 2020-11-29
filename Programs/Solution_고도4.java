package Programs;

public class Solution_고도4 {

	public static void main(String[] args) {
		String cardNumber = "21378";
		System.out.println(solution(cardNumber));
	}

	private static String solution(String cardNumber) {
		
		int len = cardNumber.length();
		int[] num = new int[len];
		
		for (int i = 0; i < len; i++) {
			num[i] = cardNumber.charAt(i) -'0';
		}
		
		if(len %2 ==0) {
			//길이가 짝수인 경우
			for (int i = 0; i < len; i+=2) {
				num[i] *=2;
			}
		}else {
			//길이가 홀수인 경우
			for (int i = 1; i < len; i+=2) {
				num[i] *=2;
			}
		}
		//수의 합
		int sum = 0;
		for (int i = 0; i < len; i++) {
			while(num[i] !=0) {
				sum+= num[i]%10;
				num[i] /=10;
			}
		}
		
		if(sum %10 ==0) {
			//10의 배수이면 유효
			return "VALID";
		}
		//아니라면
		return "INVALID";
	}
}
