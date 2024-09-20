import java.util.*;
class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        if(answer == 1 ) return -1;
        return answer;
    }
    
    static public int bfs(int[][] maps){
        Queue<Node> q = new LinkedList<>();   
        q.offer(new Node(0, 0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if(maps[nx][ny] == 1 ){
                    q.offer(new Node(nx, ny));
                    maps[nx][ny] = maps[node.x][node.y] +1;
                }
            }
        }
        return maps[maps.length -1][maps[0].length -1];
    }
}

class Node{
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}