package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_국은4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N];
		int[] buy = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			buy[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(money);
		Arrays.sort(buy);
		
		
		//돈인덱스
		int myidx = N-1;
		//물품인덱스
		int youridx = 0;
		//명수
		int ans1 = 0;
		//최소가격
		int ans2 = 0;
		while(myidx >0) {
			if(money[myidx] >= buy[youridx]) {
				ans1++;
				ans2 += money[myidx];
				myidx--;
				youridx++;
			}else {
				if(B !=0 && money[myidx] +B >= buy[youridx]) {
					ans1++;
					ans2 += money[myidx];
					B -= buy[youridx] - money[myidx];
					myidx--;
					youridx++;
				}else {
					myidx--;
				}
			}
		}
		
		System.out.println(ans1 +" " + ans2);
	}
}
