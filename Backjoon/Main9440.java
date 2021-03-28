package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N;
        int[] arr;

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N == 0)
                break;

            arr = new int[N];
            int numOfZero = 0;
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 0) numOfZero++;
            }
            Arrays.sort(arr);

            int digit = 1;
            int sum = arr[0];
            String a = "";
            String b = "";
            for(int i = 0; i < numOfZero; i++) {
                if(i % 2 == 0) a += "0";
                else b += "0";
            }
            a = arr[numOfZero] + a;
            b = arr[numOfZero + 1] + b;
            for(int j = numOfZero+2; j < N; j++) {
                if(j % 2 == 0) a += arr[j];
                else b += arr[j];
            }
            System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
        }

        br.close();
    }
}
