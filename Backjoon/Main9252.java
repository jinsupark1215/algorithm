package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9252 {
    /*
    [백준] LCS 2
    1. 길이와 lcs 출력

    2.

    3. lcs
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        a = "0" + a;
        b = "0" + b;

        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int[][] lcs = new int[str1.length][str2.length];

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if(str1[i]==str2[j]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        System.out.println(lcs[str1.length-1][str2.length-1]);

        StringBuffer sb = new StringBuffer();


        int i=str1.length-1;
        int j=str2.length-1;
        while(lcs[i][j] != 0){
            if(lcs[i][j]==lcs[i-1][j]){
                i--;
            }else if (lcs[i][j]==lcs[i][j-1]){
                j--;
            }else if(lcs[i][j]-1 == lcs[i-1][j-1]){
                sb.append(str1[i]);
                i--;
                j--;
            }
        }

        System.out.println(sb.reverse());
    }
}
