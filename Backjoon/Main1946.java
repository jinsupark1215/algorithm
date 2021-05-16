package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int [N+1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            int temp = arr[1];
            for (int i = 2; i <= N; i++) {
                if(temp<arr[i]) {
                    cnt++;
                }else {
                    temp = arr[i];
                }
            }

            System.out.println(N-cnt);

        }
    }
}
