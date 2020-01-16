package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759_암호만들기 {

	/*
	 * 1. 사전식으로 가능성 있는 암호 만들기
	 * 
	 * 2. L,C <=15,모음 1개 자음 2개이상
	 * 
	 * 3. 정렬 후 조합 짜서 모든 수 구하고 모음 1개 자음 2개 안되는 것 빼기
	 */
	static int L, C;
	static char[] arr;
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		visit = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		nCr(0,0);
	}

	private static void nCr(int idx, int cnt) {
		if(cnt == L) {
			int mo = 0, za =0;
			for (int i = 0; i < L; i++) {
				if(sb.charAt(i) =='a' || sb.charAt(i) =='e' || sb.charAt(i) =='i' ||sb.charAt(i) =='o' ||sb.charAt(i) =='u') {
					mo++;
				}else za++;
			}
			
			if(mo >=1 && za >=2)System.out.println(sb.toString());
		}
		
		for (int i = idx; i < C; i++) {
			visit[i] = true;
			sb.append(arr[i]);
			nCr(i+1,cnt+1);
			sb.delete(sb.length()-1, sb.length());
			visit[i] = false;
		}
	}
}
