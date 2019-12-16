package Programs;

import java.util.Scanner;

public class Ntech1 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int a = 3000;
		int b = 5000;
		int budget = 23000;
		System.out.println(solution(a,b,budget));
	}
	
	public static int solution(int a, int b, int budget) {
        int answer = 0;
        
        if(a>b) {
        	int idx = 0;
        	while((a * idx)<=budget) {
        		int tmp = budget-(a*idx);
        		if(tmp%b ==0)answer++;
        		idx++;
        	}
        }else {
        	int idx = 0;
        	while((b * idx)<=budget) {
        		int tmp = budget-(b*idx);
        		if(tmp%a ==0)answer++;
        		idx++;
        	}
        }
        return answer;
    }
}
