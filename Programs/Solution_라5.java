package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_라5 {

	public static void main(String[] args) {
		int[] cards = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		System.out.println(solution(cards));
	}

	private static int solution(int[] cards) {
		int ans = 0;
		
		
		int idx = 0;
		fin:
		while(idx < cards.length) {
			int chk = 4;
			int player = 0;
			int dil = 0;
			ArrayList<Integer> list = new ArrayList<>();
			
			player += cards[idx] > 10 ? 10 : cards[idx]; 
			player += cards[idx+2] > 10 ? 10 : cards[idx+2];
			dil += cards[idx+1] > 10 ? 10 : cards[idx+1];
			dil +=cards[idx+3] > 10 ? 10 : cards[idx+3];
			list.add(cards[idx+1] > 10 ? 10 : cards[idx+1]);
			list.add(cards[idx+3] > 10 ? 10 : cards[idx+3]);
			
			if(cards[idx] == 1 || cards[idx+2] == 1) {
				player +=10;
			}
			if(cards[idx+1] == 1 || cards[idx+3] == 1) {
				dil +=10;
			}
			
			if (player == 21) {
				ans += 3;
			} else if (player < 21) {
				if(list.contains(4) || list.contains(5) || list.contains(6)) {
					while(dil <17) {
						dil += cards[idx+chk] > 10 ? 10 : cards[idx+chk];
						chk++;
						if(idx+chk == cards.length)break fin;
					}
					if(dil >21 || player > dil) {
						ans+=2;
					}else if (player < dil) {
						ans -= 2;
					}
				}else if(list.contains(2) || list.contains(3)) {
					while(player < 12) {
						player += cards[idx+chk] > 10 ? 10 : cards[idx+chk];
						chk++;
						if(idx+chk == cards.length)break fin;
					}
					while(player < 17) {
						player += cards[idx+chk] > 10 ? 10 : cards[idx+chk];
						chk++;
						if(idx+chk == cards.length)break fin;
					}
					if(player > dil) {
						ans+=2;
					}else if (player > 21 ||player < dil) {
						ans -= 2;
					}
				}else {
					while(player < 17) {
						player += cards[idx+chk] > 10 ? 10 : cards[idx+chk];
						chk++;
						if(idx+chk == cards.length)break fin;
					}
					if(player > dil) {
						ans+=2;
					}else if (player > 21 ||player < dil) {
						ans -= 2;
					}
				}
			} else {
				ans -= 2;
			}
			
			idx += chk;
		}
        return ans;
	}
}
