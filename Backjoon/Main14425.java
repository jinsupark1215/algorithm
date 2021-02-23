package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main14425 {
    /*
    [백준] 문자열집합

    1. 문자열 중 총 몇개가 있는지

    2.

    3. Hashset 이용용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(br.readLine());
        int count = 0;
        for(int i = 0; i < m; i++)
            if(set.contains(br.readLine()))
                count++;

        System.out.println(count);
    }
}
