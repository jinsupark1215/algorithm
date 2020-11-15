package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_마닷하3 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1,4,2,6,5,3}, 2)));
		
	}

	public static int[] solution(int[] cookies, int k) {
		int[] ans = new int[1];
	    int n = cookies.length;

	    int[] a= new int[n+1];
	    for(int i=1;i<=n;i++){
	        a[i] = cookies[i-1];
	    }

	    int[] dp = new int[n+1];
	    long[] cnt = new long[n+1];

	    for(int i=n;i>=1;i--){
	        dp[i]=1;
	        cnt[i]=1;
	        for(int j=i+1;j<=n;j++){
	            if(a[i]<a[j]){
	                if(dp[i]<dp[j]+1){
	                    dp[i]=dp[j]+1;
	                    cnt[i]=cnt[j];
	                }
	                else if(dp[i]==dp[j]+1){
	                    cnt[i]+=cnt[j];
	                }
	                if(cnt[i]>=100000001){
	                    cnt[i]=100000001;
	                }
	            }
	        }
	    }
	    
	    int len = 0;
	    for (int i = 0; i < dp.length; i++) {
			len = Math.max(len, dp[i]);
		}

	    int start=0;
	    ArrayList<Integer> answ = new ArrayList<>();
	    while(len>0){
	        int checking_starting_point=-1;
	        long sum=0;
	        List<Node> checker = new ArrayList<>();
	        for(int i=start+1;i<=n;i++){
	            if( (a[start]<a[i]) && (dp[i]==len) ){
	                checker.add(new Node(a[i],i));
	            }
	        }
	        Collections.sort( checker);
	        for(Node p: checker){
	            int curcheck=p.b;
	            sum+=cnt[curcheck];
	            if(k<=sum){
	                answ.add(a[curcheck]);
	                checking_starting_point=curcheck;
	                k-= (sum-cnt[curcheck]);
	                break;
	            }
	        }
	        start=checking_starting_point;
	        len--;
	    }

	    ans = new int[answ.size()];
	    for (int i = 0; i < ans.length; i++) {
			ans[i] = answ.get(i);
		}

	    return ans;
    }
	static class Node implements Comparable<Node>{
		int a,b;

		public Node(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Node o) {
			if(this.a == o.a)return -o.b;
			return -o.a;
		}
		
	}
}
