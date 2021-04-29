package Backjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main1525 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int k = scan.nextInt();
                if(k == 0) {
                    k = 9;
                }
                start = (start*10) +k;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> m = new HashMap<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        m.put(start, 0);
        q.add(start);

        while(!q.isEmpty()) {
            int nowNum = q.poll();
            String now = String.valueOf(nowNum);
            int nine = now.indexOf("9");
            int x = nine / 3;
            int y = nine % 3;
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                int move = nx*3+ny;
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    StringBuilder next = new StringBuilder(now);
                    char temp = next.charAt(move);
                    next.setCharAt(move, '9');
                    next.setCharAt(nine, temp);
                    int nextNum = Integer.parseInt(next.toString());
                    if(!m.containsKey(nextNum)) {
                        m.put(nextNum, m.get(nowNum)+1);
                        q.add(nextNum);
                    }
                }
            }
        }
        if(m.containsKey(123456789)) {
            System.out.println(m.get(123456789));
        }
        else
            System.out.println(-1);
    }
}