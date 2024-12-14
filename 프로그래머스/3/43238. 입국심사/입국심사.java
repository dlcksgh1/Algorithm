
/*
    시간을  1 ~ 시간이 가장 오래걸리는 심사관 * n
    을 두고 이분탐색
*/

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 1; //최소시간
        long right = (long) times[times.length -1] * n; //최대시간
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            long total = 0;
            for(int time : times) {
                total += mid / time;
            }
            
            if(total >= n) {
                answer = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}