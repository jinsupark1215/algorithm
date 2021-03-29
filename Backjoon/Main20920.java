package Backjoon;

import java.io.*;
import java.util.*;

public class Main20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if(input.length()>=M){
                map.put(input, map.getOrDefault(input, 1)+1);
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.count == o2.count){
                    if(o1.name.length() == o2.name.length()){
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.name.length() - o1.name.length();
                }
                return o2.count - o1.count;
            }
        });

        for(String key:map.keySet()){
            pq.add(new Point(key,map.get(key)));
        }

        while(!pq.isEmpty()){
            bw.write(pq.poll().name+"\n");
        }
        bw.flush();
    }
    static class Point{
        String name;
        int count;

        public Point(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
