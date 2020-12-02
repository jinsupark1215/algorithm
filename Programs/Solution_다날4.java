package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_다날4 {

	public static void main(String[] args) {
		int[][] customer = {{4, 1}, {3, 1}, {2, 1}, {4, 0}, {1, 1}, {1, 0}, {4, 1}, {4, 0},{4,1}};
		int K = 3;
		System.out.println(Arrays.toString(solution(customer, K)));
	}

	private static int[] solution(int[][] customer, int K) {
		int[] in = new int[1000001] ;
		int[] index = new int[1000001] ;
		boolean[] visit = new boolean[500000];
		for(int i=0;i<customer.length;i++) {
			int[] info = customer[i];
			int person = info[0];
			int reserve = info[1]; // 0 cancel , 1 booking
			if(reserve == 1) {
				in[person]=1;
				index[person]=i;
			}else if(reserve==0){
				in[person]=2;
				visit[index[person]]=true;
				visit[i]=true;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<customer.length && list.size()<K;i++) {
			if(visit[i]==false) {
				list.add(customer[i][0]);
			}
		}
		Collections.sort(list);
		int t=0;
		int[] ans = new int[list.size()];
		for(Integer i : list) {
			
			ans[t]=i;
			t++;
		}
			
    	return ans;

	}
}
