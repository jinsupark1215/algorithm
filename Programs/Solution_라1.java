package Programs;

public class Solution_라1 {

	public static void main(String[] args) {
		int[][] boxes = {{1,2},{2,1},{3,3},{4,5},{5,6},{7,8}};
		System.out.println(solution(boxes));
	}

	private static int solution(int[][] boxes) {
		int ans = 0;
		int[] num = new int[1000001];
		
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < 2; j++) {
				num[boxes[i][j]]++;
			}
		}
		
		for (int i = 1; i < num.length; i++) {
			if(num[i] %2 !=0)ans++;
		}
		ans/=2;
		
        return ans;
	}
}
