import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i<= n ; i ++){
            if(isPrimeNumber(i)) answer++;
        }
        return answer;
    }

    public static boolean isPrimeNumber(int x) {
        
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
