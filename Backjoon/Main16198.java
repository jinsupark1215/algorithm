package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16198 {
    static boolean[] check;
    static int[] nums;
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        check = new boolean[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0, 0);
        System.out.println(max);
    }
    public static void backtrack(int sum, int cnt) {
        if(cnt == n-2) {
            max = Math.max(max, sum);
            return;
        }
        for(int i=1; i<n-1; i++) {
            if(!check[i]) {
                check[i] = true;
                int a;
                int b;
                for(a=i-1; a>=0; a--) {
                    if(!check[a]) break;
                }
                for(b=i+1; b<n; b++) {
                    if(!check[b]) break;
                }
                backtrack(sum+(nums[a]*nums[b]), cnt+1);
                check[i] = false;
            }
        }
    }
}
