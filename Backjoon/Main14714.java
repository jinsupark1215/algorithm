package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14714 {

	/*
	 * [백준] 홍삼게임
	 * 
	 * 1. 최대한 빠르게 끝내고자 할 때 필요한 최소 지목횟수는?
	 * 
	 * 2. N <= 500
	 * 
	 * 3. 2차원 배열로 처음 [] 는 인덱스 두번째 []는 몇번째 방문인지 판단해서 true면 반환
	 */
	static int N, sa,sb,da,db;
	static boolean flag;
	static boolean[][] mapA,mapB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		mapA = new boolean[N][1000];
		mapB = new boolean[N][1000];
		sa = Integer.parseInt(st.nextToken())-1;
		sb = Integer.parseInt(st.nextToken())-1;
		mapA[sa][0] = true;
		mapB[sb][0] = true;
		da = Integer.parseInt(st.nextToken());
		db = Integer.parseInt(st.nextToken());
		flag = false;
		
		int idx = 0;
		int cnt = 0;
		
		fin:
		while(true) {
			int plus =0,minus = 0;
			
			if(cnt>1000)break;
			
			//A가 지목하면서 찾기
			cnt++;
			for (int i = 0; i < N; i++) {
				if(mapA[i][idx]) {
					plus = (i+da)%N;
					minus = (i-da)<0?N+(i-da):i-da;
					if(mapB[plus][idx] || mapB[minus][idx]) {
						flag = true;
						break fin;
					}else {
						mapA[plus][idx+1] = true;
						mapA[minus][idx+1] = true;
					}
				}
			}
			
			//B가 지목하면서 찾기
			cnt++;
			for (int i = 0; i < N; i++) {
				if(mapB[i][idx]) {
					plus = (i +db)%N;
					minus = (i-db)<0?N+(i-db):i-db;
					if(mapA[plus][idx+1] || mapA[minus][idx+1]) {
						flag = true;
						break fin;
					}else {
						mapB[plus][idx+1] = true;
						mapB[minus][idx+1] = true;
					}
				}
			}
			idx++;
		}
		
		if(flag)System.out.println(cnt);
		else System.out.println("Evil Galazy");
	}
}
