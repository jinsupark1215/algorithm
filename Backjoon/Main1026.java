package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1026 {

    static int N;
    static int A[],B[];
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        A=new int[N];
        B=new int[N];

        int result=0;
        String temp[];
        temp=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(temp[i]);
        }
        temp=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            B[i]=Integer.parseInt(temp[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<B.length;i++){
            result+=A[i]*B[N-1-i];
        }
        System.out.println(result);

    }

}
