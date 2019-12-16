package Programs;

import java.util.Scanner;
import java.util.Stack;

public class Ntech4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 3;
		int k = 2;
		System.out.println(solution(n,k));
	}

	public static int solution(int n, int k) {
        int answer = 2;
        int tmp = (n-1) * (n-1);
        answer = (int) ((((n*n) - nCr(tmp,k))/2)/10007);
        return answer;
    }

	private static long nCr(int tmp, int k) {
		long tmpsum = 1;
		
		for (int i = tmp; i >= tmp-k; i--) {
			tmpsum *= tmp;
		}
		for (int i = 2; i <= k; i++) {
			tmpsum /=i;
		}
		return tmpsum;
	}
}
