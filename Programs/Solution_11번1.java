package Programs;

public class Solution_11번1 {
	public static void main(String[] args) {
		String S = "z";
		System.out.println(solution(S));
	}

	private static int solution(String S) {
		int ans = 0;
		
		if(S.contains("aaa")) {
			ans = -1;
		}else {
			int acnt=0, cnt = 0;
			
			for (int i = 0; i < S.length(); i++) {
				if(S.charAt(i) == 'a')acnt++;
				else cnt++;
			}
			
			ans = (cnt+1)*2 - acnt;
		}
		
		return ans;
	}

}
