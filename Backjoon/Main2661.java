package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2661 {
    static int n;
    static String result="";
    static boolean success=false;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine().trim());

        go(0,"");
        System.out.println(result);
    }

    public static void go(int round, String s){
        for(int i=1 ; i<=(round)/2 ; i++){
            if(s.substring(round-i,round).equals(s.substring(round-2*i,round-i))) return;
        }

        if(round==n){
            result=s;
            success=true;
            return;
        }

        for(int i=1 ; i<=3 ; i++){
            go(round+1, s+i+"");
            if(success) return;
        }
    }
}
