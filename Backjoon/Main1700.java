package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1700 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] ar = new int[k];

        input = br.readLine().split(" ");

        for(int i=0 ; i<k ; i++){
            ar[i] = Integer.parseInt(input[i]);
        }

        System.out.print(solve(n,ar));
    }
    static public int solve(int n, int[] schedule){

        int k = schedule.length;

        int[] tab = new int[n];

        int last = -1;
        int count = 0;

        fin:
        for(int i=0 ; i<k ; i++){
            int now = schedule[i];
            for(int j=0 ; j<=last ; j++){
                if(tab[j]==now) continue fin;
            }
            if(last<n-1 && tab[last+1]==0) tab[++last] = now;
            else{
                if(i==k-1){
                    count++;
                    break fin;
                }
                int maxI = -1;
                int toChange = -1;
                for(int j=0 ; j<n ; j++){
                    int check = 0;
                    for(int z=i+1 ; z<k ; z++){
                        if(tab[j]==schedule[z]) {
                            check++;
                            if(z>maxI){
                                maxI = z;
                                toChange = j;
                            }
                            break;
                        }
                    }
                    if(check==0){
                        maxI = 101;
                        toChange = j;
                        break;
                    }
                }
                count++;
                tab[toChange] = now;
            }
        }
        return count;
    }
}
