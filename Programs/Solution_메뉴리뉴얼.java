package Programmers;

import java.util.*;

public class Solution_메뉴리뉴얼 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }

    static Map<String, Integer> map = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                char[] tochar = orders[j].toCharArray();
                Arrays.sort(tochar);
                chk(course[i], tochar);
            }
            int max = 0;
            for (String key :
                    map.keySet()) {
                max = max > map.get(key) ? max : map.get(key);
            }
            if (max != 1) {

                for (String key :
                        map.keySet()) {
                    if (map.get(key) == max) answer.add(key);
                }
            }
            map = new HashMap<>();
        }


        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    static boolean[] visit;

    public static void chk(int cnt, char[] target) {
        visit = new boolean[target.length];
        dfs(0, 0, cnt, target);
    }

    public static void dfs(int idx, int chkcnt, int cnt, char[] target) {
        if (chkcnt == cnt) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < target.length; i++) {
                if (visit[i]) sb.append(target[i]);
            }
            if (!map.containsKey(sb.toString())) map.put(sb.toString(), 1);
            else map.replace(sb.toString(), map.get(sb.toString()) + 1);
            return;
        }

        for (int i = idx; i < target.length; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(i + 1, chkcnt + 1, cnt, target);
            visit[i] = false;
        }
    }
}
