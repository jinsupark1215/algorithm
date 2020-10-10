package Programs;

import java.util.Arrays;

public class Solution_쿠2 {

	public static void main(String[] args) {
		int n = 3;
		String[] customers = {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
		System.out.println(solution(n, customers));
	}

	static int[] month = {0,31,59,90,120,151,181,212, 243, 273, 304, 334};
	public static int solution(int n, String[] customers) {

		int ans = 0;
		
		Kiosk[] kiosk = new Kiosk[n];
		for (int i = 0; i < n; i++) {
			kiosk[i] = new Kiosk(false, 0, 0, 0);
		}
		//시간
		for (int i = 0; i < customers.length; i++) {
			int mon =Integer.parseInt(customers[i].substring(0, 2));
			int d = Integer.parseInt(customers[i].substring(3, 5));
			
			int h = Integer.parseInt(customers[i].substring(6, 8));
			int min = Integer.parseInt(customers[i].substring(9, 11));
			int s = Integer.parseInt(customers[i].substring(12, 14));
			
			int during = Integer.parseInt(customers[i].substring(15, 17));
			
			int date = month[mon] + d;
			int time = s + (min*60) + (h*60*60);
			int end = time + (during*60);
			
			int cnt = 0;
			int idx = 0;
			int min_date = Integer.MAX_VALUE;
			int min_time = Integer.MAX_VALUE;
			
			for (int j = 0; j < n; j++) {
				if(kiosk[j].date <date || (kiosk[j].date == date && kiosk[j].time <= time)) {
					kiosk[j].flag = false;
				}
			}
			
			for (int j = n-1; j >=0; j--) {
				if(kiosk[j].flag) {
					cnt++;
				}
				if(!kiosk[j].flag) {
					if(min_date >= kiosk[j].date || (min_date == kiosk[j].date && min_time >= kiosk[j].time)) {
						min_date = kiosk[j].date;
						min_time = kiosk[j].time; 
						idx = j;
					}
				}
			}
			if(cnt == n) {
				for (int j = n-1; j >=0; j--) {
					if(!kiosk[j].flag) {
						if(min_date >= kiosk[j].date || (min_date == kiosk[j].date && min_time >= kiosk[j].time)) {
							min_date = kiosk[j].date;
							min_time = kiosk[j].time; 
							idx = j;
						}
					}
				}
				kiosk[idx].flag = true;
				kiosk[idx].cnt = kiosk[idx].cnt+1;
				kiosk[idx].date = date;
				kiosk[idx].time = end;
			}else {
				
				kiosk[idx].flag = true;
				kiosk[idx].cnt = kiosk[idx].cnt+1;
				kiosk[idx].date = date;
				kiosk[idx].time = end;
			}
		}
		
		for (int i = 0; i < n; i++) {
			ans = ans <kiosk[i].cnt ? kiosk[i].cnt : ans;
		}
		
		return ans;
	}
	static class Kiosk{
		boolean flag;
		int cnt,date,time;
		
		public Kiosk(boolean flag, int cnt, int date, int time) {
			super();
			this.flag = flag;
			this.cnt = cnt;
			this.date = date;
			this.time = time;
		}
	}
}
