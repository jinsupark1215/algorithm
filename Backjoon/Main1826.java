package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1826 {
    /*
    [백준] 연료채우기
    1.주유소에 멈추는 횟수

    2.

    3. 우선순위 큐사용
     */
    static int N;
    static int[][] gas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        gas = new int[N+1][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            gas[i][0] = a;
            gas[i][1] = b;
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        gas[N][0] = L;

        Arrays.sort(gas, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        });

        int ans = 0;
        int left = P;
        for (int i=0; i<=N; i++) {

            if (i==0)
                left -= gas[i][0];
            else
                left -= (gas[i][0] - gas[i-1][0]);

            while (left < 0 && !pq.isEmpty()) {
                left += pq.poll();
                ans++;
            }

            if (left < 0) {
                ans = -1;
                break;
            }

            if (gas[i][0] >= L) {
                pq.clear();
                break;
            }

            pq.add(gas[i][1]);
        }

        System.out.println(ans);
    }
}
