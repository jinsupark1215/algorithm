package Backjoon;

import java.io.*;
import java.util.*;

public class Main3649 {
    static int n, m;
    static int d[] = new int[1000001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        while (br.ready()) {
            m = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            m *= 10000000;

            for (i = 1; i <= n; i++)
            {
                d[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(d,1,n+1);

            int l = 1, r = n;

            while (l < r)
            {
                if (d[l] + d[r] > m)r--;
                else if (d[l] + d[r] < m)l++;

                if (d[l] + d[r] == m && l != r)
                {
                    System.out.println("yes "+d[l]+" "+d[r]);
                    break;
                }
            }
            if(l>=r) System.out.println("danger");
        }
    }
}
