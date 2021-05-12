package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        long newScore = Long.parseLong(str[1]);
        int P = Integer.parseInt(str[2]);

        long[] list = new long[P];

        if (N != 0) {
            str = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) list[i] = Long.parseLong(str[i]);
        }

        int rank = 1;
        if(N==P && list[N-1] >= newScore) rank = -1;
        else{
            for(int i=0; i<N;i++) if(list[i]>newScore) rank++;
        }
        System.out.println(rank);
    }
}