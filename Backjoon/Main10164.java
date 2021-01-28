package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10164 {

	/*
	 * [백준] 격자상의경로 1. 서로 다른 경로의 수
	 * 
	 * 2.
	 * 
	 * 3. dp
	 */

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine().trim());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		if(k==0) k=n*m;
		int row=k/m+1;
		int col=k%m;
		if(col==0){
			row--;
			col=m;
		}
		int[][] arr=new int[n+1][m+1];
		arr[0][1]=1;
		for(int r=1 ; r<=row ; r++){
			for(int c=1 ; c<=col ; c++){
				arr[r][c]=arr[r-1][c]+arr[r][c-1];
			}
		}
		for(int r=row ; r<=n ; r++){
			for(int c=col ; c<=m ; c++){
				arr[r][c]=arr[r-1][c]+arr[r][c-1];
			}
		}
		System.out.println(arr[n][m]);
	}
}
