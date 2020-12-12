package Programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_현카2 {

	public static void main(String[] args) {
		int left = 6;
		int right = 10;
		int offset = 0;
		System.out.println(solution(left,right,offset));
	}

	static Map<String,String> map;
	public static String solution(int left, int right, int offset) {
		map = new HashMap<String,String>();
		map.put("0", "zero");
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");
		map.put("6", "six");
		map.put("7", "seven");
		map.put("8", "eight");
		map.put("9", "nine");
		map.put("10", "ten");
		map.put("11", "eleven");
		map.put("12", "twelve");
		map.put("13", "thirteen");
		map.put("14", "fourteen");
		map.put("15", "fifteen");
		map.put("16", "sixteen");
		map.put("17", "seventeen");
		map.put("18", "eighteen");
		map.put("19", "nineteen");
		String str = "";
		while(str.length() < right) {
			str += strInteger(offset);
			offset+=1;
		}
		
		
		String answer = str.substring(left-1, right);
		return answer;
	}
	public static String strInteger(int target) {
		String temp = String.valueOf(target);
		int current=0;
		String strTemp = "";
		if(temp.length()<2) {
			return map.get(temp);
		}
		while(current<temp.length()) {
			String twoNumber = null;
			String oneNumber;
			if(current+1<temp.length()) {
				twoNumber = temp.substring(current, current+2);
			}
			oneNumber = temp.substring(current, current+1);
			if(map.containsKey(twoNumber)) {
				strTemp += map.get(twoNumber);
				current +=2;
			}else {
				strTemp +=map.get(oneNumber);
				current +=1;
			}
			System.out.println(strTemp);
		}
		return strTemp;

	}

}
