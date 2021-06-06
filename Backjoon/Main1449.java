package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1449 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()) - 1;

        int tapes = 0;
        int[] leak = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            leak[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leak);

        for(int i = 0; i < N; i++) {
            int tmp=0;
            tapes++;

            for(int j = i + 1; j < N; j++) {
                if(leak[i] + L >= leak[j]) tmp++;
                else break;
            }
            i += tmp;
        }

        System.out.println(tapes);
    }
}
