package Backjoon;

import java.io.*;

public class Main5582 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] cache = new int[a.length + 1][b.length + 1];

        int max = 0;
        for(int i = 0 ; i < a.length ; ++i) {
            for(int j = 0 ; j < b.length ; ++j) {
                if(a[i] == b[j]) {
                    int ni = i + 1;
                    int nj = j + 1;
                    cache[ni][nj] = cache[i][j] + 1;

                    if(max < cache[ni][nj])
                        max = Math.max(max, cache[ni][nj]);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
}