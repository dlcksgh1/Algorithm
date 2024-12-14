
/*
    bfs 를 사용하여 최단경로를 사용하여 문제를 풀어보았지만
    최단경로의 개수를 구하는 문제는 처음임 
    우선 map에 웅덩이 넣기 
*/

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n+1][m+1];
        for(int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= m ; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위에서 오는경우 
                if(i > 1) {
                    dp[i][j] += dp[i-1][j];
                }
                
                // 왼쪽에서 오는경우
                if(j > 1) {
                    dp[i][j] += dp[i][j-1];
                }
                
                dp[i][j] %= 1000000007;
                
            }
        }
        
        return dp[n][m];
    }
}