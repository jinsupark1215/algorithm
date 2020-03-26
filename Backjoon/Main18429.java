package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18429 {

	/*
	 * [백준] 근손실
	 * 1. 중량이 항상 500이 넘는 경우의 수
	 * 
	 * 2. K,A <=50
	 * 
	 * 3. 조합 짜서 빼고 더했을 때 음수가 되지 않는 경우의 수
	 */
	static int N,K,weight,ans;
	static int[] kit;
	static int[] seq;
	static boolean[] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kit = new int[N];
		seq = new int[N];
		chk = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		Combi(0);
		
		System.out.println(ans);
	}
	private static void Combi(int idx) {
		if(idx == N) {
			weight = 0;
			if(solve())ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				seq[i] = idx;
				Combi(idx+1);
				chk[i] = false;
			}
		}
	}
	private static boolean solve() {
		for (int i = 0; i < N; i++) {
			weight -= K;
			weight += kit[seq[i]];
			if(weight < 0)return false;
		}
		
		return true;
	}
}
