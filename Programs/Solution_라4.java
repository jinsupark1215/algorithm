package Programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_라4 {

	public static void main(String[] args) {
		int[][] maze = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
		System.out.println(solution(maze));
	}

	static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
	static int ans;
	private static int solution(int[][] maze) {
		ans = 0;
		
		if(maze[1][0] ==0) {
			dfs(maze,0,0,0,0,1);
		}else if(maze[0][1] == 0) {
			dfs(maze,0,0,0,1,2);
		}
        return ans;
	}
	private static void dfs(int[][] map, int r, int c,int cnt, int dir, int left) {
		if(r== map.length-1 && c == map.length-1) {
			ans = cnt;
		}else {
			int nr = r + pos[left][0];
			int nc = c + pos[left][1];
			if(nr<0 || nc<0 || nr>= map.length || nc >= map.length || map[nr][nc] ==1) {
				nr = r + pos[dir][0];
				nc = c + pos[dir][1];
				while(true) {
					if(nr>=0 && nc>=0 && nr< map.length && nc < map.length&&map[nr][nc] == 0) {
						break;
					}
					dir--;;
					dir = dir ==-1? 3 : dir;
					left = dir+1;
					left = left==4? 0 : left;
					nr = r + pos[dir][0];
					nc = c + pos[dir][1];
				}
				dfs(map,nr,nc,cnt+1,dir,left);
			}else {
				if(map[nr][nc] == 0) {
				dfs(map,nr,nc,cnt+1,left,(left+1)%4);
				}
			}
		}
	}
}
