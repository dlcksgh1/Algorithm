/*
    인접한 집은 못턴다 게미문제랑 비슷한
    dp 문제로 풀기
    
    점화식 
    
    dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
    
    집이 원형으로 연결되어 있으므로, 첫 번째 집과 마지막 집을 동시에 선택할 수 없습니다.
    
    1. 첫 번째 집을 선택하는 경우:
	•	마지막 집은 선택할 수 없습니다.
    
	2. 첫 번째 집을 선택하지 않는 경우:
	•	마지막 집은 자유롭게 선택 가능합니다.
*/

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        
        for(int i = 2; i < money.length -1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        
        return Math.max(dp1[money.length -2], dp2[money.length -1]);
    }
}