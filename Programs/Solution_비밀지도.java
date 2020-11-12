package Programs;

public class Solution_비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String sb1 = Integer.toBinaryString(arr1[i]);
			String sb2 = Integer.toBinaryString(arr2[i]);
			String tmp1 = "";
			String tmp2 = "";
			for (int j = 0; j < n - sb1.length(); j++) {
				tmp1 += '0';
			}
			tmp1 += sb1;
			for (int j = 0; j < n - sb2.length(); j++) {
				tmp2 += '0';
			}
			tmp2 += sb2;
			String sb = "";

			for (int j = 0; j < n; j++) {
				if (tmp1.charAt(j) == '0' && tmp2.charAt(j) == '0') {
					sb += " ";
				} else {
					sb += "#";
				}
			}
			answer[i] = sb;
		}
		return answer;
	}
}
