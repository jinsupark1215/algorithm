package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1431 {

	/*
	 * [백준] 시리얼 번호
	 * 
	 * 1. 정렬 결과
	 * 
	 * 2.
	 * 
	 * 3. 정렬
	 */
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    String [] arr = new String[n];
    
    for(int i=0;i<n;i++) {
        arr[i]=br.readLine();
    }
    
    Arrays.sort(arr,new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length()<o2.length()) {
                return -1;
            }
            else if(o1.length()==o2.length()) {
                if(add(o1)==add(o2)) {
                    return o1.compareTo(o2);
                }
                else {
                    return Integer.compare(add(o1), add(o2));
                }
            }
            else {
                return 1;
            }
            
        }
    });
    for(String i: arr) {
        System.out.println(i);
    }
    
    
}
public static int add(String s) {
    int sum=0;
    for(int i=0;i<s.length();i++) {
        if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
            sum+=s.charAt(i)-'0';
        }
    }
    return sum;
}

}
