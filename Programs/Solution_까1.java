package Programs;

public class Solution_까1 {

	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
		String new_id = "=.=";
		System.out.println(solution(new_id));
	}

	private static String solution(String new_id) {
		StringBuilder ans = new StringBuilder();
		
		//1단계
		ans.append(new_id.toLowerCase());
		
		
		//2단계
		for (int i = 0; i < ans.length(); i++) {
			char tmp = ans.charAt(i);
			if(tmp =='-' || tmp =='_' || tmp=='.' || (tmp-'a' >=0 && tmp-'z' <=0) || (tmp-'0' >= 0 && tmp-'9' <= 0))continue;
			
			ans.delete(i, i+1);
			i--;
		}
		
		//3단계
		for (int i = 0; i < ans.length()-1; i++) {
			char tmp = ans.charAt(i);
			if(tmp == '.' && ans.charAt(i+1) =='.') {
				ans.delete(i, i+1);
				i--;
			}
		}
		
		//4단계
		if(ans.length()>0 &&ans.charAt(0) == '.')ans.delete(0, 1);
		if(ans.length()>0 &&ans.charAt(ans.length()-1) == '.')ans.delete(ans.length()-1, ans.length());
		
		//5단계
		if(ans.length() == 0)ans.append('a');
		
		//6단계
		if(ans.length() > 15) {
			ans.delete(15, ans.length());
			if(ans.charAt(ans.length()-1) == '.')ans.delete(ans.length()-1, ans.length());
		}
		
		//7단계
		if(ans.length() ==2) {
			ans.append(ans.charAt(ans.length()-1));
		}
		if(ans.length() == 1) {
			ans.append(ans.charAt(0));
			ans.append(ans.charAt(0));
		}
        return ans.toString();
	}
}
