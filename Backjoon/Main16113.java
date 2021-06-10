package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16113 {

    static int end;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num;
        br.readLine();
        char[] line = br.readLine().trim().toCharArray();
        end = line.length / 5;
        board = new char[5][end];

        for (int i = 0; i < 5; i++) {
            for (int j = i * end; j < (i + 1) * end; j++) {
                board[i][j - (i * end)] = line[j];
            }
        }

        for (int j = 0; j < end; j++) {
            if (board[0][j] == '#') {
                num = chkNum(j);
                System.out.print(num);
                if (num != 1) j += 2;
            }
        }
        System.out.println();
    }

    static int chkNum(int j) {

        if (board[1][j] == '#' &&
                board[2][j] == '#' &&
                board[3][j] == '#' &&
                board[4][j] == '#') {
            if (j + 1 == end || board[0][j + 1] == '.')
                return 1;
            String temp = "" + board[1][j + 1] + board[2][j + 1] + board[3][j + 1];
            if (temp.equals("..."))
                return 0;
            else if (board[1][j + 2] == '#')
                return 8;
            return 6;
        }

        else if (board[0][j + 2] == '#' &&
                board[1][j + 2] == '#' &&
                board[2][j + 2] == '#' &&
                board[3][j + 2] == '#' &&
                board[4][j + 2] == '#') {

            String temp = "" + board[0][j + 1] + board[1][j + 1] + board[2][j + 1];

            if (temp.equals("..#"))
                return 4;
            else if (temp.equals("#.."))
                return 7;
            else if (board[1][j] == '.')
                return 3;
            return 9;


        }
        else {
            String temp = "" + board[1][j] + board[2][j];
            if (temp.equals("##"))
                return 5;
            return 2;
        }

    }
}
