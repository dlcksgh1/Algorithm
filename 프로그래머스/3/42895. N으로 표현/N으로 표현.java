/*
    •	숫자 N을 적절히 조합하여 다양한 수를 생성.
	•	각 횟수(1부터 8까지)에서 가능한 숫자 집합을 만들어 탐색.
	•	각 집합은 이전 집합을 조합하여 생성.
    
    
    
*/

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if(N == number) return 1;
        
        // DP 배열 초기화
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0 ; i <= 8 ; i ++) {
            dp.add(new HashSet<>());
        }
        
        // 1부터 8 까지 반복
        for(int i = 1; i <=8; i ++) {
            
            //우선 연속된 수부터 추가하자 
            int repeatedNum = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatedNum);
            
            // 이전단계의 dp조합으로 숫자 생성
            for(int j = 1; j < i ; j++) {
                for(int a : dp.get(j)) {
                    for(int b : dp.get(i - j)){
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if(b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            
            if(dp.get(i).contains(number)) {
                return i;
            }
            
        }
        
        return -1;
    }
}