package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main20949 {

    static class Monitor implements Comparable<Monitor> {
        int index;
        long ppi;

        Monitor(int index, long ppi) {
            this.index = index;
            this.ppi = ppi;
        }

        @Override
        public int compareTo(Monitor m) {
            if (this.ppi == m.ppi) {
                return this.index - m.index;
            } else {
                return (int) (m.ppi - this.ppi);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N;
        Monitor[] monitors;

        N = Integer.parseInt(br.readLine());
        monitors = new Monitor[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long w = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            long ppi = w * w + h * h;
            monitors[i] = new Monitor(i + 1, ppi);
        }

        Arrays.sort(monitors);

        for (Monitor ppi : monitors)
            bw.write(ppi.index + "\n");
        bw.flush();
    }
}
