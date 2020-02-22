package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2246_콘도선정 {

	/*
	 * 1. 후보가 될 수 있는 콘도의 수
	 * 
	 * 2. N <= 10000
	 * 
	 * 3. 거리비례로 정렬 후 비싼 가격 순으로 정렬하고 비싼지  싼지 판단
	 */
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//콘도의 갯수
		int N = Integer.parseInt(br.readLine());

		int[][] condo = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			//D 바닷가로부터의 거리
			condo[i][0] = Integer.parseInt(st.nextToken());
			//C 숙박비
			condo[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		X보다 바닷가에 더 가까운 콘도들은 모두 X보다 숙박비가 더 비싸다.
//		X보다 숙박비가 더 싼 콘도들은 모두 X보다 바닷가에서 더 멀다.
		int ans = 0;
		
		//거리가 먼 순으로 정렬 //거리가 가까우면 숙박비가 싼순으로 정렬
		Arrays.sort(condo,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]) return (o1[0]-o2[0])*(-1);
				else return o1[1]-o2[1];
			}
			
		});
		
		
		int tmp = 0;
		
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			if(tmp!=condo[i][0]){
				for (int j = i+1; j < N; j++) {
					if(condo[i][1] >= condo[j][1]) {
						flag = false;
						break;
					}
				}
				if(flag){
					ans++;
				}
			}
			tmp = condo[i][0];
		}
		
		System.out.println(ans);

	}

}
