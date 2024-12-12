import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + (second * 2);
            
            pq.offer(newScoville);
            answer++;
        }
        
        if(pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}