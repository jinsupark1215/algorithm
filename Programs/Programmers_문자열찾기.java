package Programs;

import java.util.Scanner;

public class Programmers_문자열찾기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String a = "JAN";
		System.out.println(solution(a));
	}
	 public static int solution(String name) {
	        int ans = 0;
	        int len = name.length();
	        int moveCount = name.length() - 1;

	        for(int i=0; i<len; i++){
	            char target = name.charAt(i);
	            if(target < 'N') 
	                ans += target - 'A';
	            else
	                ans += 91 - target;
	            //������� ���Ʒ��� �����̴°� ���亪 N�� �������� ��� ����

	            int right = i + 1;
	            while(right<len && name.charAt(right) == 'A')
	            	right++;
	            //���������� ���鼭 A�� �׳� �Ѿ�鼭 �̵��ϴ� ���
	            
	            int b = i + len - right + Math.min(i, len - right);
	            // i ��ŭ �������� �����̰�, len-right = �� ������ �����ϴ� ����, ������ ���� �� ª�� �Ÿ�
	            moveCount = Math.min(moveCount, b);
	            
	            System.out.println(ans);
	            
	        }
	        ans += moveCount;
	        
	        
	        return ans;
	    }
}
