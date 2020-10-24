package Programs;

import java.util.Scanner;

public class Solution_nhn3 {
	 private static void solution(int numOfOrder, String[] orderArr) {

		 for (int test = 0; test < numOfOrder; test++) {
			
			 StringBuilder target;
			 StringBuilder after;
			 StringBuilder before;
			 char tmp = 0;
			for (int i = 0; i < orderArr[test].length(); i++) {
				//) 기준으로 찾기
				if(orderArr[test].charAt(i) == ')') {
					target = new StringBuilder();
					before = new StringBuilder();
					after = new StringBuilder();
					//target되는 문자 찾기
					for (int j = i-1; j >=0; j--) {
						if(orderArr[test].charAt(j) == '(') {
							tmp = orderArr[test].charAt(j-1);
							break;
						}
						target.insert(0, orderArr[test].charAt(j));
						before.insert(0, orderArr[test].charAt(j));
					}
					
					//기존문자 재현
					before.append(')');
					before.insert(0, '(');
					before.insert(0, tmp);
					
					//바꿀 문자 재현
					if(tmp-'0' >=0 && tmp-'0' <= 9) {
						for (int j = 0; j < tmp-'0'; j++) {
							after.append(target);
						}
					}else {
						for (int j = 0; j < target.length(); j++) {
							after.append(tmp);
							after.append(target.charAt(j));
						}
					}
					
					orderArr[test] = orderArr[test].replace(before, after);
					
					if(i - before.length()>=0)
					i -= before.length();
					
				}else if((orderArr[test].charAt(i) -'0' >=0 && orderArr[test].charAt(i) -'0' <=9) && orderArr[test].charAt(i+1) != '(') {
					//숫자만 나오는경우
					int cnt = orderArr[test].charAt(i) -'0';
					before = new StringBuilder();
					after = new StringBuilder();
					before.append(orderArr[test].charAt(i));
					before.append(orderArr[test].charAt(i+1));
					for (int j = 0; j < cnt; j++) {
						after.append(orderArr[test].charAt(i+1));
					}
					orderArr[test] = orderArr[test].replace(before, after);
					
					if(i - before.length()>=0)
					i -= before.length();
				}
			}
		}
		 for (int i = 0; i < orderArr.length; i++) {
			System.out.println(orderArr[i]);
		}
		  }

		  private static class InputData {
		    int numOfOrder;
		    String[] orderArr;
		  }

		  private static InputData processStdin() {
		    InputData inputData = new InputData();

		    try (Scanner scanner = new Scanner(System.in)) {
		      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

		      inputData.orderArr = new String[inputData.numOfOrder];
		      for (int i = 0; i < inputData.numOfOrder; i++) {
		        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
		      }
		    } catch (Exception e) {
		      throw e;
		    }

		    return inputData;
		  }

		  public static void main(String[] args) throws Exception {
		    InputData inputData = processStdin();

		    solution(inputData.numOfOrder, inputData.orderArr);
		  }
}
