package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] ltor = new int[N];
		int[] rtol = new int[N];
		int res1 = 0, res2 =0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ltor[0] = arr[0];
		for (int i = 1; i < N; i++) {
			ltor[i] = gcd(ltor[i-1], arr[i]);
		}
		rtol[N-1] = arr[N-1];
		
		for (int i = N-2; i >=0; i--) {
			rtol[i] = gcd(rtol[i+1], arr[i]);
		}
		int t = rtol[1];
		if (arr[0] < t || gcd(arr[0], t) != t) {
			res1 = t;
		}
		for (int i = 1; i < N-1; i++) {
			t = gcd(ltor[i - 1], rtol[i + 1]);
			if (arr[i] < t || gcd(arr[i], t) != t) {
				if (res1 < t) {
					res1 = t;
					res2 = i;
				}
			}
		}
		if (arr[N-1] < ltor[N-2] || gcd(arr[N-1], ltor[N-2]) != t) {
			if (res1 < t) {
				res1 = ltor[N-2];
				res2 = N-2;
			}
		}
		if (res1 == 0) System.out.println(-1);
		else System.out.println(res1 + " " + arr[res2]);
	}
	public static int gcd(int a, int b) {
		if(b==0)return a;
		return gcd(b,a%b);
	}
}
