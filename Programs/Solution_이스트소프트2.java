package Programs;

public class Solution_이스트소프트2 {

	public static void main(String[] args) {
		int[] A = {51,71,17,42};
		System.out.println(solution(A));
	}

	private static int solution(int[] A) {
		int answer = -1;
		
		int[] num = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int tmp = A[i];
			while(tmp!=0) {
				num[i] += tmp%10;
				tmp /= 10;
			}
		}
		
		for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i] == num[j]) {
					answer = Math.max(answer, A[i]+A[j]);
				}
			}
		}
		
		return answer;
	}
}
