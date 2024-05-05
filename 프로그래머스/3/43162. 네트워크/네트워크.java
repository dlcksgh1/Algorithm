import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int size = 0;
        visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                size ++;
                bfs(i, n, computers);
            }
        }
        
        return size;
    }
    
     private static void bfs(int k, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        visited[k] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[a][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

