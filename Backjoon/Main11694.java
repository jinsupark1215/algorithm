package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main11694 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int input[] = new int[N];

        boolean flag = false;
        int num = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());

            if (input[i] != 1) {
                flag = true;
            } else {
                num++;
            }
        }

        if (!flag) {
            bw.write((num % 2 == 1) ? "cubelover" : "koosaga");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            result ^= input[i];
        }

        if (num != 0) {
            if (num % 2 == 1 && result != 0) {
                bw.write("koosaga");
            } else if (num % 2 == 1 && result == 0) {
                bw.write("cubelover");
            } else if (num % 2 == 0) {

                for (int i = 0; i < N; i++) {
                    if (input[i] != 1) {
                        input[i] = 1;
                        break;
                    }
                }

                result = 0;
                for (int i = 0; i < N; i++) {
                    result ^= input[i];
                }

                if (result != 0) {
                    bw.write("koosaga");
                } else {
                    bw.write("cubelover");
                }
            }
        } else {
            bw.write((result != 0) ? "koosaga" : "cubelover");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
