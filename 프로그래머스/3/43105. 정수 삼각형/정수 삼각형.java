
/*
    완전탐색이라고 생각했는데 높이가 500 이하이기 때문에 dp를 사용해야함 - 높이가 6정도이면 dfs 사용
    
    위에서 아래로가 아닌 아래에서 위로 가도록 설정
    아래에서 위로 계산하는 이유:
	1.	점화식이 현재 위치의 아래 두 값을 필요로 하므로, 아래에서 위로 계산해야 함.
	2.	중복 계산을 방지하고, 각 값을 한 번만 계산할 수 있음.
	3.	구현이 간단하며, 재귀 없이 반복문으로 처리 가능.
    위에서 아래로 풀 수도 있지만, 메모이제이션을 추가해야 하고, 구현이 더 복잡해집니다.
    
    
*/

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length; 
        int[][] dp = new int[n][n];
        
        // 마지막행을 그대로 복사(아래부터 시작)
        for(int i = 0; i < triangle[n-1].length; i++) {
            dp[n - 1][i] = triangle[n-1][i];
        }
        
        for(int i = n - 2; i >= 0 ; i--) {
            for(int j = 0 ; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}