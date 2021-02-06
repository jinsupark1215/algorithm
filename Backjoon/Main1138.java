package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1138 {

	/*
	 * [백준] 한줄로 서기
	 * 
	 * 1. 순서대로 키 출력
	 * 
	 * 2.
	 * 
	 * 3. 순서대로 리스트 저장
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] tall = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> ans = new ArrayList<>();
 
        for(int i=1; i<=n; i++) {
            tall[i] = Integer.parseInt(st.nextToken());
        }
 
        for(int i=n; i>=1; i--) {
            ans.add(tall[i], i);
        }
 
        for(int k : ans) {
            System.out.print(k+" ");
        }
    }
}
