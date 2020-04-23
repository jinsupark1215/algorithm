package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2042 {

	/*
	 * [백준] 구간 합 구하기
	 * 
	 * 1. 구간 합 구하기
	 * 
	 * 2. N <=1,000,000, M <=10000, K <=10000
	 * 
	 * 3. 세그먼트트리, 인덱스 트리 
	 * *수의 갯수가 많고 Query문의 개수가 많기 때문에 그냥 한다면 시간초과 
	 * -> 세그먼트트리 이용
	 */

	static int n, M, K, i;
	static long[] arr, tree;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tree = new long[n + 1];
		arr = new long[n + 1];

		for (i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
			FenwickUpdate(i, arr[i]);
		}
		long a, b, c;
		for (i = 1; i <= M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if (a == 1) {
				FenwickUpdate((int) b, c - arr[(int) b]);
				arr[(int) b] = c;
			} else
				bw.write(FenwickSum((int) c) - FenwickSum((int) b - 1) + "\n");
		}
		bw.close();
	}

	static long FenwickSum(int p) {
		long sum = 0;
		while (p > 0) {
			sum += tree[p];
			p -= (p & -p);
		}
		return sum;
	}

	static void FenwickUpdate(int p, long val) {
		while (p <= n) {
			tree[p] += val;
			p += (p & -p);
		}
	}

}
