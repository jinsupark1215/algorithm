package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main4358 {

	/*
	 * [백준] 생태학
	 * 1. 이름을 사전순으로 출력하고 비율
	 * 
	 * 2. 10000종, 1000000그루
	 * 
	 * 3. 해시맵 이용
	 */
	static HashMap<String, Integer> trees;
	static int allCount;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		trees = new HashMap<String, Integer>();
		String str = br.readLine();
		while(true) {
            trees.put(str, trees.getOrDefault(str, 0) + 1);
			allCount++;
			
			str = br.readLine();
			if(str == null || str.length() == 0) {
				break;
			}
		}
		
		// 키 오름차순 정렬 
		Object[] keys = trees.keySet().toArray();
		Arrays.sort(keys);
		
		StringBuilder sb = new StringBuilder();
		for(Object key : keys) {
			String keyStr = (String) key;
			int count = trees.get(keyStr);
			double per = (double)(count * 100.0) / allCount;
			
			sb.append(keyStr + " " + String.format("%.4f", per) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
