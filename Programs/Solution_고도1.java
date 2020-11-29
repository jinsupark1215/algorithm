package Programs;

public class Solution_고도1 {

	public static void main(String[] args) {
		int[] goods = {46,62,9};
		System.out.println(solution(goods));
	}

	private static int solution(int[] goods) {
		int ans = 0;
		
		//50달러 이상인 것들 찾기
		for (int i = 0; i < goods.length; i++) {
			if(goods[i] >= 50)ans+=goods[i]-10;
		}
		
		//50달러 이하인 것들이 합쳤을 떄 50달러인지
		int tmp = 0;
		for (int i = 0; i < goods.length; i++) {
			if(goods[i] < 50)tmp +=goods[i];
		}
		//합친 것이 50이상이면 할인 아니면 노할인
		if(tmp >= 50)ans+=tmp-10;
		else ans+=tmp;
		
		return ans;
	}
}
