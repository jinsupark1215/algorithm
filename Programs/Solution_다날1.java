package Programs;

public class Solution_다날1 {

	public static void main(String[] args) {
		String[] strs = {"abcaefg", "abcdefg", "abcdhfg"};
		System.out.println(solution(strs));
	}

	private static String solution(String[] strs) {
		StringBuilder sb = new StringBuilder();
		boolean flag;
		char tmp;
		int idx = 0;
		for (int i = 0; i < strs[0].length(); i++) {
			flag = true;
			tmp = strs[0].charAt(idx);
			for (int j = 1; j < strs.length; j++) {
				if(idx == strs[j].length() ||tmp != strs[j].charAt(idx)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sb.append(tmp);
			}else {
				break;
			}
			idx++;
		}
		return sb.toString();
	}
}
