package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12025 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] pass = br.readLine().toCharArray();
		long k = Long.parseLong(br.readLine());
		long cnt=0;
		
		for(int i=0;i<pass.length;i++) {
			switch(pass[i]) {
			case '1':
			case '2':
			case '6':
			case '7':
				cnt++;
				break;
			default:
				break;
			}
		}
		if(k > ((long)1 << cnt)) {
			System.out.println(-1);
		} else {
			char[] outString = new char[pass.length];
			for(int i=0;i<pass.length;i++) {
				switch(pass[i]) {
				case '1':
				case '6':
					if(((k-1) & ((long)1 << ( cnt-1))) != 0) {
						outString[i] = '6';
					} else {
						outString[i] = '1';
					}
					cnt--;
					break;
				case '2':
				case '7':
					if(((k-1) & ((long)1 << (cnt-1))) != 0) {
						outString[i] = '7';
					} else {
						outString[i] = '2';
					}
					cnt--;
					break;
				default:
					outString[i] = pass[i];
					break;
				}
				
			}
			System.out.println(outString);
		}
	}
}
