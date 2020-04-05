package Programs;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_라인1 {

	public static void main(String[] args) {
		String inputString = ">_<";
		System.out.println(solution(inputString));
	}

	private static int solution(String inputString) {
		int answer = 0;
		boolean flag;
		
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < inputString.length(); i++) {
			flag = true;
			
			if(inputString.charAt(i) == '(' || inputString.charAt(i) == '{' || inputString.charAt(i) == '[' || inputString.charAt(i) == '<'){
				list.add(inputString.charAt(i));
			}else if(inputString.charAt(i) ==')') {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j) =='(') {
						answer++;
						list.remove(j);
						flag = false;
						break;
					}
				}
				if(flag) {
					answer = -1;
					break;
				}
			}else if(inputString.charAt(i) =='}') {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j) =='{') {
						answer++;
						list.remove(j);
						flag = false;
						break;
					}
				}
				if(flag) {
					answer = -1;
					break;
				}
			}else if(inputString.charAt(i) ==']') {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j) =='[') {
						answer++;
						list.remove(j);
						flag = false;
						break;
					}
				}
				if(flag) {
					answer = -1;
					break;
				}
			}else if(inputString.charAt(i) =='>') {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j) =='<') {
						answer++;
						list.remove(j);
						flag = false;
						break;
					}
				}
				if(flag) {
					answer = -1;
					break;
				}
			}
		}
        return answer;
	}

}
