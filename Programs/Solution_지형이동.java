package Programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_지형이동 {

	public static void main(String[] args) {
	int height = 3;
	int[][] land = {{1,4,8,10},{5,5,5,5},{10,10,10,10},{10,10,10,20}};
		
		System.out.println(solution(land, height));
	}

	static int[] parent;
    public static int solution(int[][] land, int height) {
        int answer = 0;
        
        int N = land.length;
        int idx= 1;
        int[][] visit = new int[N][N];
        int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
        
        //군집화
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visit[i][j] ==0){
                    
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visit[i][j] = idx;
                    
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        
                        
                        for(int k =0; k < 4; k++){
                            int nr = cur[0] + pos[k][0];
                            int nc = cur[1] + pos[k][1];
                            if(nr>=0 && nr < N && nc>=0 && nc< N && visit[nr][nc] ==0 && Math.abs(land[cur[0]][cur[1]] - land[nr][nc]) <= height ){
                                visit[nr][nc] = idx;
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                    
                    idx++;
                }
            }
        }
        
        //사다리 놓을 수 있는 곳 판단
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        boolean[][] chk = new boolean[N][N];
        
        for(int i =0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k =0; k < 4; k++){
                            int nr = i + pos[k][0];
                            int nc = j + pos[k][1];
                            if(nr>=0 && nr < N && nc>=0 && nc< N && !chk[nr][nc] && visit[nr][nc] != visit[i][j] && Math.abs(land[i][j] - land[nr][nc]) > height ){
                                chk[i][j] = true;
                                pq.add(new int[] {visit[i][j], visit[nr][nc],Math.abs(land[i][j] - land[nr][nc])});
                            }
                        }
            }
        }
        
        //dis join
        parent = new int[idx+1];
        for(int i = 1; i <= idx; i++){
            parent[i] = i;
        }
        
        int size = pq.size();
        for(int i =0; i <size; i++){
            int[] cur = pq.poll();
            int start = cur[0];
            int end = cur[1];
            int a = find(start);
            int b = find(end);
            if(a == b)continue;
            
            union(start,end);
            answer+=cur[2];
        }
        
        return answer;
    }
    public static int find(int a){
        if(a==parent[a])return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }
    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            parent[aRoot] = b;
        }else{
            return;
        }
    }
}
