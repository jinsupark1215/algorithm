package Programs;

public class Solution_자물쇠와열쇠 {

	public static void main(String[] args) {
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		
		System.out.println(solution(key,lock));
	}

	private static boolean solution(int[][] key, int[][] lock) {
		boolean ans = false;
		int[][] map = new int[lock.length+key.length-1+key.length-1][lock.length+key.length-1+key.length-1];
		int r=0,c=0;
		int cnt = 0;
		
		fin:
			for (int turn = 0; turn < 4; turn++) {
				
		for (int i = 0; i < map.length-key.length+1; i++) {
			jin:
			for (int j = 0; j < map.length-key.length+1; j++) {
				map = new int[lock.length+key.length-1+key.length-1][lock.length+key.length-1+key.length-1];
				r = 0;
				c = 0;
				cnt = 0;
				//자물쇠 칠하기 - 가운데
				for (int k = key.length-1; k < key.length+lock.length-1; k++) {
					for (int l = key.length-1; l < key.length+lock.length-1; l++) {
						map[k][l] = lock[r][c];
						c++;
					}
					r++;
					c=0;
				}
				
				r=0;
				c=0;
				//열쇠 칠하기
				for (int k = i; k < i+key.length; k++) {
					for (int l = j; l < j+key.length; l++) {
						if(map[k][l] == 0 && key[r][c] == 1)map[k][l] = 1;
						else if(map[k][l] == 1 && key[r][c] ==1)continue jin;
						c++;
					}
					r++;
					c=0;
				}
				
				//가운데
				for (int k = key.length-1; k < key.length+lock.length-1; k++) {
					for (int l = key.length-1; l < key.length+lock.length-1; l++) {
						if(map[k][l] ==1)cnt++;
					}
				}
				if(cnt== lock.length*lock.length) {
					ans = true;
					break fin;
				}
			}
		}
		
		//회전
		int[][] tmp = new int[key.length][key.length];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				tmp[j][key.length - i - 1] = key[i][j];
			}
		}
		key = tmp;
		
			}
		return ans;
	}
}
