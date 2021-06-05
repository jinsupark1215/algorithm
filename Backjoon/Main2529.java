package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2529 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] ineq = br.readLine().split(" ");
        int[] MaxNum = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] MinNum = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int temp;

        for (int i = 0; i < k; i++) {
            if (ineq[i].equals("<")) {
                if (MaxNum[i] > MaxNum[i + 1]) {
                    temp = MaxNum[i];
                    MaxNum[i] = MaxNum[i + 1];
                    MaxNum[i + 1] = temp;
                    i=-1;
                }
            }

            else {

            }
        }

        for (int i = 0; i < k; i++) {
            if (ineq[i].equals(">")) {
                if (MinNum[i] < MinNum[i + 1]) {
                    temp = MinNum[i];
                    MinNum[i] = MinNum[i + 1];
                    MinNum[i + 1] = temp;
                    i=-1;
                }
            }

            else {

            }
        }

        for (int i = 0; i < k+1; i++) {
            System.out.print(MaxNum[i]);
        }
        System.out.println();
        for (int i = 0; i < k+1; i++) {
            System.out.print(MinNum[i]);
        }

    }

}