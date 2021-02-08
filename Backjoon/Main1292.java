package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cur = 1;
        for(int i = 1; i <= 1000; i++){
            for(int j = 1; j <= cur; j++){
                if(i > 1000) break;
                arr[i] = cur;
                i++;
            }
            cur++;
            i--;
        }
        int ans = 0;
        for(int i = A; i <= B; i++){
            ans += arr[i];
        }
        bw.write(ans + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
