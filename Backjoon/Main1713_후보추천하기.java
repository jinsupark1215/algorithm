package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1713_후보추천하기 {

	/*
	 * 1. 최종 후보 N명을 순서대로 출력
	 * 
	 * 2. N <=20, 총 추천 횟수 1000번, 학생번호 1~100
	 * 
	 * 3. 구현
	 * 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
		어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
		비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고,
 		그 자리에 새롭게 추천받은 학생의 사진을 게시한다. 이때, 현재까지 추천 받은 횟수가
  		가장 적은 학생이 두 명 이상일 경우에는 게시된 지 가장 오래된 사진을 삭제한다.
		현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
		사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr= new int[101]; // 추천 횟수
		ArrayList<Integer> list = new ArrayList<Integer>(); //사진틀
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int chk = 0; chk < M; chk++) {
			int num = Integer.parseInt(st.nextToken());
			if(list.size() == N) {	//꽉 찾을 때
				boolean flag = false;
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i) == num) {
						flag = true;
						break;
					}
				}
				if(flag)arr[num]++;		//이미 사진틀에 존재하면 추천횟수만 증가
				else {
				int min = Integer.MAX_VALUE;
				
				// 사진틀에서 추천 횟수가 가장 적은 애찾기
				for (int i = 0; i < N; i++) {
					min = Math.min(min, arr[list.get(i)]);
				}	
				
				//가장 적으면 적은 애를 뽑아내고 
				// 같은 경우에는 먼저 걸려있던 아이를 뽑아냄
					for (int i = 0; i < N; i++) {
						if(arr[list.get(i)] == min) {
							list.remove(i);
							arr[list.get(i)] = 0;
							list.add(num);
							arr[num]++;
							break;
						}
					}
				}
			}else {	// 추천 시 사진틀이 안찾으면 list에 이름 올림
				boolean flag = false;
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i) == num) {
						flag =true;
						break;
					}
				}
				if(flag)arr[num]++;	//이미 존재하면 추천수만 증가
				else {
					list.add(num);	//아니면 사진틀에 올리고 추천수 증가
					arr[num]++;
				}
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
