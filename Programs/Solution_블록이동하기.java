package Programs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_블록이동하기 {

	/*
	 * [카카오] 블록이동하기 1.N,N까지 이동하는 데 필요한 최소시간
	 * 
	 * 2. 한변의 길이 <=100
	 * 
	 * 3. bfs
	 * 
	 */
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(solution(board));
	}

	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][][] visit;
	static int N;
	static int ans;
	static int[][] nboard;

	static HashSet<Node> check = new HashSet<>();
	static Queue<Node> q = new LinkedList<>();
	public static int solution(int[][] board) {
		ans = 0;
		 N = board.length;
	        nboard = new int[N+2][N+2];
	        
	        //패딩 만들어주기
	        for(int i=0; i<N+2; i++){
	            for(int j=0; j<N+2; j++){
	                if(i==0 || j==0 || i==N+1 || j==N+1){
	                    nboard[i][j] = 1;
	                    continue;
	                }
	                
	                nboard[i][j] = board[i-1][j-1];
	            }
	        }
	        
	        push(1,1,1,2,0);
	        bfs();
	        
	        return ans;
	    }
	    
	    public static void bfs(){
	        int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
	        int[] rotate = {-1,1};
	        
	        while(!q.isEmpty()){
	            Node n = q.poll();
	            int d = n.dist;
	            
	            //도착
	            if((n.x == N && n.y == N) || (n.x2 == N && n.y2 == N)){
	                ans = d - 1;
	                break;
	            }
	            
	            //상하좌우 이동 체크
	            for(int i=0; i<4; i++){
	                int nx = n.x + dir[i][0];
	                int ny = n.y + dir[i][1];
	                int nx2 = n.x2 + dir[i][0];
	                int ny2 = n.y2 + dir[i][1];
	                
	                if(nboard[nx][ny] == 0 && nboard[nx2][ny2] == 0){
	                   push(nx, ny, nx2, ny2, d);
	                }
	            }
	            
	            //가로->세로 회전 체크
	            if(n.x == n.x2){   
	                for(int i=0; i<2; i++){
	                    int nx = n.x + rotate[i];
	                    int ny = n.y;
	                    int nx2 = n.x2 + rotate[i];
	                    int ny2 = n.y2;
	                    
	                    if(nboard[nx][ny] == 0 && nboard[nx2][ny2] == 0){
	                        push(n.x, n.y, nx, ny, d);
	                        push(n.x2, n.y2, nx2, ny2, d);
	                    }
	                }
	            }
	            //세로->가로 회전 체크
	            else{
	                for(int i=0; i<2; i++){
	                    int nx = n.x;
	                    int ny = n.y + rotate[i];
	                    int nx2 = n.x2;
	                    int ny2 = n.y2 + rotate[i];
	                    
	                    if(nboard[nx][ny] == 0 && nboard[nx2][ny2] == 0){
	                        push(n.x, n.y, nx, ny, d);
	                        push(n.x2, n.y2, nx2, ny2, d);
	                    }
	                }
	            }
	        }
	    }
	    
	    public static void push(int x, int y, int x2, int y2, int dist){
	        Node n = new Node(x, y, x2, y2, dist+1);
	        
	        if(check.contains(n)) return;
	        
	        check.add(n);
	        q.offer(n);
	    }
	}
class Node{
    int x;
    int y;
    int x2;
    int y2;
    int dist;
    
    Node(int x, int y, int x2, int y2, int dist){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.dist = dist;
    }
    
    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + x2;
        result = prime * result + y2;
        
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        Node node = (Node)obj;
        if(this.x == node.x && this.y == node.y && this.x2 == node.x2 && this.y2 == node.y2) return true;
        if(this.x == node.x2 && this.y == node.y2 && this.x2 == node.x && this.y2 == node.y) return true;
        
        return false;
    }
}
