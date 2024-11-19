import java.util.*;

class Solution {
    
    static boolean[] visited; 
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n]; 
        int cnt = 0;
        for(int i = 0 ; i < n ; i ++) {
            if(!visited[i]) {
                bfs(computers, i);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    static void bfs(int[][] computers, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
        
            int node = queue.poll();
            
            for(int i = 0; i < computers.length; i++) {
                if(computers[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }   
        }
        
    }
}