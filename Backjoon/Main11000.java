package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11000 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] course = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            course[i][0] = Integer.parseInt(st.nextToken());
            course[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(course, new Comparator<int []>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }

        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(course[0][1]);

        for(int i=1;i<N;i++) {
            if(course[i][0] < pq.peek()) {
                pq.offer(course[i][1]);
            }else {
                pq.poll();
                pq.offer(course[i][1]);
            }
        }

        System.out.println(pq.size());
    }
}
