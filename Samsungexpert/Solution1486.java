package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1486 {

	/*
	 * 1. 점원들의 키를 합쳐서 B이상 중 가장 작은 키를 찾기
	 * 
	 * 2. N <=20, B <S
	 * 
	 * 3. 조합을 통해서 가장 가까운 값을 도출
	 */
	
	static int N, B, ans;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr= new int[N];
			visit = new boolean[N];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				nCr(0,0,0,i);
			}
			
			System.out.println("#" + testcase + " " + (ans-B));
		}
	}
	private static void nCr(int idx, int cnt,int sum, int chk) {
		if(cnt == chk) {
			if(sum >= B) {
				ans = Math.min(sum, ans);
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			visit[i] = true;
			nCr(i+1,cnt+1,sum+arr[i],chk);
			visit[i] = false;
		}
	}
}

