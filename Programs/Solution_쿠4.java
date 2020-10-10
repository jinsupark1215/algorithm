package Programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution_쿠4 {

	public static void main(String[] args) {
		String deper = "SEOUL";
		String hub = "DAEJEON";
		String dest = "YEOSU";
		String[][] roads = {{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"},{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"},{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"},{"DAEGU","BUSAN"},{"ULSAN","DAEGU"},{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}};
		System.out.println(solution(deper,hub,dest,roads));
	}

	static int ans, start, mid, end;
	static ArrayList<Integer>[] list;
	public static int solution(String depar, String hub, String dest, String[][] roads) {
		 list = new ArrayList[10001];
		 
	      for(int i=1;i<=10000;i++) {
	    	  list[i] = new ArrayList<Integer>();
	      }
	      
	      HashMap<String, Integer> map = new HashMap<String, Integer>();
	      
	      int idx = 1;
	      for(int i=0;i<roads.length;i++) {
	         String from = roads[i][0];
	         String to = roads[i][1];
	         
	         if(!map.containsKey(from)) map.put(from,idx++);
	         if(!map.containsKey(to)) map.put(to,idx++);
	         
	         list[map.get(from)].add(map.get(to));
	      }
	      
	      start = map.get(depar);
	      mid = map.get(hub);
	      end = map.get(dest);
	      dfs(start,false);
	      
	      return ans;
	   }
	   private static void dfs(int cur, boolean chk) {
	      if(cur==end){
	         if(chk) {
	            ans++;
	            ans%=10007;
	         }
	         return;
	      }
	      
	      for(int i=0;i<list[cur].size();i++){
	         int next = list[cur].get(i);
	         if(next==mid) {
	            dfs(next,true);
	         }
	         else {
	            dfs(next,chk);
	         }
	      }
	   }
}
