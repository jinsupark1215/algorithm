package Programs;

public class Solution_고도2 {

	public static void main(String[] args) {
		int page = 5457;
		int[] broken = {6,7,8};
		System.out.println(solution(page, broken));
	}

	static int ans;
	static boolean[] num;
	private static int solution(int page,int[] broken) {
		ans = 0;
		num = new boolean[10];
		for (int i = 0; i < broken.length; i++) {
			num[broken[i]] = true;
		}
		ans = Math.abs(page - 100);
		
		//dfs 찾기
		solve(0,0,page);
		
		return ans;
	}
	private static void solve(int depth, int x, int page) {
		//자릿수를 만들었을 때 차이 
		if (depth > 0) {
			ans = Math.min(ans, Math.abs(page - x) + depth);
		}
		// 6자리이상 넘어가지 않으니 넘어가면 리턴
		if (depth == 6) {
			return;
		}
		//고장나지 않은 것 찾아서 수 만들기
		for (int i = 0; i < 10; i++) {
			if (num[i]) {
				continue;
			}
			solve(depth + 1, x * 10 + i, page);
		}
	}
	 
}
