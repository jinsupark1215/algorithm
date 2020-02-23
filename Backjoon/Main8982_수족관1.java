package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main8982_수족관1 {

	/*
	 * 1. 수족관에 남아있는 물의 양?
	 * 
	 * 2. 범위 <= 40000
	 * 
	 * 3. 구멍을 깊은순서부터  좌 우로 계산 해주기
	 */
	static int[] surface, depth;
	static Node[] hole;
	static int N, K, ans, lastIdx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		ans = 0;
		surface = new int[40001]; // 표면 깊이
		depth = new int[40001]; // 실제 깊이
		
		br.readLine(); // 0,0
		for(int i = 0 ; i < (N / 2) - 1 ; ++i) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			for(int j = sx ; j <= ex ; ++j) {
				depth[j] = sy;
			}
			
			lastIdx = ex - 1;
		}
		br.readLine(); // 마지막
		
		K = Integer.parseInt(br.readLine());

		// 수족관 배수구 데이터 입력 
		hole = new Node[K];
		for(int i = 0 ; i < K ; ++i) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dep = Integer.parseInt(st.nextToken());
			hole[i] = new Node(dep, idx);
		}
		
		for(Node cur : hole) {
			int curDepth = cur.r;
			int col = cur.c;
			
			// 왼쪽으로 갱신 
			for(int i = col ; i >= 0 ; --i) {
				// 현재 깊이를 최소값으로 유지한다. 
				curDepth = curDepth > depth[i] ? depth[i] : curDepth;
				surface[i] = curDepth > surface[i] ? curDepth : surface[i];
			}
			
			curDepth = cur.r;
			col = cur.c;
			
			// 오른쪽으로 갱신 
			for(int i = col ; i <= lastIdx ; ++i) {
				// 현재 깊이를 최소값으로 유지한다. 
				curDepth = curDepth > depth[i] ? depth[i] : curDepth;
				surface[i] = curDepth > surface[i] ? curDepth : surface[i];
			}
			
		}
		
		for(int i = 0 ; i <= lastIdx ; ++i) {
			ans += depth[i] - surface[i];
		}
		
		System.out.println(ans);
	}
	static class Node {
		int r, c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
