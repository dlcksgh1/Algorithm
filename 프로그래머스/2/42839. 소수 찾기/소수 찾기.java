/*
    소수 판별 방법 
    1. 제곱근 까지 확인
    2. 에라토스테네스의 체 
    

*/

import java.util.*;


class Solution {
    
    static boolean[] visited;
    static Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
                
        visited = new boolean[numbers.length()];
        backtrack(numbers, "");
        
        int primeCnt = 0;
        for(int num : numberSet) {
            if(isPrime(num)) {
                primeCnt++;
            }
        }
        
        return primeCnt;
    }
    
    public void backtrack(String numbers, String current) {
        
        if(!current.isEmpty()) {
            numberSet.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtrack(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    
    // 제곱근
    public boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    // 에라토스테네스의 체
    public boolean[] eratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2 ; i <= Math.sqrt(n); i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}