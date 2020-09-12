package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_까3 {
	   public static void main(String[] args){
	      int[] answer = solution(new String[] 
	            {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
	            new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150",
	                  "- and - and - and chicken 100","- and - and - and - 150"});
	      System.out.println(Arrays.toString(answer));
	   }
	   
	   public static int[] solution(String[] info, String[] query){
	      int[] ans = {};
	      int[][][][][] scoreTable;
	      ArrayList<Integer> list = new ArrayList<Integer>();
	      StringTokenizer st;
	      int lan,end,career,food,score;
	      //입력
	      scoreTable = new int[3][2][2][2][100001];
	      for(int i=0;i<info.length;i++){
	         st = new StringTokenizer(info[i]);
	         lan = getLanguageKey(st.nextToken());
	         end = getPositionKey(st.nextToken());
	         career = getCareerKey(st.nextToken());
	         food = getSoulFoodKey(st.nextToken());
	         score = Integer.parseInt(st.nextToken());
	         scoreTable[lan][end][career][food][score]++;
	      }
	      for(int l=0;l<3;l++) {
		         for(int e=0;e<2;e++) {
		            for(int c = 0; c<2 ; c++) {
		               for(int f = 0; f<2; f++) {
		                  for(int s=99999; s>=0; s--) {
		                     scoreTable[l][e][c][f][s]+=scoreTable[l][e][c][f][s+1];
		                  }
		               }
		            }
		         }
		      }
	      
	      //쿼리문 실행
	      for(int i = 0; i < query.length; i++){
		         st = new StringTokenizer(query[i]);
		         lan = getLanguageKey(st.nextToken());
		         st.nextToken(); //and
		         end = getPositionKey(st.nextToken());
		         st.nextToken(); //and
		         career = getCareerKey(st.nextToken());
		         st.nextToken(); //and
		         food = getSoulFoodKey(st.nextToken());
		         score = Integer.parseInt(st.nextToken());
		         int sum = 0;
		         for(int l=0;l<3;l++) { //답 검색
		            for(int e=0;e<2;e++) {
		               for(int c = 0; c<2 ; c++) {
		                  for(int f = 0; f<2; f++) {
		                     if(lan==-1) {
		                        if(end==-1){
		                           if(career==-1) {
		                              if(food==-1) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                              }else {
		                                 if(food==f) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }
		                           }else {
		                              if(food==-1) {
		                                 if(career==c) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }else {
		                                 if(career==c && food==f) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }
		                           }
		                        }else { //pos
		                           if(career==-1) {
		                              if(food==-1) {
		                                 if(end==e) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }else {
		                                 if(end==e && food==f) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }
		                           }else {
		                              if(food==-1) {
		                                 if(end==e && career==c) {
		                                    sum+=scoreTable[l][end][career][f][score];
		                                 }
		                              }else {
		                                 if(end==e && career==c && food==f) {
		                                    sum+=scoreTable[l][end][career][food][score];
		                                 }
		                              }
		                           }
		                        }
		                     }else {
		                        if(end==-1){
		                           if(career==-1) {
		                              if(lan==l && food==-1) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                              }else {
		                                 if(lan==l && food==f) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }
		                           }else {
		                              if(lan==l && food==-1) {
		                                 if(career==c) {
		                                    sum+=scoreTable[l][e][c][f][score]; 
		                                 }
		                              }else {
		                                 if(lan==l && career==c && food==f) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }
		                           }
		                        }else { //pos
		                           if(career==-1) {
		                              if(food==-1) {
		                                 if(lan==l && end==e) {
		                                    sum+=scoreTable[l][e][c][f][score];
		                                 }
		                              }else {
		                                 if(lan==l && end==e && food==f) {
		                                    sum+=scoreTable[l][e][c][f][score]; 
		                                 }
		                              }
		                           }else {
		                              if(lan==l && food==-1) {
		                                 if(end==e && career==c) {
		                                    sum+=scoreTable[l][end][career][f][score]; 
		                                 }
		                              }else {
		                                 if(lan==l && end==e && career==c && food==f) {
		                                    sum+=scoreTable[l][end][career][food][score];
		                                 }
		                              }
		                           }
		                        }
		                     }
		                  }
		               }
		            }
		         }
		         list.add(sum);
		      }
	      
	      ans = new int[list.size()];
	      for(int i=0;i<ans.length;i++) ans[i] = list.get(i);
	      return ans;
	   }
	   
	private static int getCareerKey(String input) {
		if (input.equals("junior"))
			return 0;
		else if (input.equals("senior"))
			return 1;
		else if (input.equals("-"))
			return -1;
		return 0;
	}

	private static int getSoulFoodKey(String input) {
		if (input.equals("chicken"))
			return 0;
		else if (input.equals("pizza"))
			return 1;
		else if (input.equals("-"))
			return -1;
		return 0;
	}

	private static int getPositionKey(String input) {
		if (input.equals("backend"))
			return 0;
		else if (input.equals("frontend"))
			return 1;
		else if (input.equals("-"))
			return -1;
		return 0;
	}

	private static int getLanguageKey(String input) {
		if (input.equals("cpp"))
			return 0;
		else if (input.equals("java"))
			return 1;
		else if (input.equals("python"))
			return 2;
		else if (input.equals("-"))
			return -1;
		return 0;
	}

}
