package Programs;

import java.util.Scanner;

public class Solution_Winter1 {

	public static void main(String[] args) {
	
		String p= "<<<><";
		int n = 6;
		int[][] delivery = {{1,3,1},{3,5,0},{5,4,0},{2,5,0}};
		System.out.println(solution(n,delivery));
	}
	
	public static String solution(int n, int[][] delivery) {
		StringBuilder sb = new StringBuilder();
		int[] visited = new int[n+1];
		//첫째물건, 둘째물건
		int itemOne, itemTwo;
		
		//보내는거 판단
		for(int i=0;i<delivery.length;i++) {
			itemOne = delivery[i][0];
			itemTwo = delivery[i][1];
			if(delivery[i][2]==1) {
				visited[itemOne]=1; 
				visited[itemTwo]=1;
			}
		}
		
		//배송 못하는것 판단
		for(int i=0;i<delivery.length;i++) {
			itemOne = delivery[i][0];
			itemTwo = delivery[i][1];
			if(delivery[i][2]==0) {
				if(visited[itemOne]==1 && visited[itemTwo]==0) {
					visited[itemTwo]=2;
				}
				if(visited[itemTwo]==1 && visited[itemOne]==0) {
					visited[itemOne]=2;
				}	
			}
		}
		for(int i=0;i<n;i++) {		
			if(visited[i+1]==0) {
				sb.append("?");
			}else if(visited[i+1]==1) {
				sb.append("O");
			}else {
				sb.append("X");
			}
		}
		return sb.toString();		
	}
	
}
