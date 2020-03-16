package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_카카오_오픈채팅방 {

	/*
	 * 1. 압축해서 가장 짧은 길이는?
	 * 
	 * 2. s <= 1000
	 * 
	 * 3. Map 사용
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

		System.out.println(Arrays.toString(solution(record)));
	}

	private static String[] solution(String[] record) {
		
		String[] id = new String[record.length];
		int[] chk = new int[record.length];
		int idx = 0;
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			
			String input = st.nextToken();
			if(input.equals("Enter")) {
				String tmpid = st.nextToken();
				map.put(tmpid, st.nextToken());
				id[idx] = tmpid;
				chk[idx] = 1;
				idx++;
			}else if(input.equals("Leave")) {
				String tmpid = st.nextToken();
				id[idx] = tmpid;
				chk[idx] = 2;
				idx++;
			}else if(input.equals("Change")) {
				String tmpid = st.nextToken();
				map.replace(tmpid, st.nextToken());
			}
		}
		
		String[] answer = new String[idx];
		StringBuilder sb;
		for (int i = 0; i < idx; i++) {
			sb = new StringBuilder();
			sb.append(map.get(id[i]));
			if(chk[i] == 1)sb.append("님이 들어왔습니다.");
			else sb.append("님이 나갔습니다.");
			answer[i] = sb.toString();
		}
		return answer;
	}
}
