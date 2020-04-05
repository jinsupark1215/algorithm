package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_라인6 {

	public static void main(String[] args) {
		String[] directory = { "/"};
		String[] command = { "mkdir /a",
				"mkdir /a/b",
				"mkdir /a/b/c",
				"cp /a/b /",
				"rm /a/b/c"};
		System.out.println(Arrays.toString(solution(directory, command)));
	}

	private static String[] solution(String[] directory, String[] command) {
		String[] result = {};
		
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < directory.length; i++) {
			list.add(directory[i]);
		}
		
		for (int i = 0; i < command.length; i++) {
			StringTokenizer st = new StringTokenizer(command[i]);
			String input = st.nextToken();
			if(input.equals("mkdir")) {
				list.add(st.nextToken());
			}else if(input.equals("rm")) {
				String tmp = st.nextToken();
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).length() >= tmp.length() 
							&& list.get(j).substring(0, tmp.length()).equals(tmp)) {
						list.remove(j);
						j--;
					}
				}
			}else if(input.equals("cp")) {
				String tmp1 = st.nextToken();
				String tmp2 = st.nextToken();
				for (int j = 0; j < list.size(); j++) {
					StringBuilder sb = new StringBuilder();
					if(list.get(j).length() >= tmp1.length() &&list.get(j).substring(0, tmp1.length()).equals(tmp1)) {
						sb.append(tmp2);
						int tmp = 0;
						
						sb.append(list.get(j));
						list.add(sb.toString());
					}
				}
			}
		}
		result = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
