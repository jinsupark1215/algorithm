package Programs;

public class Solution_라인2 {

	public static void main(String[] args) {
		String answer_sheet = "24551";
		String[] sheets = {"24553", "24553", "24553", "24553"};
		System.out.println(solution(answer_sheet, sheets));
	}

	private static int solution(String answer_sheet, String[] sheets) {
		int answer = 0;
		boolean[] flag;
		int cnt;
		int maxcnt;
		int tmpcnt;
		
		for (int i = 0; i < sheets.length; i++) {
			for (int j = i+1; j < sheets.length; j++) {
				flag = new boolean[answer_sheet.length()];
				cnt = 0;
				maxcnt = 0;
				tmpcnt = 0;
				for (int k = 0; k < answer_sheet.length(); k++) {
					if(sheets[i].charAt(k) == sheets[j].charAt(k)) {
						flag[k] = true;
					}
					if(sheets[i].charAt(k) == answer_sheet.charAt(k)) {
						flag[k] = false;
					}
				}
				
				for (int k = 0; k < answer_sheet.length(); k++) {
					if(flag[k]) {
						cnt++;
						tmpcnt++;
					}else {
						tmpcnt = 0;
					}
					maxcnt = Math.max(maxcnt, tmpcnt);
					
				}
				answer = Math.max(answer, cnt+(maxcnt*maxcnt));
			}
		}
		return answer;
	}


}
