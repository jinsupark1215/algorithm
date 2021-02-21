package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main13414 {
    /*
    [백준] 수강신천
    1. 규칙적용

    2.

    3. set
     */
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int i, k = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> hs = new LinkedHashSet<>();
        String tmp;
        for(i=0;i<l;i++){
            tmp = in.readLine();
            if(hs.contains(tmp)) hs.remove(tmp);
            hs.add(tmp);
        }
        Iterator<String> it = hs.iterator();
        while(it.hasNext()){
            out.write(it.next());
            out.newLine();
            if(--k<1) break;
        }
        out.close();
        in.close();
    }
}
