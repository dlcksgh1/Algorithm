import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);

        
        for(int i = 2 ; i*i <= n; i ++){
            if(arr[i]) {
                for(int j =i*i ; j <= n ; j+= i) {
                    arr[j] = false;
                }   
            }
        }
        
        for(int i = 2 ; i <= n ; i++) {
            if(arr[i]) answer ++;
        }
         
        return answer;
    }
}