package Programs;

public class Solution_라인3 {

	public static void main(String[] args) {
		String road = "111011110011111011111100011111";
		int n = 3;
		System.out.println(solution(road,n));
	}

	private static int solution(String road, int n) {
		int answer = 0;
		int cnt;
		
		for (int i = 0; i < road.length(); i++) {
			cnt = 1;
			if(road.charAt(i) == '0') {
				for (int j = i-1; j >=0; j--) {
					if(road.charAt(j) =='1') cnt++;
					else break;
				}
				int zerocnt = 0;
				for (int j = i+1; j < road.length(); j++) {
					if(road.charAt(j) == '0')zerocnt++;
					
					cnt++;
					if(zerocnt==n) {
						cnt--;
						break;
					}
				}
				answer = Math.max(answer, cnt);
				if(answer == road.length())break;
			}
			
		}
		return answer;
	}


}
