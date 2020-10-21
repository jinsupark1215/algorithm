package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1644 {

	/*
	 * [백준] 소수의 연속합
	 * 1. 연속된 소수합으로 만들수 있는 경우의 수
	 * 
	 * 2. N <=4000000
	 * 
	 * 3. 구현
	 */
	static boolean prime[];
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        prime = new boolean[N+1];        
        prime[0] = prime[1] = true;
        //체 사용
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;                
        }            
        for(int i=1; i<=N;i++){
        	if(!prime[i]) list.add(i);     
        }
        
        int start=0, end=0, sum=0, cnt=0;
        while(true) {
        	if(sum >= N ) sum -= list.get(start++);
        	else if(end == list.size()) break;
        	else sum += list.get(end++);       	
        	if(N==sum) cnt++;        	
        }		
        System.out.println(cnt);	
    }	
}
