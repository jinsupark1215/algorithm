package Programs;

public class Solution_네1 {

	public static void main(String[] args) {
		String m = "acbbcdc";
		String k = "abc";
		System.out.println(solution(m,k));
	}

	private static String solution(String m, String k) {

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < m.length(); i++) {
			if(idx != k.length() && m.charAt(i) == k.charAt(idx)) {
				idx++;
			}else {
				sb.append(m.charAt(i));
			}
		}
		return sb.toString();
	}
}
