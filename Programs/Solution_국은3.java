package Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_국은3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList[] list = new ArrayList[N+1];
		boolean[] visit = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int ans = 0;
		
		//이렇게 1번 보장되이썼는지 아닌지 생각이 안남 - 틀렸을꺼같은 부분
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				visit[i] = true;
				int cnt = 0;
				
				while(true) {
					int size = q.size();
					
					for (int j = 0; j < size; j++) {
						int e = q.poll();

						for (int k = 0; k < list[e].size(); k++) {
							if (!visit[(int) list[e].get(i)]) {
								visit[(int) list[e].get(i)] = true;
								q.add((int) list[e].get(i));
							}
						}
					}
					if(q.size() == 0)break;
					cnt++;
				}
				
				ans += cnt;
			}
		}
		
		
		
		
		System.out.println(ans);
		
	}
}
