import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<String> list;
    static boolean[] useTickets;
    
    public String[] solution(String[][] tickets) {
        list  = new ArrayList<>(); // 가능한 경로 값을 String 으로 저장한 list
        useTickets = new boolean[tickets.length];
        dfs(0,"ICN", "ICN", tickets);  // 이번 dfs 에서 주요한 것 depth, 현재경로, 지금까지 경로
        Collections.sort(list);

        return list.get(0).split(" ");
    }
    
    private static void dfs(int depth, String now, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!useTickets[i] && now.equals(tickets[i][0])) {
                useTickets[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                useTickets[i] = false;
            }
        }

    }
}