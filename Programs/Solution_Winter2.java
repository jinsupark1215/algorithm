package Programs;

import java.util.Scanner;

public class Solution_Winter2 {

	public static void main(String[] args) {
	
		String encrypted_text = "qyyigoptvfb";
		String key = "abcdefghijk";
//		String encrypted_text = "z";
//		String key = "z";
		int rotation = 3;
		System.out.println(solution(encrypted_text, key, rotation));
	}

	private static String solution(String encrypted_text, String key, int rotation) {
		
//		char[] Alpa = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//		StringBuilder sb = new StringBuilder();
//		int idx = rotation%key.length();
//		
//		if(idx <0)idx = key.length() + idx;
//		
//		int tmp = 0;
//		for (int i = 0; i < key.length(); i++) {
//			if(idx == encrypted_text.length())idx = 0;
//			
//			tmp = ((encrypted_text.charAt(idx) -'a') - ((key.charAt(i)-'a'+1)));
//			if(tmp < 0)tmp = 26+tmp;
//			sb.append(Alpa[tmp]);
//			idx++;
//		}
//		
//		
//		
//		return sb.toString();
		
		String answer = "";
		String tmp = "";
		rotation = rotation % key.length();
		int index = Math.abs(rotation);
		if(rotation>0) {
			tmp = encrypted_text.substring(index)+encrypted_text.substring(0, index);
		}else {
			tmp = encrypted_text.substring(key.length()-index)+encrypted_text.substring(0,key.length()-index);
		}
		//System.out.println(temp);		 
		for(int i=0;i<key.length();i++) {
			int enc = tmp.charAt(i)-96;
			int keyIndex = key.charAt(i)-96;
			int plain=(enc-keyIndex);
			
			if(plain<1) {
				plain =(plain + 26);
			}
			answer += (char)(plain+96);
		}
		return answer;
	}
	
}
