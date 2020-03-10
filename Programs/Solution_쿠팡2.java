package Programs;

public class Solution_쿠팡2 {

	static int[] arr = new int[6];
	static int answer;

	public static void main(String[] args) {
		int N = 4;
		int M = 7;
		int T = 2;
		int K = 3;
		System.out.println(solution(N, M, T, K));
	}

	static int solution(int n, int m, int t, int k) {
		dfs(0, 0, n, m, t, k);
		return answer;
	}
	static void dfs(int idx, int sum, int n, int m, int t, int k) {
		if (idx == n) {
			if (chk(n, m, t, k)) {
				answer++;
			}
			return;
		}
		for (int i = 0; i <= m - sum; i++) {
			arr[idx] = i;
			dfs(idx + 1, sum + i, n, m, t, k);
		}
	}

	static boolean chk(int n, int m, int t, int k) {
		int tmpsum = 0;
		int sum = 0;
		for (int i = 0; i < t; i++) {
			tmpsum += arr[i];
			sum += arr[i];
		}
		if (tmpsum > k) {
			return false;
		}
		for (int i = t; i < n; i++) {
			tmpsum += arr[i];
			tmpsum -= arr[i - t];
			sum += arr[i];
			if (tmpsum > k) {
				return false;
			}
		}
		if (sum < m)
			return false;
		return true;

	}

	

}
