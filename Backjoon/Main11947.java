package Backjoon;

import java.io.*;

public class Main11947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine().trim());
        for(int i=0;i<t;i++){
            long n=Long.parseLong(br.readLine().trim());
            for(long nine=9;;){
                if(n<=nine){
                    if(n<nine/2){
                        bw.write((long)(nine-n)*n+"\n");
                    }else{
                        bw.write((long)(nine/2)*((nine/2)+1)+"\n");
                    }
                    break;
                }else{
                    nine*=10;
                    nine+=9;
                }
            }
        }
        bw.close();
    }
}
