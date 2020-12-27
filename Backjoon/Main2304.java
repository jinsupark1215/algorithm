package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2304 {

	/*
	 * [백준] 창고 다각형
	 * 
	 * 1. 다각형의 면적
	 * 
	 * 2. 1000이하
	 * 
	 * 3. 스택
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;

	        int n=Integer.parseInt(br.readLine());
	        int[] arr=new int[1001];
	        int start=1000;
	        int end=0;
	        for(int i=0;i<n;i++){
	            st=new StringTokenizer(br.readLine());
	            int l=Integer.parseInt(st.nextToken());
	            int h=Integer.parseInt(st.nextToken());
	            arr[l]=h;
	            start=Math.min(l,start);
	            end=Math.max(l,end);
	        }

	        Stack<Integer> trace=new Stack<>();
	        int pivot=arr[start];
	        for(int l=start+1;l<=end;l++){
	            if(arr[l]<pivot) trace.push(l);
	            else{
	                while(!trace.isEmpty()){
	                    int p=trace.pop();
	                    arr[p]=pivot;
	                }
	                pivot=arr[l];
	            }
	        }

	        trace.clear();
	        pivot=arr[end];
	        for(int l=end-1;l>=start;l--){
	            if(arr[l]<pivot) trace.push(l);
	            else{
	                while(!trace.isEmpty()){
	                    int p=trace.pop();
	                    arr[p]=pivot;
	                }
	                pivot=arr[l];
	            }
	        }

	        int answer=0;
	        for(int l=start;l<=end;l++){
	            answer+=arr[l];
	        }
	        System.out.println(answer);
	}
}
