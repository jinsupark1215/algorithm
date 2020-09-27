package Programs;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_현차3 {

	public static void main(String[] args) {
		String s = "dbdad";
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		
		char[] ch = s.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		char[] chk = new char[s.length()];
		for (int i = 0; i < ch.length; i++) {
			sb.append(ch[i]);
		}
		
		list.add(sb.toString());
		int tmpidx, tmpcnt;
		for (int cnt = 1; cnt < s.length(); cnt++) {
			for (int idx = 0; idx+cnt < s.length(); idx++) {
				sb = new StringBuilder();
				for (int i = 0; i < chk.length; i++) {
					chk[i] = ch[i];
				}
				tmpidx = idx;
				tmpcnt = cnt;
				while(tmpidx + tmpcnt > tmpidx) {
					 char tmp = chk[tmpidx];
					 chk[tmpidx] = chk[tmpidx + tmpcnt];
					 chk[tmpidx+tmpcnt] = tmp;
					 tmpidx++;
					 tmpcnt-=2;
					 
					 if(tmpcnt==0) break;
				}
				
				for (int i = 0; i < chk.length; i++) {
					sb.append(chk[i]);
				}
				list.add(sb.toString());
			}
		}
		Collections.sort(list);
		
		return list.get(list.size()-1);
	}
}
