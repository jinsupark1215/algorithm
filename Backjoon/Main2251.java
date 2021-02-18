package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2251 {

    /*
    [백준] 물통

    1. 각 용량을오름차순으로

    2,

    3. dfs
     */
    public static int[] input,state;

    public static boolean[] visit;

    public static boolean[][] dist;

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[3];
        state = new int[3];
        for(int i=0;i<3;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        dist = new boolean[input[0]+1][input[1]+1];
        visit = new boolean[input[2]+1];
        state[2] = input[2];
        dfs();
        for(int i=0;i<=input[2];i++){
            if(visit[i]){
                System.out.print(i+" ");
            }
        }
    }

    public static void dfs(){
        dist[state[0]][state[1]] = true;
        if(state[0] == 0){
            visit[state[2]] = true;
        }
        for(int i=0;i<3;i++){
            for(int j=1;j<=2;j++){
                int next = (i+j)%3;
                if(state[i] == 0 && state[next] == input[next]){
                    continue;
                }
                int temp = 0;
                if(input[next]-state[next]>=state[i]){
                    temp = state[i];
                }else{
                    temp = input[next]-state[next];
                }
                state[i] = state[i]-temp;
                state[next] = state[next]+temp;
                if(!dist[state[0]][state[1]]){
                    dfs();
                }
                state[next] = state[next]-temp;
                state[i] = state[i]+temp;

            }
        }
    }
}
