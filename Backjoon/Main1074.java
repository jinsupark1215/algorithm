package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1074 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] reader=new String[3];
        reader=br.readLine().split(" ");
        int n=Integer.parseInt(reader[0]);
        long r=Long.parseLong(reader[1]);
        long c=Long.parseLong(reader[2]);
        int[] bin=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            bin[i]=(int)(2*(r%2)+(c%2));
            r=r/2;
            c=c/2;
        }
        for(int i=0;i<n;i++){
            count=count*4+bin[n-1-i];
        }
        System.out.print(count);

    }
}
