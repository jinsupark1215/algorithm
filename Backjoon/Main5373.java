package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5373 {
    static int U[] = { 17, 16, 15, 14, 13, 12, 11, 10, 9, 51, 52, 53 };
    static int F[] = { 6, 7, 8, 15, 24, 33, 38, 37, 36, 29, 20, 11 };
    static int D[] = { 27, 28, 29, 30, 31, 32, 33, 34, 35, 47, 46, 45 };
    static int B[] = { 42, 43, 44, 35, 26, 17, 2, 1, 0, 9, 18, 27 };
    static int L[] = { 0, 3, 6, 12, 21, 30, 36, 39, 42, 45, 48, 51 };
    static int R[] = { 53, 50, 47, 44, 41, 38, 32, 23, 14, 8, 5, 2 };

    static int white[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
    static int red[] = { 12, 13, 14, 21, 22, 23, 30, 31, 32 };
    static int yellow[] = { 36, 37, 38, 39, 40, 41, 42, 43, 44 };
    static int orange[] = { 45, 46, 47, 48, 49, 50, 51, 52, 53 };
    static int green[] = { 9, 10, 11, 18, 19, 20, 27, 28, 29 };
    static int blue[] = { 15, 16, 17, 24, 25, 26, 33, 34, 35 };

    static char cubue[] = new char[54];

    public static void rotate(char c) {
        int seq[] = null;
        int r[] = null;
        switch (c) {
            case 'U':seq = U;r = white;break;
            case 'F':seq = F;r = red;break;
            case 'D':seq = D;r = yellow;break;
            case 'B':seq = B;r = orange;break;
            case 'L':seq = L;r = green;break;
            case 'R':seq = R;r = blue;break;
        }
        // 정방향이므로 3칸식 이동하기
        char tmp[] = new char[12];
        for(int i=0;i<12;i++) {
            tmp[i] = cubue[seq[i]];
        }

        for (int i = 0; i < 12; i++) {
            cubue[seq[i]] = tmp[(i+9)%12];
        }

        // 9개 회전시키기
        tmp = new char[9];
        for(int i=0;i<9;i++) {
            tmp[i] = cubue[r[i]];
        }

        cubue[r[0]] = tmp[6]; cubue[r[1]] = tmp[3]; cubue[r[2]] = tmp[0];
        cubue[r[3]] = tmp[7]; cubue[r[4]] = tmp[4]; cubue[r[5]] = tmp[1];
        cubue[r[6]] = tmp[8]; cubue[r[7]] = tmp[5]; cubue[r[8]] = tmp[2];


    }
    public static void unrotate(char c) {
        rotate(c);rotate(c);rotate(c);
    }
    public static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            // 초기화
            Init();

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                char[] order = st.nextToken().toCharArray();
                if(order[1]=='+') {
                    rotate(order[0]);
                }else {
                    unrotate(order[0]);
                }
            }
            save();
        }
        print();
    }
    private static void print() {
        System.out.print(sb.toString());
    }
    public static void save() {
        for(int i=0;i<9;i++) {
            sb.append(cubue[i]);
            if((i+1)%3==0)
                sb.append('\n');
        }
    }
    public static void Init() {
        for(int i=0;i<white.length;i++) {
            cubue[white[i]]='w';
        }
        for(int i=0;i<red.length;i++) {
            cubue[red[i]]='r';
        }
        for(int i=0;i<blue.length;i++) {
            cubue[blue[i]]='b';
        }
        for(int i=0;i<green.length;i++) {
            cubue[green[i]]='g';
        }
        for(int i=0;i<orange.length;i++) {
            cubue[orange[i]]='o';
        }
        for(int i=0;i<yellow.length;i++) {
            cubue[yellow[i]]='y';
        }
    }
}