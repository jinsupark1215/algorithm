package Programs;

import java.util.Scanner;

public class Ntech2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		long n = 2322;
		System.out.println(solution(n));
	}
	
	public static int solution(long n) {
        int answer = 0;

        int[] arr = new int[10];
        long tmp = n;
        while(tmp>0) {
        	arr[(int) (tmp%10)]++;
        	tmp /= 10;
        }
        for (int i = 1; i < 10; i++) {
			if(arr[i] !=0) {
				if(n%i ==0) {
					answer++;
				}
			}
		}
        return answer;
    }
}
