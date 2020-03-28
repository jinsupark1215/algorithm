package Programs;

public class Solution_이스트소프트3 {

	public static void main(String[] args) {
		int[] A = {3,4,5,3,7};
		System.out.println(solution(A));
	}

	private static int solution(int[] A) {
		int answer = 0;
		
		if(isPossible(A)) {
			answer = 0;
		}else {
			answer = minus(A);
			if(answer == 0) answer =-1;
		}
		return answer;
	}

	private static int minus(int[] A) {
		int cnt = 0;
		
		int[] arr = new int[A.length-1];
		for (int i = 0; i < A.length; i++) {
			int idx = 0;
			for (int j = 0; j < A.length; j++) {
				if(i==j)continue;
				arr[idx] = A[j];
				idx++;
			}
			if(isPossible(arr))cnt++;
		}
		
		return cnt;
	}

	private static boolean isPossible(int[] A) {
		boolean flag;
		
		if(A[1] >A[0]) {
			flag = true;
		}else if(A[1]<A[0]) {
			flag = false;
		}else return false;
		
		for (int i = 1; i < A.length-1; i++) {
			if(flag) {
				if(A[i+1] >=A[i]) {
					return false;
				}else if(A[i+1]<A[i]) {
					flag = false;
				}
			}else {
				if(A[i+1] >A[i]) {
					flag = true;
				}else if(A[i+1]<=A[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
