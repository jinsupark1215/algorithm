package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main4811 {

	/*
	 * [백준] 알약
	 * 
	 * 1. 서로 다른 문자열을 가질 경우의 수
	 * 
	 * 2. N <=30
	 * 
	 * 3. 경우의수
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] a = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190, 6564120420L, 24466267020L, 91482563640L, 343059613650L, 1289904147324L, 4861946401452L, 18367353072152L, 69533550916004L, 263747951750360L, 1002242216651368L, 3814986502092304L};
		
		StringBuilder sb = new StringBuilder();
		while(true) {
		int N= Integer.parseInt(br.readLine());
		if(N == 0) break;
		bw.write(a[N]+"\n");
		}
		bw.flush();
	}
}
