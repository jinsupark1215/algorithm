package Programs;

public class Solution_11번3 {
	public static void main(String[] args) {
		int[] A = {6,2,3,5,6,3};
		System.out.println(solution(A));
	}

	private static int solution(int[] A) {
		int ans = 0;
		
		int N = A.length;
		boolean[] cnt = new boolean[N+1];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			if(!cnt[A[i]]) {
				cnt[A[i]] = true;
			}else {
				sum += A[i];
			}
		}
		
		int minus = 0;
		for (int i = 1; i < N+1; i++) {
			if(!cnt[i])minus += i;
		}
		
		ans = Math.abs(sum - minus);
		
		if(ans > 1000000000)ans = -1;
		
		return ans;
	}

}
