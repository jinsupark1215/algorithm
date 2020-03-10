package Backjoon;

import java.util.Scanner;

public class Main2238 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u = sc.nextInt();
		int n = sc.nextInt();
		int answer =0;
		String[] name = new String[n];
		int[] money = new int[n];
		int[] chk = new int[u+1];
		
		for (int i = 0; i < n; i++) {
			name[i] = sc.next();
			int num = sc.nextInt();
			money[i] = num;
			chk[num]++;
		}
		
		int one = 0;
		int many = Integer.MAX_VALUE;
		for (int i = 0; i < u+1; i++) {
			if(chk[i] == 1) {
				one++;
			}else if(chk[i] >1) {
				many = many>chk[i]?chk[i]:many;
			}
		}
		
		if(one >0) {
			fin:
			for (int i = 0; i < u+1; i++) {
				if(chk[i] == 1) {
					for (int j = 0; j < n; j++) {
						if (i == money[j]) {
							System.out.println(name[j] + " " + money[j]);
							break fin;
						}
					}
				}
			}
		}else {
			fin:
			for (int i = 0; i < u+1; i++) {
				if(chk[i] == many) {
					for (int j = 0; j < n; j++) {
						if (i == money[j]) {
							System.out.println(name[j] + " " + money[j]);
							break fin;
						}
					}
				}
			}
		}
	}
}

