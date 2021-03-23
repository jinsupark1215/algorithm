package Programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_Line1 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}
                , new String[]{"PYTHON", "C++", "SQL"}, new int[]{7, 5, 5}));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {

        MaxJob maxJob = new MaxJob(0,"");
        PriorityQueue<MaxJob> pq = new PriorityQueue<>(new Comparator<MaxJob>() {
            @Override
            public int compare(MaxJob o1, MaxJob o2) {
                if(o1.score == o2.score){
                return o1.name.compareTo(o2.name);
                }
                return o2.score-o1.score;
            }
        });
        for (int job = 0; job < 5; job++) {
            String[] what = table[job].split(" ");
            int score = 0;
            int length = languages.length;
            for (int i = 0; i < length; i++) {
                for (int j = 1; j <=5 ; j++) {
                    if(languages[i].equals(what[j])){
                        score += (6-j) * preference[i];
                        break;
                    }
                }
            }
            if(score >= maxJob.score){
                pq.add(new MaxJob(score,what[0]));
            }
        }


        return pq.poll().name;
    }

    static class MaxJob{
        int score;
        String name;



        public MaxJob(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }

}
