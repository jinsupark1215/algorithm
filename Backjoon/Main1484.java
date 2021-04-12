package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1484 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());

        long start = 1;
        long end = 1;

        List<Long> list = new ArrayList<>();

        while(end <= 50001) {
            if(end * end - start * start == g) {
                list.add(end);
            }

            if(end * end - start * start <= g) {
                end++;
            }
            else {
                start++;
            }
        }

        if (list.size() == 0) {
            bw.write("-1");
        }
        else {
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}