/*
    그래프를 ArrayList 에 담아서 그래프를 만든다.
    
    bfs 를 사용하여 하나씩 제거 후 최소 차이를 구한다.

*/

import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int minDiff = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        for(int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }    
        
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires) {
            int nodeA = wire[0];
            int nodeB = wire[1];
            
            graph.get(nodeA).remove((Integer) nodeB);
            graph.get(nodeB).remove((Integer) nodeA);
            
            int sizeA = bfs(nodeA, n);
            int sizeB = n - sizeA;
            
            // 최소 차이 갱신
            minDiff = Math.min(minDiff, Math.abs(sizeA - sizeB));

            // 전선 복구
            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }
        
        
        return minDiff;
    }
    
    public int bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        int count = 0;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            
            for(int node2 : graph.get(node)) {
                if(!visited[node2]) {
                    visited[node2] = true;
                    queue.offer(node2);
                }
            }
        }
        
        return count;
        
    }
}