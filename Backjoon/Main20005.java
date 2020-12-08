package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main20005 {

	/*
	 * [백준] 보스몬스터 전리품
	 * 
	 * 1. 전리품 가져가는 플레이어 최대 수
	 * 
	 * 2. 
	 * 
	 * 3. 다익스트라, bfs
	 */
	static boolean visit[][];
	static int m,n,p,hp,dir[][]= {{-1,0},{0,1},{1,0},{0,-1}},sx,sy,result;
	static String map[];
	static HashMap<Character,Integer> h;
	static Queue<catc> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		p=Integer.parseInt(st.nextToken());
		map=new String[m];
		visit=new boolean[m][n];
		h=new HashMap<Character,Integer>();
		q=new LinkedList<catc>();	
		for(int i=0;i<m;i++) {
			map[i]=br.readLine();
			for(int j=0;j<n;j++) {
				if(map[i].charAt(j)=='B') {
					sx=i;
					sy=j;
				}
			}
		}
		for(int i=0;i<p;i++) {
			st = new StringTokenizer(br.readLine());
			char ID=st.nextToken().charAt(0);
			int dps=Integer.parseInt(st.nextToken());
			h.put(ID, dps);
		}
		hp=Integer.parseInt(br.readLine());
		bfs();//각각의 시간을 알기위해서
		find();
		
	}
	private static void find() {
		// TODO Auto-generated method stub
		result++;
		int sum=0;
		catc ftime=q.remove();
		sum+=h.get(ftime.name);
		while(!q.isEmpty()&&q.peek().time==ftime.time) {
			result++;
			ftime=q.remove();
			sum+=h.get(ftime.name);
		}
		while(!q.isEmpty()) {
			int can=0;
			int si=0;
			catc next=q.remove();
			can+=h.get(next.name);
			si++;
			while(!q.isEmpty()&&q.peek().time==next.time) {
				next=q.remove();
				can+=h.get(next.name);
				si++;
			}
			hp-=(sum*(next.time-ftime.time));
			sum+=can;
			ftime=next;
			if(hp<0) {
				break;
			}
			else {
				result+=si;
			}
			
		}
		System.out.println(result);
		
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<time> qu=new LinkedList<time>();	
		qu.add(new time(sx,sy,0));
		visit[sx][sy]=true;
		while(!qu.isEmpty()) {
			time next=qu.remove();
			for(int i=0;i<4;i++) {
				int x=next.x+dir[i][0];
				int y=next.y+dir[i][1];
				if(x<0||x>=m||y<0||y>=n)
					continue;
				if(visit[x][y]||map[x].charAt(y)=='X')
					continue;
				visit[x][y]=true;
				if(map[x].charAt(y)>='a'&&map[x].charAt(y)<='z') {
					q.add(new catc(map[x].charAt(y),next.t+1));
				}
				qu.add(new time(x,y,next.t+1));
			}
		}
		
	}
	
	public static class time{
		int x;
		int y;
		int t;
		public time(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
		
	}
	public static class catc{
		char name;
		int time;
		public catc(char name,int time) {
			super();
			this.time = time;
			this.name = name;
		}
		
	}

}