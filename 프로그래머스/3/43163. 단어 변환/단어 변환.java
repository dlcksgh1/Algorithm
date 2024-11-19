import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if(!Arrays.asList(words).contains(target)) return 0; // 단어가 없을경우 0 반환
        
        boolean[] visited = new boolean[words.length];
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        int steps = 0; // 변환 횟수
        
        while(!queue.isEmpty()) {
            
             int size = queue.size(); // 현재 단계에서 처리할 단어 개수
             for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return steps; // 목표 단어에 도달하면 변환 횟수 반환
                }

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && canTransform(current, words[j])) {
                        visited[j] = true; // 방문 처리
                        queue.offer(words[j]); // 다음 단계 탐색
                    }
                }
            }
            steps++; // 변환 횟수 증가
        }
        
        
        return 0; // 변환 불가능한 경우
    }
    
    private boolean canTransform(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}