/*
    최소 필요 피로도와 소모 피로도가 있다.
    이건 완전탐색으로 풀어야하는 문제
    visited 를 사용해서 해봐야할 듯 ?
    그러면 dfs 로 풀어보자 던전의 갯수가 8개니깐 가능함
    
*/


class Solution {
    
    static boolean[] visited;
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        visited = new boolean[dungeons.length];
        
        backtrack(0, dungeons, k);
        
        return max;
    }
    
    public void backtrack(int cnt, int[][] dungeons, int a) {
        if(max < cnt) {
            max = cnt;
        }
        
        for(int i = 0 ; i < dungeons.length; i++) {
            if(!visited[i] && a >= dungeons[i][0] ) {
                visited[i] = true;
                backtrack(cnt + 1, dungeons, a - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
    
}