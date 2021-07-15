package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11657 {
    static BufferedReader br;
    static StringTokenizer st;
    static int pArr [][];
    static long dist[];
    static long max = 987654321;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        pArr = new int[E][3];
        dist = new long[V+1];
        Arrays.fill(dist, max);

        for(int i = 0; i <E; i ++) {
            st = new StringTokenizer(br.readLine());
            pArr[i][0] = Integer.parseInt(st.nextToken());
            pArr[i][1] = Integer.parseInt(st.nextToken());
            pArr[i][2] = Integer.parseInt(st.nextToken());
        }

        boolean isUpdate = false;
        dist[1] = 0;
        for(int i = 0; i < V; i ++) {
            isUpdate = false;
            for(int j = 0; j < E; j ++) {

                if(dist[pArr[j][0]] == max) {
                    continue;
                }


                if(dist[pArr[j][1]] > dist[pArr[j][0]] + pArr[j][2]) {
                    isUpdate = true;
                    dist[pArr[j][1]] = dist[pArr[j][0]] + pArr[j][2];
                }
            }

            if(!isUpdate) {
                break;
            }
        }

        if(isUpdate) {
            System.out.println(-1);
        }else {
            for(int i = 2; i <=V; i ++) {
                System.out.println(dist[i] == max ? -1 : dist[i] );
            }
        }
    }

}
