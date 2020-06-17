package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17128 {

	/*
	 * [백준] 소가 정보섬에 올라온 이유
	 * 
	 * 1. 장난질한 횟수의 경우를 구하라
	 * 
	 * 2. N,Q <=200000
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());//소의 수
    	int q = Integer.parseInt(st.nextToken());//장난칠 횟수
    	int[] arr = new int[n];
		int sum = 0;
    	
		st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken()); //소의 품질
    	}
    	
    	for(int i = 0; i<n; i++) {
    		sum += (arr[i%n] * arr[(i+1)%n] * arr[(i+2)%n] * arr[(i+3)%n]);
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<q; i++) {
    		int num = Integer.parseInt(st.nextToken()); //장난칠 소의 번호
    		arr[num-1] *= -1; //장난칠 소의 품질 부호를 바꿈
    		int tmp = 0;
    		int cnt = 0;
			int j = num-1;
    		while(cnt != 4) {
    			if(j < 0)
    				j += n;
    			tmp += (arr[j%n] * arr[(j+1)%n] * arr[(j+2)%n] * arr[(j+3)%n]);
    			j--;
    			cnt++;
    		}
    		sum = sum + (2*tmp);
    		System.out.println(sum);
    	}
	}
}
