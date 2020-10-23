package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer; 
public class Main1735 {
	/*
	 * [백준] 분수합
	 * 
	 * 1. 기약분수 찾기
	 * 
	 * 2. 
	 * 
	 * 3. 유클리드 호제법 ㄱ
	 */
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 1; for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken()); 
            st = new StringTokenizer(br.readLine());
            int a2 = Integer.parseInt(st.nextToken()); 
            int b2 = Integer.parseInt(st.nextToken());
            int a3 = a1 * b2 + a2 * b1;
            int b3 = b1 * b2;
            int gcd = getGCD(a3, b3);
            bw.flush();
            bw.write((a3 / gcd) + " " + (b3 / gcd)); 
        } bw.close(); 
    } 
    public static int getGCD(int p, int q) { 
        if(q == 0) { 
            return p;
        } return getGCD(q, p%q); }
}
