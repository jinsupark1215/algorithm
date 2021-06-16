package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main18222 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n =Long.parseLong(br.readLine());

        n--;
        int cnt=0;
        while(n!=0) {
            if(n%2==1) {
                cnt++;
            }
            n/=2;
        }

        cnt=cnt%2;
        System.out.println(cnt);
    }

}
