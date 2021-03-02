package Backjoon;

import java.util.*;
import java.io.*;


public class Main7785 {

    static int n;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        sb=new StringBuilder();
        Set<String> set=new TreeSet<>();
        while(n-->0)
        {
            st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            String a=st.nextToken();
            if(a.equals("enter"))
            {
                set.add(name);
            }
            else
            {
                set.remove(name);
            }
        }

        for(Iterator<String> itr=((TreeSet<String>)set).descendingIterator(); itr.hasNext();) {
            sb.append(itr.next()).append("\n");
        }
        System.out.println(sb.toString());
    }
} 